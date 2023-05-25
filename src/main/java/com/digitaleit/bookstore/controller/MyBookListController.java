package com.digitaleit.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.digitaleit.bookstore.services.MyBooksListService;

@Controller
public class MyBookListController {
	
	@Autowired
	private MyBooksListService service;
	
	
	@RequestMapping("/deleteMylist/{id}")
	public String deleteMylist(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/my_books";
	}

}
