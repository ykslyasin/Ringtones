package com.example.Ringtones.business.concretes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Ringtones.core.utilities.results.DataResult;
import com.example.Ringtones.core.utilities.results.Result;
import com.example.Ringtones.dataAccess.RingtoneDao;
import com.example.Ringtones.entities.concretes.Categories;
import com.example.Ringtones.entities.concretes.Ringtone;

@ExtendWith(MockitoExtension.class)
class RingtoneManagerTest {

	 	@Mock
	    private RingtoneDao ringtoneDao;

	    @InjectMocks
	    private RingtoneManager ringtoneManager;

	   @Test
	    public void testAdd() {

		    Categories ringtoneCategory = new Categories(1, "Animals");
	        Ringtone ringtoneToAdd = new Ringtone(1, "birds1", "0:15", ringtoneCategory, "mp3", 4.99, "yasin");


	        when(ringtoneDao.save(any(Ringtone.class))).thenReturn(ringtoneToAdd);


	        Result result = ringtoneManager.add(ringtoneToAdd);


	        assertEquals(true, result.isSuccess());
	    }
	    
	    @Test
	    public void testGetAll() {

	        List<Ringtone> mockRingtones = new ArrayList<>();
	        Categories ringtoneCategory = new Categories(1, "Animals");
	        mockRingtones.add(new Ringtone(1, "birds1", "0:15", ringtoneCategory, "mp3", 4.99, "yasin"));


	        when(ringtoneDao.findAll()).thenReturn(mockRingtones);


	        DataResult<List<Ringtone>> result = ringtoneManager.getAll();


	        assertEquals(mockRingtones.size(), result.getData().size());
	    }
	
	    @Test
	    public void testGetRingtoneByRingtoneName() {
	    	
	        String ringtoneName = "TestRingtoneName";
	        Categories ringtoneCategory = new Categories(1, "Animals");
	        Ringtone mockRingtone = new Ringtone(1, "birds1", "0:15", ringtoneCategory, "mp3", 4.99, "yasin");


	        when(ringtoneDao.getByRingtoneName(ringtoneName)).thenReturn(mockRingtone);


	        DataResult<Ringtone> result = ringtoneManager.getByRingtoneName(ringtoneName);

	        
	        assertEquals(mockRingtone, result.getData());

	    }
	    
	   @Test
	    public void testGetRingtoneByRingtoneCategory() {
	    	
	        Categories ringtoneCategory = new Categories(1, "Animals");
	        Ringtone mockRingtone = new Ringtone(1, "birds1", "0:15", ringtoneCategory, "mp3", 4.99, "yasin");


	        when(ringtoneDao.getByRingtoneCategory(ringtoneCategory)).thenReturn(mockRingtone);


	        DataResult<Ringtone> result = ringtoneManager.getByRingtoneCategory(ringtoneCategory);

	        
	        assertEquals(mockRingtone, result.getData());

	    }
	    
	    @Test
	    public void testGetRingtoneById() {
	    	
	        int ringtoneId = 5;
	        Categories ringtoneCategory = new Categories(1, "Animals");
	        Ringtone mockRingtone = new Ringtone(1, "birds1", "0:15", ringtoneCategory, "mp3", 4.99, "yasin");


	        when(ringtoneDao.getById(ringtoneId)).thenReturn(mockRingtone);


	        DataResult<Ringtone> result = ringtoneManager.getById(ringtoneId);

	        
	        assertEquals(mockRingtone, result.getData());

	    }

}
