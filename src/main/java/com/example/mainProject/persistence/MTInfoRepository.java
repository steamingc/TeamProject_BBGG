package com.example.mainProject.persistence;

import com.example.mainProject.dto.MTInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MTInfoRepository extends JpaRepository<MTInfo, Long> {

    @Override
    @Query(value = "SELECT * FROM mtinfo m WHERE ROWNUM <= 10", nativeQuery = true)
    List<MTInfo> findAll();

}
