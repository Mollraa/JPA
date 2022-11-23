package com.example.demo;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {

	@Test
	public void test() throws JsonProcessingException {
		UserVO vo = new UserVO();
		vo.setName("홍길동");
		vo.setAge(20);
		vo.setBirth(new Date());
		
		// @ResponseBody -> js에서 쓰는 객체 변경할 때 씀. 
		// (서버-클라이언트는 String  type으로 주고 받음)
		//json타입으로 변경하기
		ObjectMapper om = new ObjectMapper();
		String result = om.writeValueAsString(vo);
		System.out.println(result);
		
		// @RequestBody
		// java class String 객체로 바꾸기
		String jsonStr = "{\"name\":\"홍길동\",\"age\":20,\"hobby\":null,\"picname\":null,\"birth\":null}";
		UserVO userVO = om.readValue(jsonStr, UserVO.class);
		System.out.println(userVO);
	}
}
