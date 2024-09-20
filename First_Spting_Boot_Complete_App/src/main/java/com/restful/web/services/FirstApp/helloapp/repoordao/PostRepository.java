package com.restful.web.services.FirstApp.helloapp.repoordao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restful.web.services.FirstApp.helloapp.repoordao.entities.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
