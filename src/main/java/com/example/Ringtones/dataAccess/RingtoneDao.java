package com.example.Ringtones.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Ringtones.entities.concretes.Categories;
import com.example.Ringtones.entities.concretes.Ringtone;


public interface RingtoneDao extends JpaRepository<Ringtone, Integer>{

	Ringtone getByRingtoneName(String ringtoneName);
	
	Ringtone getByRingtoneCategory(Categories ringtoneCategory);
	
	Ringtone getById(int ringtoneId);
}
