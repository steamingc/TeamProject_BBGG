package com.example.mainProject.ApiService;

import com.example.mainProject.dto.HTInfo;

import java.util.List;

public interface HTService {
    List<HTInfo> getHTInfoList(HTInfo htInfo);
    HTInfo getHTInfo(HTInfo htInfo);
}