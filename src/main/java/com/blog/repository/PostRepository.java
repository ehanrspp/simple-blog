package com.blog.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import com.blog.mapper.PostMapper;
import com.blog.vo.Post;

@Repository
public class PostRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Post findOne(Long id) {
	String sql = "SELECT * FROM post WHERE id = ?";
	
	RowMapper<Post> rowMapper = new PostMapper();
	
	return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}
}