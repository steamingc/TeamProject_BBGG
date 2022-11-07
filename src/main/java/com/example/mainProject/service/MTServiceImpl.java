package com.example.mainProject.service;



import com.example.mainProject.ApiService.MTService;
import com.example.mainProject.dto.HTInfo;
import com.example.mainProject.dto.MTInfo;
import com.example.mainProject.persistence.MTInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MTServiceImpl implements MTService {

    @Autowired
    private MTInfoRepository mtInfoRepo;

    @Override
    public List<MTInfo> getMTInfoList(MTInfo mtInfo) {
        return (List<MTInfo>) mtInfoRepo.findAll();
    }

    @Override
    public MTInfo getMTInfo(MTInfo mtInfo) {
        return mtInfoRepo.findById(mtInfo.getSEQ()).get();
    }
}

