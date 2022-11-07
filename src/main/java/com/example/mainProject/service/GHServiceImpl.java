package com.example.mainProject.service;

import com.example.mainProject.ApiService.GHService;
import com.example.mainProject.dto.GHInfo;
import com.example.mainProject.persistence.GHInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GHServiceImpl implements GHService {
    @Autowired
    private GHInfoRepository ghInfoRepo;

    @Override
    public List<GHInfo> getGHInfoList(GHInfo ghInfo) {
        return (List<GHInfo>) ghInfoRepo.findAll();
    }

    @Override
    public GHInfo getGHInfo(GHInfo ghInfo) {
        return ghInfoRepo.findById(ghInfo.getSMM_SEQ()).get();
    }

    @Override
    public List<GHInfo> getGHInfoListKor(GHInfo ghInfo) {
        return (List<GHInfo>)ghInfoRepo.findByKor(ghInfo.getSMM_LANG(), ghInfo.getSMM_ADDR(), ghInfo.getSMM_SEQ());
    }
}

