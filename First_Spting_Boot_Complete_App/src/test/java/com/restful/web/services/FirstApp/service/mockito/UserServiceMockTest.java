package com.restful.web.services.FirstApp.service.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.restful.web.services.FirstApp.helloapp.dtos.User;
import com.restful.web.services.FirstApp.helloapp.repoordao.UserRepository;
import com.restful.web.services.FirstApp.helloapp.services.UserService;
/**
 * @author manoj.ghawate
 * 
 * This test class is explaining Mockito.
 * To write junit test cases if we need to test data from bussines and repo layer, instead of calling db we can mock data using mockito
 * @Mock and @InjectMocks wont work without @ExtendWith
 * 
 */

@ExtendWith(MockitoExtension.class)
class UserServiceMockTest {
	@Mock
	private UserRepository userRepositoryMock;
	@InjectMocks
	private UserService userService;
	
//	above two lines similar to
//	UserRepository userRepositoryMock = mock(UserRepository.class);
//	UserService userService = new UserService(null, userRepositoryMock, null);

	@Test
	void test() {
//		UserRepository userRepositoryMock = mock(UserRepository.class);
//		UserService userService = new UserService(null, userRepositoryMock, null);
		
		//whenever userRepository method gets call it will call method from userRepositoryMock and executes below code
		when(userRepositoryMock.findById(1001)).thenReturn(Optional.of(new User(1001, "Sachin", null)));
		User inputUser = new User(1001, "Sachin", null);
		User user = userService.getUserByid(1001);
		assertEquals(inputUser.getUserId(),user.getUserId());
		assertEquals(inputUser.getName(),user.getName());
	
	}
}
