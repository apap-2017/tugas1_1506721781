package com.example.service;

import org.springframework.ui.Model;

import com.example.model.KeluargaModel;

public interface KeluargaService {
	KeluargaModel selectKeluarga(String nkk);
	KeluargaModel getKeluarga(int id);
}
