package com.example.demo;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestAjaxController {

	// Ajax에서는 내가 지정해준 타입에 따라 return 타입도 달라짐. 
	@RequestMapping("/userRegAjax")
	public void userRegAjax() {
			
	}
	
	@RequestMapping("/list")
	@ResponseBody // response contentType : json
	public Map<String,String> list() {		
		return Collections.singletonMap("name", "park");
	}
	
	// 등록처리
	@RequestMapping("/reg")
	@ResponseBody 
	public ResponseEntity reg(UserListVO vo) {
		System.out.println(vo);
		//Map과 VO는 동일하다. VO가 없으면 Map으로 처리하면 됨
//		Map<String, Object> map = new HashMap<>();
//		map.put("result", "success");
//		map.put("cnt", 1);		
		
		// Map 하나만 보내고 싶을 때 사용
		//return  Collections.singletonMap("result", "success");
	
		
		// head와 body 직접 지정해서 제어할 수 있음
		return (ResponseEntity) new ResponseEntity(null).status(HttpStatus.OK);
	
			
				
	}
}
