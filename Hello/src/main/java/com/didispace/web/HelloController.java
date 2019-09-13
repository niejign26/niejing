package com.didispace.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.didispace.vo.Book;

@RestController
public class HelloController {

	@Autowired
	private Book book;
	
	@RequestMapping("/hello")
	public String index(){
		System.out.println("success");
		return book.getDesc();
	}
}
