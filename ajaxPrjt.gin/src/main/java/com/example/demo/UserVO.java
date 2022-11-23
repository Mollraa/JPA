package com.example.demo;

import java.util.Date;
//import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UserVO {

	private String name;
//	private int age;
	private Integer age;
	List<String> hobby;
	//DB에는 파일명만 들어감 -> private MultipartFile pic;
	@JsonIgnore //값없는거 빼랏
	private String picName;
//	private Date birth;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date birth;
}
