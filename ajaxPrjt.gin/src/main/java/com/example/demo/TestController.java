package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2 // sysout말고 요거쓰세용
public class TestController {
	/*
	 * //path = value
	 * 
	 * @RequestMapping(path = "insert", method = {RequestMethod.POST,
	 * RequestMethod.PUT} ) public String test1() {
	 * 
	 * return ""; }
	 */

	/*
	 경로같으면 void시 가능 
	@GetMapping({ "/userReg", "/bbb" })
	public String userRegForm() {
		return "userReg";
	}
	== ↓ */
	@GetMapping("/main")
	public void main() {
	}
	
	@GetMapping("/userReg")
	public void userRegForm() {
	}
	

	// Request랑 다른점? Post = method포함하고 있어서 없음
	@GetMapping({ "/userRegProc", "/bbb" })
	public String userReg(UserVO vo) { // form action="userReg" method="post" 요기서 받는 값
		log.info(vo); // 넘 남발하지 마세용 하드터져욤ㅎ
		return "main";
	}

	// @RequestParam = int, string, list만 가능 vo X
	@GetMapping({ "/userRegParam" })
	public String userRegParam(@RequestParam(required = false, defaultValue = "jini's") String name, int age) {
		log.info(name);
		log.info(age);
		return "userReg";
	}

	// List<String>은 @RequestParam생략 안됨. 적어주자!
	@GetMapping({ "/userRegArray" })
	public String userRegArray(@RequestParam List<String> hobby) {
		log.info(hobby);
		return "userReg";

	}

	@GetMapping({ "/userRegListVo" })
	public String userRegListVo(UserListVO list) {
		log.info(list);
		return "userReg";

	}

	/*
	// img -> post only
	// MultipartFile[] - 여러 이미지받을떄
	@PostMapping("/userRegimg")
	public String userRegimg(UserVO vo, MultipartFile pic) throws IllegalStateException, IOException {
		
		if(pic != null && pic.getSize()>0) {
		// 1.파일명 중복처리
		String fname = pic.getOriginalFilename();

		// 2.파일을 정해준 폴더로 이동
		File dest = new File("d:/uplode", fname); //이미지 받을 폴더 만들어주고 와잇!
		pic.transferTo(dest);
		vo.setPicName(fname); //파일명만 담아줄 거얏!
		}
		log.info(vo);
	return "redirect:/main";
	}
	 * */
	//RedirectAttributes test
	@PostMapping("/userRegimg")
	public String userRegimg(UserVO vo, MultipartFile pic
							, RedirectAttributes rttr) throws IllegalStateException, IOException {
		
		if(pic != null && pic.getSize()>0) {
		String fname = pic.getOriginalFilename();
		File dest = new File("d:/uplode", fname); //이미지 받을 폴더 만들어주고 와잇!
		pic.transferTo(dest);
		vo.setPicName(fname); //파일명만 담아줄 거얏!
		}
		log.info(vo);
		rttr.addAttribute("page", 1);
		rttr.addAttribute("search", "title"); //변수명만 적기 -> 공백노노
		rttr.addFlashAttribute("msg", "등록완료"); //새로고침
	return "redirect:/main";
	}
	
	
	
	
	//date java
	@PostMapping("/userRegdate")
	public String userRegdate(UserVO vo, MultipartFile pic) throws IllegalStateException, IOException {
		
		if(pic != null && pic.getSize()>0) {
		// 1.파일명 중복처리
		String fname = pic.getOriginalFilename();

		// 2.파일을 정해준 폴더로 이동
		File dest = new File("d:/uplode", fname); //이미지 받을 폴더 만들어주고 와잇!
		pic.transferTo(dest);
		vo.setPicName(fname); //파일명만 담아줄 거얏!
		}
		log.info(vo);
	return "userReg";
	}

}
