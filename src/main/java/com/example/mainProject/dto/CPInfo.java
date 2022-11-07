package com.example.mainProject.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CPInfo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long SEQ;

    private String MGTNO;   //관리번호

    private String BPLCNM;  //이름

    private String RDNWHLADDR;  //도로명 주소

    private String SITETEL; //전화번호

    private String TRDSTATEGBN; //영업상태코드 (1 : 영업, 3 : 폐업)

    private String image;

    public CPInfo() {
    }

    public CPInfo(Long SEQ, String MGTNO, String BPLCNM, String RDNWHLADDR, String SITETEL, String TRDSTATEGBN) {
        this.SEQ = SEQ;
        this.MGTNO = MGTNO;
        this.BPLCNM = BPLCNM;
        this.RDNWHLADDR = RDNWHLADDR;
        this.SITETEL = SITETEL;
        this.TRDSTATEGBN = TRDSTATEGBN;
    }

}
