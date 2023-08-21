package com.memo.pk.post.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.memo.pk.common.FileManager;
import com.memo.pk.post.domain.Post;
import com.memo.pk.post.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public int addPost(int userId, String title, String content, MultipartFile file) {
		
		// 파일을 특정 경로에 저장
		// 저장된 파일을 클라이언트에서 접근할 수 있는 경로를 얻어 낸다
		String imagePath = FileManager.saveFile(userId, file);
		
		// 접근 경로를 table에 저장한다
		
		return postRepository.insertPost(userId, title, content, imagePath);
	}
	
	public List<Post> getPostList(int userId){
		return postRepository.selectPostList(userId);
	}
	
	public Post getPost(int id) {
		return postRepository.selectPost(id);
	}
	
	public int updatePost(int postId, String title, String content) {
		return postRepository.updatePost(postId, title, content);
	}
	
	public int deletePost(int postId, int userId) {
		// 삭제 대상의 imagePath 경로 얻기
		Post post = postRepository.selectPost(postId);
		
		if(userId == post.getUserId()) {
			FileManager.removeFile(post.getImagePath());
			
			return postRepository.deletePost(postId);			
		} else {
			return 0;
		}
		
	}
	
	
}
