package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dao.SidukMapper;
import com.example.dao.KeluargaMapper;
import com.example.model.KeluargaModel;
import com.example.model.PendudukModel;
import com.example.service.KeluargaService;
import com.example.service.SidukService;


@Controller
public class SidukController {
	@Autowired
	SidukService sidukDao;
	
	@Autowired
	KeluargaService keluargaDao;
	
	@RequestMapping("/")
    public String index()
    {
        return "index";
    }
	
	@RequestMapping("/penduduk")
	public String lihatPenduduk(
		Model model,
		@RequestParam(value = "nik") String nik)
	{
		PendudukModel penduduk = sidukDao.selectPenduduk(nik);
		
		if(penduduk!=null) {
		model.addAttribute("penduduk", penduduk);
		
		return "penduduk";
		} else {
			return "penduduk-not-found";
		}
	}
	
	@RequestMapping("/penduduk/tambah")
	public String tambahPenduduk (Model model) {
		PendudukModel penduduk = new PendudukModel();
		model.addAttribute("penduduk", penduduk);
		return "add-penduduk";
	}
		
	@RequestMapping(value = "/penduduk/tambah", method = RequestMethod.POST)
    public String tambahPenduduk(Model model, @ModelAttribute PendudukModel penduduk)
    {
		penduduk.generateNik(keluargaDao, sidukDao);
		sidukDao.addPenduduk(penduduk);
		model.addAttribute("nik", penduduk.getNik());
        return "success-add-penduduk";
    }
	
	
	


}
