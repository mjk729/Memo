package com.memo.pk.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.memo.pk.post.service.PostService;

@RequestMapping("/post")
@RestController
public class PostRestController {

	@Autowired
	private PostService postService;
	
	@PostMapping("/create")
	public Map<String, String> memoCreate(@RequestParam("title") String title
			, @RequestParam("content") String content
			, @RequestParam(value="file", required=false) MultipartFile file
			, HttpSession session) {
		
		// 로그인된 사용자의 user id
		int userId = (Integer)session.getAttribute("userId");
		
		int count = postService.addPost(userId, title, content, file);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
			
		}
		return resultMap;
	}
	
	@PutMapping("/update")
	public Map<String, String> memoUpdate(@RequestParam("postId") int postId
			,@RequestParam("title") String title
			,@RequestParam("content") String content){
		int count = postService.updatePost(postId, title, content);
		
		Map<String, String> resultMap = new HashMap<>();
		
			if(count == 1) {
				resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
			
		}
		return resultMap;
	}
	
	@DeleteMapping("/delete")
	public Map<String, String> deleteMemo(@RequestParam("postId") int postId, HttpSession session){
		
			int userId = (Integer)session.getAttribute("userId");
		
			// 로그인한 사용자의 userId와 해당 글의 userId가 일치하는 경우에만 삭제 되도록
			int count = postService.deletePost(postId, userId);
			Map<String, String> resultMap = new HashMap<>();
			
			if(count == 1) {
				resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
			
		}
		return resultMap;
	}
}
