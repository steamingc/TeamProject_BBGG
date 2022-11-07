package com.example.mainProject.controller.APIController;

import com.example.mainProject.ApiService.MTService;
import com.example.mainProject.config.BoardService.BoardService;
import com.example.mainProject.domain.Board;
import com.example.mainProject.dto.MTInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@ComponentScan(basePackages = {"package com.example.mainProject.ApiService.MTService"})
public class MTController {

    @Autowired
    private BoardService boardService;
    @Autowired
    private MTService mtService;

    //----------READ---------
    //게시글 상세
    @GetMapping("/getMT")
    public String getBoard(MTInfo mtInfo, Model model, Board board) {
        List<Board> boardList = boardService.getBoardList(board);
        model.addAttribute("boardList", boardList);

        model.addAttribute("mtInfo", mtService.getMTInfo(mtInfo));
        return "getMT";
    }

    //게시글목록
    @RequestMapping("/getMTList")
    public String getBoardList(Model model, MTInfo mtInfo) {
        List<MTInfo> mtInfoList = mtService.getMTInfoList(mtInfo);

        model.addAttribute("mtInfoList", mtInfoList);
        return "getMTList";
    }
}

