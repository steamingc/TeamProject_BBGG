package com.example.mainProject.service;


import com.example.mainProject.ApiService.HTService;
import com.example.mainProject.dto.HTInfo;
import com.example.mainProject.persistence.HTInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HTServiceImpl implements HTService {
        @Autowired
    private HTInfoRepository htInfoRepo;
    @Override
    public List<HTInfo> getHTInfoList(HTInfo htInfo) {
        return (List<HTInfo>) htInfoRepo.findAll();
    }

    @Override
    public HTInfo getHTInfo(HTInfo htInfo) {
        return htInfoRepo.findById(htInfo.getSEQ()).get();
    }
}

