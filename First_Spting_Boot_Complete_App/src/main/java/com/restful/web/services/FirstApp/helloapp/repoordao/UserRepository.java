package com.restful.web.services.FirstApp.helloapp.repoordao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restful.web.services.FirstApp.helloapp.dtos.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
