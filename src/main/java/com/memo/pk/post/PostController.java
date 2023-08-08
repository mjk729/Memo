package com.memo.pk.post;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.memo.pk.post.domain.Post;
import com.memo.pk.post.service.PostService;

@RequestMapping("/post")
@Controller
public class PostController {

	@Autowired
	private PostService postService;
	
	@GetMapping("/list-view")
	public String list(Model model, HttpSession session) {
		
		// attribute는 object를 가져옴
		int userId = (Integer)session.getAttribute("userId");
		List<Post> postList = postService.getPostList(userId);
		model.addAttribute("postList",postList);
		
		return "post/list";
	}
	
	@GetMapping("/create-view")
	public String input() {
		return "post/input";
	}
	
	@GetMapping("/detail-view/{id}")
	public String detail(
			//	@RequestParam("id") int id
			  @PathVariable("id") int id
			, Model model) {
		Post post = postService.getPost(id);
		model.addAttribute("post",post);
		
		return "post/detail";
	}
	
}
