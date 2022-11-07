package com.example.mainProject.dto;

import com.example.mainProject.domain.entity.Booking;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class GHInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long SMM_SEQ;
    private String SMM_GUBUN;
    private String SMM_AREA;
    private String SMM_LANG;
    private String SMM_NAME;
    private String SMM_ADDR;
    private String SMM_HOMEPAGE;
    private String SMM_IMG;
    private String SMM_IMG_PATH;
    private String SMM_LATITUDE;
    private String SMM_LONGITUDE;
    private String SMM_USE;

    private String image;

    @OneToMany(mappedBy = "api")
    private List<Booking> bookingList = new ArrayList<>();

    public GHInfo(Long SMM_SEQ, String SMM_GUBUN, String SMM_AREA, String SMM_LANG
            , String SMM_NAME, String SMM_ADDR, String SMM_HOMEPAGE, String SMM_IMG
            , String SMM_IMG_PATH, String SMM_LATITUDE, String SMM_LONGITUDE
            , String SMM_USE) {
        this.SMM_SEQ = SMM_SEQ;
        this.SMM_GUBUN = SMM_GUBUN;
        this.SMM_AREA = SMM_AREA;
        this.SMM_LANG = SMM_LANG;
        this.SMM_NAME = SMM_NAME;
        this.SMM_ADDR = SMM_ADDR;
        this.SMM_HOMEPAGE = SMM_HOMEPAGE;
        this.SMM_IMG = SMM_IMG;
        this.SMM_IMG_PATH = SMM_IMG_PATH;
        this.SMM_LATITUDE = SMM_LATITUDE;
        this.SMM_LONGITUDE = SMM_LONGITUDE;
        this.SMM_USE = SMM_USE;
    }

    public GHInfo() {

    }
}