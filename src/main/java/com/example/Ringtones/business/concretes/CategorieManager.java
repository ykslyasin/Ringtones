package com.example.Ringtones.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ringtones.business.abstracts.CategorieService;
import com.example.Ringtones.core.dataAccess.UserDao;
import com.example.Ringtones.dataAccess.CategorieDao;
import com.example.Ringtones.entities.concretes.Categories;

@Service
public class CategorieManager implements CategorieService{

	private CategorieDao categorieDao;
	
	@Autowired
	public CategorieManager(CategorieDao categorieDao) {
		super();
		this.categorieDao = categorieDao;
	}
	
	@Override
	public List<Categories> getAll() {
		
		return this.categorieDao.findAll();
	}

}
