package com.example.mainProject.domain.entity.BoardService;

import com.example.mainProject.domain.Board;

import java.util.List;

public interface BoardService {
    List<Board> getBoardList(Board board);
    void insertBoard(Board board);
    Board getBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard(Board board);

    Board boardView(Board board);

}
