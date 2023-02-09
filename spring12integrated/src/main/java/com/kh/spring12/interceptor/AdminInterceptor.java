package com.kh.spring12.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

@Service
public class AdminInterceptor implements HandlerInterceptor{
@Override
public boolean preHandle(
		HttpServletRequest request,
		HttpServletResponse response, 
		Object handler)
		throws Exception {
		
		HttpSession session = request.getSession();
		String memberLevel = (String)session.getAttribute("memberLevel");
		String memberId = (String)session.getAttribute("memberId");
		
		if(memberId != null) {
			return true;
		}
		if(memberLevel == "관리자") {
			return true;
		}
		else {	
			response.sendRedirect("/member/login");		
			return false;
		}
	}
}
