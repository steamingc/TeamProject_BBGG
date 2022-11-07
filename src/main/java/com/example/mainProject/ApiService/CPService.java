package com.example.mainProject.ApiService;

import com.example.mainProject.dto.CPInfo;
import com.example.mainProject.dto.GHInfo;

import java.util.List;

public interface CPService {
    List<CPInfo> getCPInfoList(CPInfo cpInfo);
    CPInfo getCPInfo(CPInfo cpInfo);
}