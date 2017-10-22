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

import com.example.dao.KeluargaMapper;
import com.example.model.KeluargaModel;
import com.example.model.PendudukModel;
import com.example.service.KeluargaService;


@Controller
public class KeluargaController {
	@Autowired
	KeluargaService keluargaDao;
	
	@RequestMapping("/keluarga")
	public String viewKeluarga(
		Model model,
		@RequestParam(value = "nkk") String nkk)
	{
		KeluargaModel keluarga = keluargaDao.selectKeluarga(nkk);
		if (keluarga != null) {
			 model.addAttribute ("keluarga", keluarga);
	            return "keluarga";
		}else {
            model.addAttribute ("nkk", nkk);
            return "keluarga-not-found";
		}
	}
	



}

