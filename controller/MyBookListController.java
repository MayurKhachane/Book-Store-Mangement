package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.services.MyBookListService;

@Controller
public class MyBookListController {
	
	@Autowired
	private MyBookListService newbook;
	
	@RequestMapping("/deleteList/{id}")
	public String DeleteMyList(@PathVariable("id") int id) {
		newbook.DeleteById(id);
		return "redirect:/my_book";
	}

}
