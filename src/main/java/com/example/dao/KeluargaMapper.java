package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;

import com.example.model.PendudukModel;
import com.example.model.KotaModel;
import com.example.model.KecamatanModel;
import com.example.model.KeluargaModel;
import com.example.model.KelurahanModel;

@Mapper
public interface KeluargaMapper {
	
	@Select("SELECT * FROM penduduk JOIN keluarga "
			+ " ON penduduk.id_keluarga = keluarga.id WHERE nomor_kk = #{nkk}")
	List<PendudukModel> selectPenduduk(@Param("nkk") String nkk);
	@Select("SELECT * FROM keluarga JOIN kelurahan JOIN kecamatan JOIN kota"
			+ " ON keluarga.id_kelurahan = kelurahan.id AND kelurahan.id_kecamatan = kecamatan.id "
			+ " AND kecamatan.id_kota = kota.id"
			+ " WHERE nomor_kk = #{nkk}")
    @Results(value = {
    		@Result(property="nomor_kk", column="nomor_kk"),
    		@Result(property="alamat", column="alamat"),
    		@Result(property="RT", column="RT"),
    		@Result(property="RW", column="RW"),
    		@Result(property="nama_kelurahan", column="nama_kelurahan"),
    		@Result(property="nama_kecamatan", column="nama_kecamatan"),
    		@Result(property="kode_kecamatan", column="kode_kecamatan"),
    		@Result(property="nama_kota", column="nama_kota"),
    		@Result(property="penduduk", column="nomor_kk",
    		javaType = List.class,
    		many=@Many(select="selectPenduduk"))
    })
    KeluargaModel selectKeluarga(@Param("nkk") String nkk);
	
	@Select("SELECT * FROM keluarga JOIN kelurahan JOIN kecamatan JOIN kota"
			+ " ON keluarga.id_kelurahan = kelurahan.id AND kelurahan.id_kecamatan = kecamatan.id "
			+ " AND kecamatan.id_kota = kota.id"
			+ " WHERE keluarga.id = #{id}")
    @Results(value = {
    		@Result(property="nomor_kk", column="nomor_kk"),
    		@Result(property="alamat", column="alamat"),
    		@Result(property="RT", column="RT"),
    		@Result(property="RW", column="RW"),
    		@Result(property="nama_kelurahan", column="nama_kelurahan"),
    		@Result(property="nama_kecamatan", column="nama_kecamatan"),
    		@Result(property="kode_kecamatan", column="kode_kecamatan"),
    		@Result(property="nama_kota", column="nama_kota"),
    		@Result(property="penduduks", column="nomor_kk",
    		javaType = List.class,
    		many=@Many(select="selectPenduduks"))
    })
    KeluargaModel getKeluarga(@Param("id") int id); 
	
}
