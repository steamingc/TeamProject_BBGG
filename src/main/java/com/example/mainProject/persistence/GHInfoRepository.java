package com.example.mainProject.persistence;

import com.example.mainProject.dto.GHInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GHInfoRepository extends JpaRepository<GHInfo, Long> {
//    @Query(value = "SELECT * FROM ghinfo g WHERE g.smm_name = ?1", nativeQuery = true)
//    List<GHInfo> findByName(@Param("smm_name") String smm_name);

//    @Query(value = "SELECT * FROM ghinfo g WHERE g.line_num = ?1", nativeQuery = true)
//    List<GHInfo> findByLine(@Param("line_num") String line_num);

    @Query(value = "SELECT * FROM ghinfo g WHERE g.SMM_ADDR LIKE '%서울%종로%' AND g.SMM_LANG = 'KOR' AND ROWNUM <= 10", nativeQuery = true)
    List<GHInfo> findByKor(@Param("smm_lang") String smm_lang, @Param("smm_addr") String smm_addr, @Param("smm_seq") Long smm_seq);
}