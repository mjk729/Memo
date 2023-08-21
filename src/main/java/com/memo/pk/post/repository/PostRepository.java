package com.memo.pk.post.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.memo.pk.post.domain.Post;

@Repository
public interface PostRepository {

	public int insertPost(@Param("userId") int userId
			, @Param("title") String title
			, @Param("content") String content
			, @Param("imagePath") String imagePath);
	
	public List<Post> selectPostList(@Param("userId") int userId);
	
	public Post selectPost(@Param("id") int id);
	
	public int updatePost(@Param("postId") int postId
	,@Param("title") String title
	,@Param("content") String content);
	
	public int deletePost(@Param("postId") int postId);
	
}
