package com.example.mainProject.persistence;

import com.example.mainProject.dto.CPInfo;
import com.example.mainProject.dto.HTInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HTInfoRepository extends JpaRepository<HTInfo, Long> {

    @Override
    @Query(value = "SELECT * FROM htinfo h WHERE h.H_KOR_GU LIKE '%종로%' AND ROWNUM <= 10", nativeQuery = true)
    List<HTInfo> findAll();

}
