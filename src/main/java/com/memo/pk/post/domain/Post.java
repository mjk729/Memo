package com.memo.pk.post.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Post {

	private int id;
	private int userId;
	private String title;
	private String content;
	private String imagePath;
	private Date createdAt;
	private Date updatedAt;
	
}
