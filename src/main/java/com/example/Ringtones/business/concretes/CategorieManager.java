package com.example.Ringtones.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ringtones.business.abstracts.CategorieService;
import com.example.Ringtones.core.dataAccess.UserDao;
import com.example.Ringtones.core.utilities.results.DataResult;
import com.example.Ringtones.core.utilities.results.Result;
import com.example.Ringtones.core.utilities.results.SuccessDataResult;
import com.example.Ringtones.core.utilities.results.SuccessResult;
import com.example.Ringtones.dataAccess.CategorieDao;
import com.example.Ringtones.entities.concretes.Categories;
import com.example.Ringtones.entities.concretes.Ringtone;

@Service
public class CategorieManager implements CategorieService{

	private CategorieDao categorieDao;
	
	@Autowired
	public CategorieManager(CategorieDao categorieDao) {
		super();
		this.categorieDao = categorieDao;
	}
	
	/*@Override
	public List<Categories> getAll() {
		
		return this.categorieDao.findAll();
	}*/
	
	@Override
	public DataResult<List<Categories>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Categories>>
		(this.categorieDao.findAll(), "Data listelendi." );
				
	}
	
	@Override
	public Result add(Categories categories) {
		this.categorieDao.save(categories);
		return new SuccessResult("Zil sesi eklendi.");
	}

}
