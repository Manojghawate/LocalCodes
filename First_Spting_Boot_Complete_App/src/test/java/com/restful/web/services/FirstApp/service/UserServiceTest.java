package com.restful.web.services.FirstApp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restful.web.services.FirstApp.helloapp.dtos.User;
import com.restful.web.services.FirstApp.helloapp.repoordao.entities.Post;
import com.restful.web.services.FirstApp.helloapp.services.UserService;

@SpringBootTest
public class UserServiceTest {
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Test
	public void testUserById() {
		User inputUser = new User(1001, "Sachin", null);
		User user = userService.getUserByid(1001);
		assertEquals(inputUser.getUserId(),user.getUserId());
		assertEquals(inputUser.getName(),user.getName());
		List<Post>posts = user.getPosts();
		posts.stream().forEach((p)->System.out.println(p.getDescription()));
	}

}
