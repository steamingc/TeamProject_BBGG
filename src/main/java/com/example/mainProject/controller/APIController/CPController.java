package com.example.mainProject.controller.APIController;


import com.example.mainProject.ApiService.CPService;
import com.example.mainProject.config.BoardService.BoardService;
import com.example.mainProject.domain.Board;
import com.example.mainProject.dto.CPInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@ComponentScan(basePackages = {"package com.example.mainProject.ApiService.CPService"})
public class CPController {

    @Autowired
    private BoardService boardService;
    @Autowired
    private CPService cpService;

    //----------READ---------
    //게시글 상세
    @GetMapping("/getCP")
    public String getBoard(CPInfo cpInfo, Model model, Board board) {
        List<Board> boardList = boardService.getBoardList(board);
        model.addAttribute("boardList", boardList);

        model.addAttribute("cpInfo", cpService.getCPInfo(cpInfo));
        return "getCP";
    }

    //게시글목록
    @RequestMapping("/getCPList")
    public String getBoardList(Model model, CPInfo cpInfo) {
        List<CPInfo> cpInfoList = cpService.getCPInfoList(cpInfo);

        model.addAttribute("cpInfoList", cpInfoList);
        return "getCPList";
    }
}

