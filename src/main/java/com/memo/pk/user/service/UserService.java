package com.memo.pk.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memo.pk.user.domain.User;
import com.memo.pk.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User addUser(
				String loginId
				, String password
				, String name
				, String email) {
		
		
		
		User user = userRepository.save(User.builder()
				.loginId(loginId)
				.password(password)
				.name(name)
				.email(email).build());
		
		return user;
	}
	
}
