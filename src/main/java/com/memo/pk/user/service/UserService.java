package com.memo.pk.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memo.pk.common.EncryptUtils;
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
		
		// password 암호화
		String ecryptPassword = EncryptUtils.md5(password);
		
		User user = userRepository.save(User.builder()
				.loginId(loginId)
				.password(ecryptPassword)
				.name(name)
				.email(email).build());
		
		return user;
	}
	
	public User getUser(String loginId, String password){
		String encryptPassword = EncryptUtils.md5(password);
		List<User> userList = userRepository.findByLoginIdAndPassword(loginId, encryptPassword);
		
		// 비워진 경우
		if(userList.isEmpty()) {
			return null;
		} else {
			return userList.get(0);
		}
		
	}
	
}
