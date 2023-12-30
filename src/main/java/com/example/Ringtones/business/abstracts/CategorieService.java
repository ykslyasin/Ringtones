package com.example.Ringtones.business.abstracts;

import java.util.List;


import com.example.Ringtones.core.utilities.results.DataResult;
import com.example.Ringtones.core.utilities.results.Result;
import com.example.Ringtones.entities.concretes.Categories;


public interface CategorieService {

	/*List<Categories> getAll();*/
	
	DataResult<List<Categories>> getAll();
	
	Result add(Categories categories);
}
