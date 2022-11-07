package com.example.mainProject.service;

import com.example.mainProject.ApiService.CPService;
import com.example.mainProject.dto.CPInfo;
import com.example.mainProject.dto.GHInfo;
import com.example.mainProject.persistence.CPInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CPServiceImpl implements CPService {
    @Autowired
    private CPInfoRepository cpInfoRepo;

    @Override
    public List<CPInfo> getCPInfoList(CPInfo cpInfo) {
        return (List<CPInfo>) cpInfoRepo.findByBN(cpInfo.getTRDSTATEGBN());
    }

    @Override
    public CPInfo getCPInfo(CPInfo cpInfo) {
        return cpInfoRepo.findById(cpInfo.getSEQ()).get();
    }
}

