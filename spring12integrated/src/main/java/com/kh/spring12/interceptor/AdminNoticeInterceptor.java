package com.kh.spring12.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

@Service
public class AdminNoticeInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response,
			Object handler)
			throws Exception {
		
//		전송방식이 GET이면 통과
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return true;
		}
		
//		남은 요청(POST)은 검사
		String boardHead = request.getParameter("boardHead");
		boolean isNotice = boardHead != null && boardHead.equals("공지");
		
//		공지를 등록하려고 한다면 
		if(isNotice) {
			HttpSession session = request.getSession();
			String memberLevel = (String)session.getAttribute("memberLevel");	//관리자검사
//			boolean isAdmin = memberLevel != null && memberLevel..equals("관리자");
			boolean isAdmin = memberLevel.equals("관리자");
			if(isAdmin) {		// 관리자라면
				return true;
			}		
		}
		response.sendError(403);
		return false;
	}
}
