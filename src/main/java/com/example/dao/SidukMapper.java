package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.model.PendudukModel;
import com.example.model.KotaModel;
import com.example.model.KecamatanModel;
import com.example.model.KeluargaModel;
import com.example.model.KelurahanModel;

@Mapper
public interface SidukMapper {
	@Select("select * from penduduk join keluarga join kelurahan join kecamatan join kota "
			+ "on penduduk.id_keluarga=keluarga.id and keluarga.id_kelurahan=kelurahan.id "
			+ "and kelurahan.id_kecamatan=kecamatan.id and kecamatan.id_kota=kota.id "
			+ "where nik = #{nik}")
	
    PendudukModel selectPenduduk (@Param("nik") String nik);
	
	@Insert("insert into penduduk (nik, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, is_wni,"
			+ " id_keluarga, agama, pekerjaan, status_perkawinan, status_dalam_keluarga, "
			+ " golongan_darah, is_wafat)"
    		+ " VALUES ('${nik}', '${nama}', '${tempat_lahir}', '${tanggal_lahir}', ${jenis_kelamin},"
    		+ " ${is_wni}, '${id_keluarga}', '${agama}', '${pekerjaan}', '${status_perkawinan}', "
    		+ " '${status_dalam_keluarga}', '${golongan_darah}',"
    		+ " '${is_wafat}')")
    void addPenduduk (PendudukModel penduduk);
	
}
