package com.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.repository.PostJpaRepository;
import com.blog.repository.PostRepository;
import com.blog.vo.Post;

import io.micrometer.common.util.StringUtils;

@Service
public class PostService {
	private static List<Post> posts;
	
	public Post getPost() {
		Post post = new Post(1L, "Mike", "Mike's Post", "Welcome to My blog");
		return post;
	}
	
	public List<Post> getPosts(){
		List<Post> posts = postJpaRepository.findAllByOrderByUpdtDateDesc();
		
		return posts;
	}
	
	public List<Post> getPostsOrderByUpdtAsc(){
		List<Post> postList = postJpaRepository.findAllByOrderByUpdtDateAsc();
		
		return postList;
	}
	
	public List<Post> getPostsOrderByRegDesc(){
		List<Post> postList = postRepository.findPost();
		
		return postList;
	}
	
	public List<Post> searchPostByTitle(String query) {
		List<Post> posts = postRepository.findPostLikeTitle(query);
		return posts;
	}
	
	public List<Post> searchPostByContent(String query) {
	    List<Post> posts = postRepository.findPostLikeContent(query);
	return posts;
	}
	
	@Autowired
	PostRepository postRepository;
	
	public Post getPost(Long id) {
		Post post = postJpaRepository.findOneById(id);
		
		return post;
	}
	
	public boolean savePost(Post post) {
		Post result = postJpaRepository.save(post);
		boolean isSuccess = true;
		
		if (result == null) {
			isSuccess = false;
		}
		return isSuccess;
	}
	
	@Autowired
	PostJpaRepository postJpaRepository;
	
	public boolean deletePost (Long id) {
		Post result = postJpaRepository.findOneById(id);
		
		if(result == null)
			return false;
		
		postJpaRepository.deleteById(id);
			return true;
		}
	
	public boolean updatePost (Post post) {
		Post result = postJpaRepository.findOneById(post.getId());
		
		if(result == null)
			return false;
		
		if(!StringUtils.isEmpty(post.getTitle())) {
			result.setTitle(post.getTitle());
		}
		
		if(!StringUtils.isEmpty(post.getContent())) {
			result.setContent(post.getContent());
		}
		postJpaRepository.save(result);
		return true;
		}
}