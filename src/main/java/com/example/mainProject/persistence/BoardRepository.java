package com.example.mainProject.persistence;


import com.example.mainProject.domain.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {
}