package com.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.Message;

@RestController
public class HelloWorldRestController {

	@RequestMapping("/hello")
	public String welcome(){
		return "Welcome to Rest Example";
	}
	
	@RequestMapping("/hello/{player}")
	public Message message(@PathVariable String player){
		
		return new Message(player,"Hello" + player);
	}
}
