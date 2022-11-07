package com.example.mainProject.controller.APIController;


import com.example.mainProject.ApiService.GHService;
import com.example.mainProject.config.BoardService.BoardService;
import com.example.mainProject.domain.Board;
import com.example.mainProject.dto.GHInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@ComponentScan(basePackages = {"package com.example.mainProject.ApiService.GHService"})
public class GHController {
    @Autowired
    private GHService ghService;

    @Autowired
    private BoardService boardService;

    //----------READ---------
    //게시글 상세
    @GetMapping("/getGH")
    public String getBoard(GHInfo ghInfo, Model model, Board board) {
        List<Board> boardList = boardService.getBoardList(board);
        model.addAttribute("boardList", boardList);


        model.addAttribute("ghInfo", ghService.getGHInfo(ghInfo));
        return "getGH";
    }


    //게시글목록
    @RequestMapping("/getGHList")
    public String getBoardList(Model model, GHInfo ghInfo) {
        List<GHInfo> ghInfoList = ghService.getGHInfoListKor(ghInfo);

        model.addAttribute("ghInfoList", ghInfoList);
        return "getGHList";
    }
}

