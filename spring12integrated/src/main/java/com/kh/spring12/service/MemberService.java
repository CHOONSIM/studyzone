package com.kh.spring12.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring12.dao.AttachmentDao;
import com.kh.spring12.dao.MemberDao;
import com.kh.spring12.dao.MemberProfileDao;
import com.kh.spring12.dto.MemberDto;
import com.kh.spring12.dto.MemberProfileDto;
import com.kh.spring12.dto.AttachmentDto;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberProfileDao memberProfileDao;
	
	@Autowired
	private AttachmentDao attachmentDao;
	
	private final File dir = new File("D:/upload");
	
	@PostConstruct			// 최초한번만 실행
	public void init() {
		dir.mkdirs();
	}
	
	public void join(MemberDto memberDto, MultipartFile attach) throws IllegalStateException, IOException {
		
		memberDao.insert(memberDto);
		
		if(!attach.isEmpty()) {
			int attachmentNo = attachmentDao.sequence();
			
			File target = new File(dir, String.valueOf(attachmentNo));
			attach.transferTo(target);
			
			attachmentDao.insert(AttachmentDto.builder()// 저장
					.attachmentNo(attachmentNo)
					.attachmentName(attach.getOriginalFilename())
					.attachmentType(attach.getContentType())
					.attachmentSize(attach.getSize())
				.build());
			
			memberProfileDao.insert(MemberProfileDto.builder()
					.memberId(memberDto.getMemberId())
					.attachmentNo(attachmentNo)
					.build());
		}
	}
}
