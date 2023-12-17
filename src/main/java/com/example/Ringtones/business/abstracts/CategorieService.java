package com.example.Ringtones.business.abstracts;

import java.util.List;

import com.example.Ringtones.entities.concretes.Categories;
import com.example.Ringtones.entities.concretes.Ringtone;

public interface CategorieService {

	List<Categories> getAll();
}
