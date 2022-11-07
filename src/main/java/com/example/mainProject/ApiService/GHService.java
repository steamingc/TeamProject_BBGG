package com.example.mainProject.ApiService;

import com.example.mainProject.dto.GHInfo;

import java.util.List;

public interface GHService {
    List<GHInfo> getGHInfoList(GHInfo ghInfo);
    GHInfo getGHInfo(GHInfo ghInfo);

    List<GHInfo> getGHInfoListKor(GHInfo ghInfo);
}