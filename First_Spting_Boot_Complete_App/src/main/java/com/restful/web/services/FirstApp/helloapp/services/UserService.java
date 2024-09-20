package com.restful.web.services.FirstApp.helloapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restful.web.services.FirstApp.helloapp.dtos.User;
import com.restful.web.services.FirstApp.helloapp.repoordao.PostRepository;
import com.restful.web.services.FirstApp.helloapp.repoordao.UserDaoOrRepo;
import com.restful.web.services.FirstApp.helloapp.repoordao.UserRepository;
import com.restful.web.services.FirstApp.helloapp.repoordao.entities.Post;

@Service
public class UserService {
	private UserDaoOrRepo userDaoOrRepo;
	private UserRepository userRepository;
	private PostRepository postRepository;
	public UserService(UserDaoOrRepo userDaoOrRepo,UserRepository userRepository,PostRepository postRepository) {
		this.userDaoOrRepo = userDaoOrRepo;
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}
	public List<User>getAllUsers(){
		//return this.userDaoOrRepo.findAll();
		return this.userRepository.findAll();
	}
	public User getUserByid(int id){
		//return this.userDaoOrRepo.findById(id);
		return this.userRepository.findById(id).orElse(null);
	}
	public void deleteUserByid(int id){
		//this.userDaoOrRepo.deleteByid(id);
		this.userRepository.deleteById(id);
	}
	public void addUser(User user){
		//this.userDaoOrRepo.addUser(user);
		this.userRepository.save(user);
	}
	public void addPostForUser(Post post) {
		this.postRepository.save(post);
	}
	public Post getPostById(int id) {
		return this.postRepository.findById(id).orElse(null);
	}

}
