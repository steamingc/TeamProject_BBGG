package com.example.mainProject.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class MTInfo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long SEQ;

    private String MAIN_KEY;   //메인키

    private String NAME_KOR;  //이름

    private String H_KOR_CITY;  //행정 시

    private String H_KOR_GU;  //행정 구

    private String H_KOR_DONG;  //행정 동

    private String image;

    public MTInfo() {
    }

    public MTInfo(Long SEQ, String MAIN_KEY, String NAME_KOR, String H_KOR_CITY, String H_KOR_GU, String H_KOR_DONG) {
        this.SEQ = SEQ;
        this.MAIN_KEY = MAIN_KEY;
        this.NAME_KOR = NAME_KOR;
        this.H_KOR_CITY = H_KOR_CITY;
        this.H_KOR_GU = H_KOR_GU;
        this.H_KOR_DONG = H_KOR_DONG;
    }

}
