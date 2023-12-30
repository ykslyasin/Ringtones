package com.example.Ringtones.business.concretes;

import static org.junit.jupiter.api.Assertions.*;


import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.Ringtones.core.dataAccess.UserDao;
import com.example.Ringtones.core.entities.User;
import com.example.Ringtones.core.utilities.results.DataResult;
import com.example.Ringtones.core.utilities.results.ErrorResult;
import com.example.Ringtones.core.utilities.results.Result;
import com.example.Ringtones.core.utilities.results.SuccessResult;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class UserManagerTest {
	
	@Mock
	private UserDao userDao;
	
	@InjectMocks
	UserManager userManager = new UserManager(userDao);
	
	@Test
	public void testGetAllUser() {
		
        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(new User(0, "yasin@gmail.com", "123", "yasin", 1));


        when(userDao.findAll()).thenReturn(mockUsers);


        DataResult<List<User>> result = userManager.getAll();


        assertEquals(mockUsers.size(), result.getData().size());
		
		
	}
	
    @Test
    public void testRegistration_Failure() {

        User existingUser = new User();
        existingUser.setEmail("existing@example.com");

        User newUser = new User();
        newUser.setEmail("existing@example.com");


        when(userDao.getByEmail(existingUser.getEmail())).thenReturn(existingUser);


        Result result = userManager.registration(newUser);

        assertEquals(false, result.isSuccess());
        assertEquals("Bu mail zaten kayıtlı.", ((ErrorResult) result).getMessage());
    }

    @Test
    public void testRegistration_Success() {

        User newUser = new User();
        newUser.setEmail("new@example.com"); 


        when(userDao.getByEmail(newUser.getEmail())).thenReturn(null);


        Result result = userManager.registration(newUser);


        assertEquals(true, result.isSuccess());
        assertEquals("Başarıyla kayıt olundu.", ((SuccessResult) result).getMessage());
    }


}
