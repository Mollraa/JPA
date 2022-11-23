package com.example.demo;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestAjaxController {

	@RequestMapping("/userRegAjax")
	public void userRegAjax() {
		
	}
	@RequestMapping("/list")
	@ResponseBody //response contentType :json
	public Map<String, String > list() {
		return Collections.singletonMap("name", "bee") ;
	}
	//등록처리 -> 월요일날 마저함 
	//@RequestBody + JSON.stringify = 셋뚜
//	@RequestMapping("/reg")
//	@ResponseBody
//	public UserVO reg(@RequestBody List<UserVO> vo) {
//		System.out.println(vo);
//		return null;
//	} data 리스트 안됨 
	
	@RequestMapping("/reg")
	@ResponseBody
	public Map<String, Object > reg(UserListVO vo) {
		System.out.println(vo);
//		Map<String, Object > map = new HashMap<>();
//		map.put("result", "succes");
//		map.put("cnt", 1);
		return Collections.singletonMap("result", "success");
	}
	

}
