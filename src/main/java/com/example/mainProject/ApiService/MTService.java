package com.example.mainProject.ApiService;


import com.example.mainProject.dto.MTInfo;

import java.util.List;

public interface MTService {
    List<MTInfo> getMTInfoList(MTInfo mtInfo);
    MTInfo getMTInfo(MTInfo mtInfo);
}