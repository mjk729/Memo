package com.memo.pk.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.memo.pk.post.service.PostService;

@RequestMapping("/post")
@RestController
public class PostRestController {

	@Autowired
	private PostService postService;
	
	@PostMapping("/create")
	public Map<String, String> memoCreate(@RequestParam("title") String title
			, @RequestParam("content") String content
			, HttpSession session) {
		
		// 로그인된 사용자의 user id
		int userId = (Integer)session.getAttribute("userId");
		
		int count = postService.addPost(userId, title, content);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
			
		}
		return resultMap;
	}
	
}
