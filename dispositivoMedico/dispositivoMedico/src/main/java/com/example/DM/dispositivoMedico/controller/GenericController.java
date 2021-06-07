package com.example.DM.dispositivoMedico.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenericController {

	
	@GetMapping("/")
	public String hello() {
		return "Hello guys";
	}
}
