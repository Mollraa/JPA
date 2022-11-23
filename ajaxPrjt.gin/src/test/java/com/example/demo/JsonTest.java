package com.example.demo;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//jackson = gson
public class JsonTest {

	@Test
	public void test() throws JsonProcessingException {
		UserVO vo = new UserVO();
		vo.setName("뱃지닝");
		vo.setAge(21);
		vo.setBirth(new Date()); //@JsonFormat(pattern = "yyyy/MM/dd")

//		@ResponseBody의 역할 해줌
		ObjectMapper om = new ObjectMapper();
		String result = om.writeValueAsString(vo);
		System.out.println(result);

//		@RequestBody의 역할 해줌
		String jsonStr = "{\"name\":\"뱃지닝\",\"age\":21,\"hobby\":null,\"picName\":null,\"birth\":null}";
		UserVO userVO = om.readValue(jsonStr, UserVO.class); // om.readTree(null) - 영화정보처럼 여러값 받을 떄
		System.out.println(userVO);

	}
}
