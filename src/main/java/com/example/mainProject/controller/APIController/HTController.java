package com.example.mainProject.controller.APIController;

import com.example.mainProject.ApiService.HTService;
import com.example.mainProject.config.BoardService.BoardService;
import com.example.mainProject.domain.Board;
import com.example.mainProject.dto.HTInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@ComponentScan(basePackages = {"package com.example.mainProject.ApiService.HTService"})
public class HTController {

    @Autowired
    private BoardService boardService;
    @Autowired
    private HTService htService;

    //----------READ---------
    //게시글 상세
    @GetMapping("/getHT")
    public String getBoard(HTInfo htInfo, Model model, Board board) {
        List<Board> boardList = boardService.getBoardList(board);
        model.addAttribute("boardList", boardList);

        model.addAttribute("htInfo", htService.getHTInfo(htInfo));
        return "getHT";
    }

    //게시글목록
    @RequestMapping("/getHTList")
    public String getBoardList(Model model, HTInfo htInfo) {
        List<HTInfo> htInfoList = htService.getHTInfoList(htInfo);

        model.addAttribute("htInfoList", htInfoList);
        return "getHTList";
    }
}

