package com.memo.pk.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.memo.pk.user.domain.User;
import com.memo.pk.user.service.UserService;

@RequestMapping("/user")
@RestController	// @controller + @responsebody
public class UserRestController {
	
	@Autowired
	private UserService userService; 

	@PostMapping("/join")
	public Map<String, String> join(
			@RequestParam("loginId") String loginId
			,@RequestParam("password") String password
			,@RequestParam("name") String name
			,@RequestParam("email") String email){
	
		User user = userService.addUser(loginId, password, name, email);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(user != null) {
			// 성공
			resultMap.put("result", "success");
		} else {
			// 실패
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
}
