package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;
@Controller
@Log4j2 
// 선언해주면 log 찍어줌. 어떤 패키지의 어떤 컨트롤러에서 찍었는지 확인 가능함. 
public class TestConteroller {
	// value = path, ("insert")하고 경로만 적을 땐 이름 생략 가능. method까지 정의하려면 적어줘야함.
	/*@RequestMapping(value = "insert", method = {RequestMethod.POST, RequestMethod.PUT}, )
	public String test1() {
		return "";
	}*/
	@GetMapping("/main") // 자동 완성해보면 Method 빠져있음. 이 자체가 Method라서.
	public void main() {
		
	}
		
	
	@GetMapping("/userReg") // 자동 완성해보면 Method 빠져있음. 이 자체가 Method라서.
	public void UserRegForm() {
		
	}
		
	@PostMapping("/userRegProc") // multipart는 post로 가능, 여러개 파일 등록 필요시 MultipartFile[] 배열로 받으면 됨
	public String userRegProc(UserVO vo, 
							  MultipartFile pic, 
							  RedirectAttributes rttr) throws IllegalStateException, IOException {
		
		if(pic !=null && pic.getSize()>0) { // 파일이 있다면, 
		// 더 찾아봐야할 것_ 파일명 중복처리 하는 법
		String fname = pic.getOriginalFilename();
		// 파일을 정해준 폴더로 이동 : transfrTo 이용 
		File dest = new File("d:/upload", fname);
		pic.transferTo(dest); // import할 때 java io로 import 
		vo.setPicname(fname); // getOriginalFilename : 업로드한 파일 이름
		}
		log.info(vo); 
		rttr.addAttribute("page", 1);
		rttr.addAttribute("search", "title");
		rttr.addFlashAttribute("msg", "등록완료"); // 한번 보여지고 나면 사라짐
		return "redirect:/main"; // get방식일 때만 redirect 가능. 
	}
	
	@GetMapping("/userRegParam")
	public String userRegProc(@RequestParam(required = false, defaultValue = "admin") 
								String name, 
								int age) {
		log.info(name); // 로그 레벨 조절하면서 찍어볼 수 있음
		log.info(age);
		return "userReg";
	}
			
	@GetMapping("/userRegArray") // 안에 VO가 올 순 없음. ListVO가 들어와야함
	public String userRegArray(@RequestParam List<String>hobby) {
		// 같은 name으로 넘어오면 알아서 String 배열로 인식함, String[] 또는 List<String> 
		log.info(hobby);
		return "userReg";
	}
	
	@GetMapping("/userRegListVO") // 안에 VO가 올 순 없음. ListVO가 들어와야함
	public String userRegListVO(UserListVO userList) {
		log.info(userList);
		return "userReg";
	}
	
	/*forward = 서버 내에서 페이지 이동 + 데이터 전달, 값을 가지고 계속 넘어감. 
	 *redirect = 클라이언트 브라우저가 재요청 하도록 하는 것(응답 보내기 -> 재요청 -> 페이지 보이기)
	 *회원 등록시 완료 후 로그인 화면으로 보낸다면  redirect를 사용해야함.    */
}
	
