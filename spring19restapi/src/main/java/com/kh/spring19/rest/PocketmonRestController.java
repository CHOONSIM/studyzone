package com.kh.spring19.rest;

import java.util.List;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.kh.spring19.dto.PocketmonDto;
import com.kh.spring19.repo.PocketmonRepo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

//springdoc 문서를 직접 만든 것이 아니라 설정으로 자동생성 했으므로
//문서에 들어갈 정보도 코드로 작성해야 한다
//		@Tag - 컨트롤러의 문서상 표시될 이름 설정
//		@Operation - 작업에 대한 설명 설정


@Tag(name = "포켓몬스터 요청 처리기")
@RestController
@RequestMapping("/pocketmon")
public class PocketmonRestController {
	
	@Autowired
	private PocketmonRepo repo;
	
	@Operation(
			description="포켓몬스터 신규 등록",
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
	//@ModelAttribute는 springdoc에서 인식하지 못함
	//@ParameterObject로 대체하여 사용할 것을 권장
	
	@PostMapping("/")
//	public void add(@ModelAttribute PocketmonDto dto) {
	public void add(@ParameterObject @ModelAttribute PocketmonDto dto) {
		repo.insert(dto);
	}
	
	
	
	@Operation(
			description="포켓몬스터 목록 조회",
			responses = {
					@ApiResponse(
							responseCode="200",description="조회 성공",
							content=@Content(
									mediaType="application/json",
									array=@ArraySchema(
											schema=@Schema(implementation=PocketmonDto.class)
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
	public List<PocketmonDto>list(){
		return repo.selectList();
	}
	
	@Operation(
			summary="포켓몬스터 상세정보 조회",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "해당 번호의 포켓몬스터를 찾음",
							content=@Content(
									mediaType="application/json",
									array=@ArraySchema(
											schema=@Schema(implementation=PocketmonDto.class)
									)
							)
							
					),
					
					@ApiResponse(
							responseCode = "404",
							description = "해당 번호의 포켓몬스터가 없음",
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
	public PocketmonDto find(
			@Parameter(description = "포켓몬스터 번호(PK)")
			@PathVariable int no) throws NoHandlerFoundException {
		PocketmonDto dto = repo.selectOne(no);
		if(dto == null) 
			throw new NoHandlerFoundException(null, null, null);
		return dto;
	}
	
	@PutMapping("/")
	public void edit(@ModelAttribute PocketmonDto dto) throws NoHandlerFoundException {
		PocketmonDto find = repo.selectOne(dto.getNo());
		if(find == null) 
			throw new NoHandlerFoundException(null, null, null);
		repo.update(dto);
	}
	
	@DeleteMapping("/{no}")
	public void delete(@PathVariable int no) throws NoHandlerFoundException {
		PocketmonDto dto = repo.selectOne(no);
		if(dto == null) 
			throw new NoHandlerFoundException(null, null, null);
		repo.delete(no);
	}
	
}
