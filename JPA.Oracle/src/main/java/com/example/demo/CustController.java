package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustController {
	@Autowired
	CustomerRepository dao;

	@RequestMapping("/custList")
	@ResponseBody
	/*public	String	custList(Model	model){
					model.addAttribute("custList",	dao.findAll());
	return	"custList";
		}*/
	public List<Customer> custList(Model model) {
		return dao.findAll();
	}
}
