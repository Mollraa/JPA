package com.example.demo;


import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
//모든 타입 String으로 받아와도 됨. 
public class UserVO {
	private String name;
	private Integer age; // Integer는 null값이 들어감. 
	List<String> hobby;
	@JsonIgnore // 이 데이터는 json으로 변형시키지 말라는 뜻
	String picname; //첨부파일, html 파일 name 과 이름 다르게 해야함(타입이 다르므로)
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@JsonFormat(pattern="yyyy/MM/dd")
	Date birth;
}
