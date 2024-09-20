package com.restful.web.services.FirstApp.helloapp.repoordao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.restful.web.services.FirstApp.helloapp.dtos.User;

@Repository
public class UserDaoOrRepo {
	static List<User>users = new ArrayList<User>();
	{
		users.add(new User(1, "Allen",LocalDate.now().minusYears(55)));
		users.add(new User(2, "Shaun",LocalDate.now().minusYears(50)));
		users.add(new User(3, "Dale",LocalDate.now().minusYears(40)));
	}
	public List<User>findAll(){
		return users;
	}
	public User findById(int id){
		return users.stream().filter(user->user.getUserId() ==id).findAny().orElse(null);
	}
	public void deleteByid(int id){
		 users.removeIf(user ->user.getUserId() == id);
	}
	public void addUser(User user) {
		users.add(user);
	}


}
