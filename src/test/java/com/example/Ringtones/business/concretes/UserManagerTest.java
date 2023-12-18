package com.example.Ringtones.business.concretes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.Ringtones.core.dataAccess.UserDao;
import com.example.Ringtones.core.entities.User;
import com.example.Ringtones.core.utilities.results.DataResult;
import com.example.Ringtones.entities.concretes.Ringtone;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class UserManagerTest {
	
	@Mock
	private UserDao userDao;
	
	@InjectMocks
	UserManager userManager = new UserManager(userDao);
	
	/*@Test
	public void messageTest() {
		
		String testMessage = "yasin";
		
		userManager.message(testMessage);
	}*/
	
	@Test
	public void testGetAllUser() {
		
        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(new User(0, "yasin@gmail.com", "123", "yasin", 1));


        when(userDao.findAll()).thenReturn(mockUsers);


        DataResult<List<User>> result = userManager.getAll();


        assertEquals(mockUsers.size(), result.getData().size());
		
		
	}

}
