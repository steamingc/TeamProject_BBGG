package com.example.mainProject.controller.RestTest;


import com.example.mainProject.dto.GHInfo;
import com.example.mainProject.persistence.GHInfoRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@RestController
public class GHRestTestController {
    @Autowired
    private GHInfoRepository ghinfoRepository;

    //게스트하우스
    @GetMapping("/ghapi")
    public String load_save(Model model) throws IOException, ParseException {
        StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /*URL*/
        urlBuilder.append("/" + URLEncoder.encode("776a776a4f666b643931564c50626a", "UTF-8")); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
        urlBuilder.append("/" + URLEncoder.encode("json", "UTF-8")); /*요청파일타입 (xml,xmlf,xls,json) */
        urlBuilder.append("/" + URLEncoder.encode("ViewShpMapMst", "UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/
        urlBuilder.append("/" + URLEncoder.encode("1", "UTF-8")); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
        urlBuilder.append("/" + URLEncoder.encode("766", "UTF-8")); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/
        // 상위 5개는 필수적으로 순서바꾸지 않고 호출해야 합니다.

        // 서비스별 추가 요청 인자이며 자세한 내용은 각 서비스별 '요청인자'부분에 자세히 나와 있습니다.
        urlBuilder.append("/" + URLEncoder.encode("", "UTF-8")); /* 서비스별 추가 요청인자들*/

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/xml");
        System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
        BufferedReader rd;

        // 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
//        System.out.println(sb.toString());



        // JSONObject로 parse
        JSONParser parser = new JSONParser();
        JSONObject Obj = (JSONObject) parser.parse(sb.toString());

        //json 파일 받아옴
        JSONObject parseResult = (JSONObject) Obj;

        //ListKor 받아옴
        JSONObject parseListKor = (JSONObject) parseResult.get("ViewShpMapMst");

        // jsonObject("ListKor")에서 jsonArray("row")를 get함
        JSONArray jsonArr = (JSONArray)parseListKor.get("row");

        String totals = "";

        // jsonArr에서 하나씩 JSONObject로 cast해서 사용
        if (jsonArr.size() > 0){
            for(int i=0; i<jsonArr.size(); i++){
                JSONObject jsonObj = (JSONObject)jsonArr.get(i);

                GHInfo infoObj = new GHInfo(i+(long)1, (String)jsonObj.get("SMM_GUBUN"),
                        (String)jsonObj.get("SMM_AREA"), (String)jsonObj.get("SMM_LANG"), (String)jsonObj.get("SMM_NAME"),
                        (String)jsonObj.get("SMM_ADDR"),(String)jsonObj.get("SMM_HOMEPAGE"), (String)jsonObj.get("SMM_IMG"),
                        (String)jsonObj.get("SMM_IMG_PATH"), (String)jsonObj.get("SMM_LATITUDE"), (String)jsonObj.get("SMM_LONGITUDE"),
                        (String)jsonObj.get("SMM_USE"));
                ghinfoRepository.save(infoObj);


                //필요한 정보만 가져오기 (조건)
//                if(((String)jsonObj.get("SMM_NAME")).equals("삼청각")) {
//                    String s = "사업장 명 : " + (String)jsonObj.get("SMM_NAME") + "<br>주소 : " + (String)jsonObj.get("SMM_ADDR") + "<br>사이트 : " + (String)jsonObj.get("SMM_HOMEPAGE");
//                    totals += s;
//                }

                //정보 가져오기
//                String s = (String)jsonObj.get("SMM_NAME");
//                System.out.println(s);
//                totals += s + "<br>";
            }

        }

        return totals;

    }
}
