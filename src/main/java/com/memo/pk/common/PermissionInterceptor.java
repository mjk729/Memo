package com.memo.pk.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class PermissionInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(
			HttpServletRequest request
			,HttpServletResponse response
			,Object handler) throws IOException {
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		//   /user/login-view
		String uri = request.getRequestURI();
		
		// 로그인이 안된 상태에서 /post로 시작하는 페이지를 접근하지 못하고, 로그인 페이지로 이동 시켜라
		if(userId == null) {
			if(uri.startsWith("/post")) {
				// 리다이렉트
				response.sendRedirect("/user/login-view");
				// Controller 까지 요청이 전달 되지 않고, 중단 시킨다.
				return false;
			}
		}	else {// 로그인이 되었을 때 /user로 시작하는 페이지를 접근하지 못하고, 리스트 페이지로 이동시켜라
			if(uri.startsWith("/user")) {
				response.sendRedirect("/post/list-view");
				return false;
			}
			
		}
		
		return true;
		
	}
	
}
