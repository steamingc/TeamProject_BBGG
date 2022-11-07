package com.example.mainProject.controller;

import com.example.mainProject.config.BoardService.BoardService;
import com.example.mainProject.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    //----------READ---------
    //게시글 상세
    @GetMapping("/getBoard")
    public String getBoard(Board board, Model model) {
        model.addAttribute("board", boardService.getBoard(board));
        return "getBoard";
    }

    //게시글목록
//    @RequestMapping("/getBoardList")
//    public String getBoardList(Model model, Board board) {
//        List<Board> boardList = boardService.getBoardList(board);
//
//        model.addAttribute("boardList", boardList);
//        return "getBoardList";
//    }

    //----------CREATE---------
    //게시글 등록
    @GetMapping("/insertBoard")
    public String insertBoardView() {
        return "insertBoard";
    }

    //게시글 등록
    @PostMapping("/insertBoard")
    public String insertBoard(Board board){
        boardService.insertBoard(board);
        return "redirect:getBoardList";
    }

    //----------UPDATE---------
    //게시글 수정
    @GetMapping("/board/modify/{seq}")
    public String boardModify(Board board, Model model) {
        model.addAttribute("board", boardService.boardView(board));
        return "boardModify";
    }


    @PostMapping("/updateBoard/{seq}")
    public String updateBoard(@PathVariable("seq") Long seq, Board board) throws Exception {
        //기존에 있던 글이 담겨져서 온다
        Board boardTemp = boardService.boardView(board);

        //기존에 있던 내용을 새로운 내용으로 덮어씌운다.
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        boardService.insertBoard(boardTemp);  //추가-> 수정한 내용을 boardService의 write부분에 넣기
        return "redirect:/getBoardList";
    }


    //----------DELETE---------
    //게시글 삭제
    @GetMapping("/deleteBoard")
    public String deleteBoard(Board board) {
        boardService.deleteBoard(board);
        return "forward:getBoardList";
    }


}
