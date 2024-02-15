package com.blog.vo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="postId")
	private Long postId;
	
	@Column(name="user")
	private String user;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="regDate")
	private Date regDate;
	public Comment() {
	}
	
	public Comment(Long postId, String user, String comment) {
		this.postId = postId;
		this.user = user;
		this.comment = comment;
		this.regDate = new Date();
	}
	public Long getId() {
		return id;
	}
}