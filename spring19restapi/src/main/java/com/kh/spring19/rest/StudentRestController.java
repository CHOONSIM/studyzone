package com.kh.spring19.rest;

import java.util.List;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.kh.spring19.dto.StudentDto;
import com.kh.spring19.repo.StudentRepo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name="학생성적 요청 처리기")
@RestController
@RequestMapping("/student")
public class StudentRestController {
	
	@Autowired
	private StudentRepo repo;
		
	@Operation(
			description="학생 신규 등록",
			responses= {
					@ApiResponse(
							responseCode = "200",
							description = "등록이 정상적으로 완료된 경우",
							content=@Content(
									mediaType="text/plain",
									schema=@Schema(implementation=String.class),
									examples= {
											@ExampleObject("OK")
									}
							)
					),
					@ApiResponse(
							responseCode = "500",
							description = "번호 중복 또는 이름/속성 크기가 초과한 경우",
							content=@Content(
									mediaType="text/plain",
									schema=@Schema(implementation=String.class),
									examples= {
											@ExampleObject("SERVER ERROR")
									}
							)
					)
			}
	)
	
	@PostMapping("/")
	public void add(@ParameterObject @ModelAttribute StudentDto dto){
		repo.insert(dto);
	}
	@Operation(
			description="학생 목록 조회",
			responses = {
					@ApiResponse(
							responseCode="200",description="조회 성공",
							content=@Content(
									mediaType="application/json",
									array=@ArraySchema(
											schema=@Schema(implementation=StudentDto.class)
									)
							)
					),
					@ApiResponse(
							responseCode = "500",
							description = "서버의 처리 과정에서 오류 발생",
							content=@Content(
									mediaType="text/plain",
									schema=@Schema(implementation=String.class),
									examples= {
											@ExampleObject("SERVER ERROR")
									}
							)
					)
			}
	)
	@GetMapping("/")
	public List<StudentDto>list(){
		return repo.selectList();
	}
	
	@Operation(
			summary="학생 상세정보 조회",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "해당 번호의 학생를 찾음",
							content=@Content(
									mediaType="application/json",
									array=@ArraySchema(
											schema=@Schema(implementation=StudentDto.class)
									)
							)
							
					),
					
					@ApiResponse(
							responseCode = "404",
							description = "해당 번호의 학생가 없음",
							content=@Content(
									mediaType="text/plain",
									schema=@Schema(implementation=String.class),
									examples= {
											@ExampleObject("SERVER ERROR")
									}
							)
					),
					@ApiResponse(
							responseCode = "500",
							description = "서버의 처리과정에서 오류 발생",
							content=@Content(
									mediaType="text/plain",
									schema=@Schema(implementation=String.class),
									examples= {
											@ExampleObject("SERVER ERROR")
									}
							)
					),
			}
	)
	@GetMapping("/{no}")
	public StudentDto find(
			@Parameter(description = "학생 번호(pk)")
			@PathVariable int no) throws NoHandlerFoundException {
		StudentDto dto = repo.selectOne(no);
		if(dto == null) 
			throw new NoHandlerFoundException(null, null, null);
		return dto;
	}
	
	@PutMapping("/")
	public void edit(@ModelAttribute StudentDto dto) {
		StudentDto find = repo.selectOne(dto.getNo());
		if(find == null)
			repo.update(dto);
	}
	
	@DeleteMapping("/{no}")
	public void delete(@PathVariable int no) throws NoHandlerFoundException {
		StudentDto dto = repo.selectOne(no);
		if(dto == null) 
			throw new NoHandlerFoundException(null, null, null);
		repo.delete(no);
	}
}