package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.KeluargaModel;
import com.example.dao.KeluargaMapper;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KeluargaServiceDatabase implements KeluargaService
{
    @Autowired
    private KeluargaMapper keluargaMapper;
    
    @Override
    public KeluargaModel selectKeluarga (String nkk)
    {
        log.info ("select penduduk with nkk");
        return keluargaMapper.selectKeluarga(nkk);
    }

	@Override
	public KeluargaModel getKeluarga(int id) {
		log.info("select keluarga with nkk");
		return keluargaMapper.getKeluarga(id);
	}


}
