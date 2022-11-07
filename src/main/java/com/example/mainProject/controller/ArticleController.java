package com.example.mainProject.controller;

import com.example.mainProject.ApiService.GHService;
import com.example.mainProject.config.BoardService.BoardService;
import com.example.mainProject.domain.Board;
import com.example.mainProject.dto.GHInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private GHService ghService;

    @Autowired
    private BoardService boardService;

    // 메인 페이지
    @GetMapping("/")
    public String index(Model model, Board board) {
        List<Board> boardList = boardService.getBoardList(board);

        model.addAttribute("boardList", boardList);
        return "main/index";
    }

    @GetMapping("/index")
    public String indexForm(Model model, Board board) {
            List<Board> boardList = boardService.getBoardList(board);

            model.addAttribute("boardList", boardList);
        return "main/index";
    }

    @GetMapping("/GHList")
    public String guestHouseList(Model model, Board board, GHInfo ghInfo) {
        List<Board> boardList = boardService.getBoardList(board);
        model.addAttribute("boardList", boardList);

        List<GHInfo> ghInfoList = ghService.getGHInfoListKor(ghInfo);
        model.addAttribute("ghInfoList", ghInfoList);

        return "roomList/GHList";
    }


    @GetMapping("/HTList1")
    public String hotelList1(Model model, Board board) {
        List<Board> boardList = boardService.getBoardList(board);

        model.addAttribute("boardList", boardList);
        return "roomList/HTList1";
    }

    @GetMapping("/HTList2")
    public String hotelList2(Model model, Board board) {
        List<Board> boardList = boardService.getBoardList(board);

        model.addAttribute("boardList", boardList);
        return "roomList/HTList2";
    }

    @GetMapping("/MTList")
    public String motelList(Model model, Board board) {
        List<Board> boardList = boardService.getBoardList(board);

        model.addAttribute("boardList", boardList);
        return "roomList/MTList";
    }

    @GetMapping("/CPList")
    public String campingList(Model model, Board board) {
        List<Board> boardList = boardService.getBoardList(board);

        model.addAttribute("boardList", boardList);
        return "roomList/CPList";
    }


    @GetMapping("/about")
    public String aboutForm() {
        return "main/about";
    }

    @GetMapping("/booking")
    public String bookingForm() {
        return "main/booking";
    }

    @GetMapping("/contact")
    public String contactForm() {
        return "main/contact";
    }

    @GetMapping("/service")
    public String serviceForm() {
        return "main/service";
    }


    @GetMapping("/testimonial")
    public String testimonialForm() {
        return "main/testimonial";
    }

    @GetMapping("/errorPage")
    public String errorPage() {
        return "errorPage";
    }




}
