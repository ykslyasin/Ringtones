package com.example.Ringtones.business.concretes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.Ringtones.core.utilities.results.DataResult;
import com.example.Ringtones.core.utilities.results.Result;
import com.example.Ringtones.dataAccess.RingtoneDao;
import com.example.Ringtones.entities.concretes.Ringtone;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class RingtoneManagerTest {

	 	@Mock
	    private RingtoneDao ringtoneDao;

	    @InjectMocks
	    private RingtoneManager ringtoneManager;

	    @Test
	    public void testAdd() {

	        Ringtone ringtoneToAdd = new Ringtone(0, "yasin", "1.29", "Nature", "mp3", 4.99);


	        when(ringtoneDao.save(any(Ringtone.class))).thenReturn(ringtoneToAdd);


	        Result result = ringtoneManager.add(ringtoneToAdd);


	        assertEquals(true, result.isSuccess());
	    }
	    
	    @Test
	    public void testGetAll() {

	        List<Ringtone> mockRingtones = new ArrayList<>();
	        mockRingtones.add(new Ringtone(0, "yasin", "1.29", "Nature", "mp3", 4.99));


	        when(ringtoneDao.findAll()).thenReturn(mockRingtones);


	        DataResult<List<Ringtone>> result = ringtoneManager.getAll();


	        assertEquals(mockRingtones.size(), result.getData().size());
	    }
	
	    @Test
	    public void testGetRingtoneByRingtoneName() {
	    	
	        String ringtoneName = "TestRingtoneName";
	        Ringtone mockRingtone = new Ringtone(0, "yasin", "1.29", "Nature", "mp3", 4.99);


	        when(ringtoneDao.getByRingtoneName(ringtoneName)).thenReturn(mockRingtone);


	        DataResult<Ringtone> result = ringtoneManager.getByRingtoneName(ringtoneName);

	        
	        assertEquals(mockRingtone, result.getData());

	    }
	    
	    @Test
	    public void testGetRingtoneByRingtoneCategory() {
	    	
	        String ringtoneCategory = "TestRingtoneCategory";
	        Ringtone mockRingtone = new Ringtone(0, "yasin", "1.29", "Nature", "mp3", 4.99);


	        when(ringtoneDao.getByRingtoneCategory(ringtoneCategory)).thenReturn(mockRingtone);


	        DataResult<Ringtone> result = ringtoneManager.getByRingtoneCategory(ringtoneCategory);

	        
	        assertEquals(mockRingtone, result.getData());

	    }

}