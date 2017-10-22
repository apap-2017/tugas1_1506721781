package com.example.service;

import com.example.model.PendudukModel;

public interface SidukService {

	PendudukModel selectPenduduk(String nik);
	void addPenduduk(PendudukModel penduduk);
}
