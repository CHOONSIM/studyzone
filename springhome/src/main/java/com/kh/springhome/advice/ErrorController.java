package com.kh.springhome.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.Controller;

//예외만 전문적으로 처리하는 컨트롤러(사용자가 부를 수 없음)
//어노테이션 이름도 다름
//(주의)컨트롤러만 감시가 가능

@ControllerAdvice    // : 프로젝트 전체에 대한 catch 블록(catch를 모아놓은 컨트롤러)

//@ControllerAdvice(annotations = {Controller.class) @Controller에 대한 catch 블록
//@ControllerAdvice(basePackages = {"com.kh.spring12.controller"})
public class ErrorController {

	//	마치 catch블록을 만들듯이 메소드를 구현
	//	- @ExceptionHandler(처리할 예외 클래스 정보)
	//	- 컨트롤러처럼 특정 페이지를 보여주거나 Redirect 처리를 하는 등이 가능
	//	- 컨트롤러에서 제공받는 도구들을 모두 사용할 수 있다
	
	@ExceptionHandler(Exception.class)
	public String error(Exception ex) {
		return"/WEB-INF/views/error/sorry.jsp";
	}
//	404예외만 따로 처리할 수 있도록 추가 메소드를 구성
//	- 이 예외는 다른 예외로 변경 할 수 없다.
	@ExceptionHandler(NoHandlerFoundException.class)
	public String notFound(Exception ex) {
//		ex.printStackTrace();		(오류추적)
		return"/WEB-INF/views/error/404.jsp";
	}

//	403 - 권한이 없음 : 직접 만든 RequirePermissionException으로 대체하여 처리
	@ExceptionHandler(RequirePermissionException.class)
	public String forbidden(Exception ex) {
		return "/WEB-INF/views/error/403.jsp";
	}
	
//	401 - 자격이 없음 : 직접 만든 RequireLoginException으로 대체처리
//	- 사용자가 봐야하는 페이지는 로그인 페이지
	@ExceptionHandler(RequireLoginException.class)
	public String unAuthorizes(Exception ex) {
	return"/WEB-INF/views/member/login.jsp";		// 주소는 유지하고 화면만 변경
//	return"redirect:/member/login";						//재접속을 지시
	}
}
