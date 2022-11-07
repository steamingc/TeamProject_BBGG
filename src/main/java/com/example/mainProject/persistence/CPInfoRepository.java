package com.example.mainProject.persistence;

import com.example.mainProject.dto.CPInfo;
import com.example.mainProject.dto.GHInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CPInfoRepository extends JpaRepository<CPInfo, Long> {
    @Query(value = "SELECT * FROM cpinfo c WHERE c.TRDSTATEGBN='1' AND ROWNUM <= 10", nativeQuery = true)
    List<CPInfo> findByBN(@Param("TRDSTATEGBN") String TRDSTATEGBN);
}
