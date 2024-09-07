package com.myproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.myproj.service.LoginRegisterService;

@RestController

public class TestController {
	@Autowired
	 private   LoginRegisterService service ;
	
	@RequestMapping(value="/HBDTOtest",method = RequestMethod.GET,produces="application/json")
	@CrossOrigin(origins="*")
	public  ResponseEntity<Object> HiberDTOInsert() {
	
        
        ResponseEntity<Object> entity = new ResponseEntity<>(null,HttpStatus.CREATED);
         
		return entity;
		
		
	}



}
