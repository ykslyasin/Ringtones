package com.example.Ringtones.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Ringtones.entities.concretes.Categories;
import com.example.Ringtones.entities.concretes.Ringtone;

public interface CategorieDao extends JpaRepository<Categories, Integer>{


	
}