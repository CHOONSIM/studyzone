package com.kh.spring13.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring13.dao.AttachmentDao;
import com.kh.spring13.dto.AttachmentDto;

@Controller
public class FileController {
	
	@Autowired
	private AttachmentDao attachmentDao;
	
	@GetMapping("/")
	public String home() {
		return "/WEB-INF/views/home.jsp";
	}
	
	//파일 업로드는 PostMapping만 가능
	// - 전송된 파일은 MultipartFile 이라는 형태로 수신이 가능하다
	// - 파일 전송 완료 후에는 반드시 redirect를 해야 한다(안하면 새로고침시 재업로드)
	// - (주의) 파일을 전송하지 않아도 attach는 null이 아니므로 추가 검사 필요
	@PostMapping("/upload3")
	public String upload3(@RequestParam MultipartFile attach) throws IllegalStateException, IOException {
		System.out.println(attach.isEmpty());
		System.out.println("name = " + attach.getName());
		System.out.println("original file name = " + attach.getOriginalFilename());
		System.out.println("content type = " + attach.getContentType());
		System.out.println("size = " + attach.getSize());
		
		if(!attach.isEmpty()) {//파일이 있을 경우
//			번호생성
			int attachmentNo = attachmentDao.sequence();
			
			//파일 저장(저장 위치는 임시로 생성)
			File dir = new File("D:/upload");
			dir.mkdirs();
			
			File target = new File(dir, String.valueOf(attachmentNo));	//파일명=시퀀스
			attach.transferTo(target);
			
//			DB저장(builder 패턴)
			attachmentDao.insert(AttachmentDto.builder()
					.attachmentNo(attachmentNo)
					.attachmentName(attach.getOriginalFilename())
					.attachmentType(attach.getContentType())
					.attachmentSize(attach.getSize())
					.build());
		}	
		
		return "redirect:/";
	}
	
}