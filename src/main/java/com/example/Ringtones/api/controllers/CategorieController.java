package com.example.Ringtones.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ringtones.business.abstracts.CategorieService;
import com.example.Ringtones.business.abstracts.RingtoneService;
import com.example.Ringtones.entities.concretes.Categories;
import com.example.Ringtones.entities.concretes.Ringtone;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {

	private CategorieService categorieService;
	
	@Autowired
	public CategorieController(CategorieService categorieService) {
		super();
		this.categorieService = categorieService;
	}
	
	
	@GetMapping("/getall")
	public List<Categories> getAll() {
		return this.categorieService.getAll();
	}
	
}
