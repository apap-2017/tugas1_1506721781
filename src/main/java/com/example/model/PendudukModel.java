package com.example.model;

import java.util.StringTokenizer;

import com.example.service.KeluargaService;
import com.example.service.SidukService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class PendudukModel {
	private String id;
	private String nik;
	private String nama;
	private String tempat_lahir;
	private String tanggal_lahir;
	private String kewarganegaraan;
	private int jenis_kelamin;
	private int is_wni;
	private int id_keluarga;
	private String agama;
	private String pekerjaan;
	private String status_perkawinan;
	private String status_dalam_keluarga;
	private String golongan_darah;
	private String wafat;
	private int is_wafat;
	private String alamat;
	private String RT;
	private String RW;
	private String nama_kota;
	private String nama_kecamatan;
	private String nama_kelurahan;
	
	
	public void generateNik(KeluargaService keluargaDao, SidukService sidukDao) {
		StringTokenizer tanggalLahirTokenizer = new StringTokenizer(this.getTanggal_lahir(), "-");
		String tahunLahir = tanggalLahirTokenizer.nextToken().substring(2);
		String bulanLahir = tanggalLahirTokenizer.nextToken();
		String tanggalLahir = tanggalLahirTokenizer.nextToken();
		
		
		KeluargaModel keluarga = keluargaDao.getKeluarga(this.getId_keluarga());
		
		long nik = Long.parseLong(keluarga.getKode_kecamatan().substring(0,6) + tanggalLahir + bulanLahir + tahunLahir + "0001");
		
		if (this.getJenis_kelamin()==1){
			nik = nik + (4000* 1000000);
		} else {
			nik = nik; }
		while(true) {
			PendudukModel checker = sidukDao.selectPenduduk(""+nik);
			if(checker != null) {
				nik++;
			}else {
				break;
			}
		}
		this.setNik(""+nik);
	}
}
