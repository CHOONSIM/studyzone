package com.kh.spring13.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

// application.properties에 작성된 academy로 시작하는 정보를 불러오는 클래스
// - 등록은 @Component 또는 @Service로 한다
// - @ConfigurationProperties를 붙여 설정 파일의 내용을 불러오는 파일임을 명시

@Data
@Component
@ConfigurationProperties(prefix = "custom.academy")			//prefix = 접두사, suffix = 접미사
public class AcademyProperties {
	private String name;			// academy.name
	private String location;		//academy.location
	private int since;				//academy.since
}
