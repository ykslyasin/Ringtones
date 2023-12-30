package com.example.Ringtones.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.Ringtones.entities.concretes.Categories;

public interface CategorieDao extends JpaRepository<Categories, Integer>{


	
}