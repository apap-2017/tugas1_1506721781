package com.example.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import com.example.service.KeluargaService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeluargaModel {
	private String id;
	private String nomor_kk;
	private String alamat;
	private String RT;
	private String RW;
	private String id_kelurahan;
	private boolean is_tidak_berlaku;
	private String nama_kelurahan;
	private String nama_kecamatan;
	private String nama_kota;
	private String kode_kecamatan;
	List<PendudukModel> penduduk;
	
}
