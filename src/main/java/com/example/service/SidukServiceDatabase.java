package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.KeluargaMapper;
import com.example.dao.SidukMapper;

import com.example.model.PendudukModel;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SidukServiceDatabase implements SidukService
{
    @Autowired
    private SidukMapper sidukMapper;
    
    @Autowired
    private KeluargaMapper keluargaMapper;
    
    @Override
    public PendudukModel selectPenduduk (String nik)
    {
        log.info ("select penduduk with nik {}", nik);
        return sidukMapper.selectPenduduk (nik);
    }
    
	@Override
    public void addPenduduk(PendudukModel penduduk) {
    	log.info ("add penduduk");
    	sidukMapper.addPenduduk(penduduk);
    }
	
}
