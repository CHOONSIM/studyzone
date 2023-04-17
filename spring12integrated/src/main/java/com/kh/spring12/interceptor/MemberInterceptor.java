package com.kh.spring12.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring12.advice.RequireLoginException;

//비회원이 회원 기능에 접근하는 것을 차단하기 위한 인터셉터

@Service
public class MemberInterceptor implements HandlerInterceptor {
@Override
public boolean preHandle(
		HttpServletRequest request, 
		HttpServletResponse response, 
		Object handler)
		throws Exception {
	
//	로그인 상태 = 세션에 있는 memberId가 null이 아닌 경우 (수동)
	HttpSession session = request.getSession();
	String memberId = (String)session.getAttribute("memberId");
	
	if(memberId != null) {		//회원
		return true;
	}
	else {						//비회원 - 로그인페이지로 이동시킴(redirect)
//		response.sendRedirect("/member/login");			//return"redirect:/member/login"
//		return false;
		throw new RequireLoginException("로그인 후 이용 가능합니다.");
		}
	}
}
