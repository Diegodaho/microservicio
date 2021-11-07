package com.example.usermicroservices.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.usermicroservices.entity.User;
import com.example.usermicroservices.iserivies.UserIServices;
import com.example.usermicroservices.modelo.Car;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserIServices iServices;
	
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardarFacade(@RequestBody User obj) {
		iServices.guardarUser(obj);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@GetMapping("/listar")
	public  ResponseEntity<List<User>> listarTodo() {		
		List<User> listar = iServices.listarUser();
		
		if(listar.size()==0) {
			return new ResponseEntity<List<User>>(listar, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(listar, HttpStatus.OK);
	}
	
	@PostMapping("/guardarCarU")
	public ResponseEntity<Object> guardarCar(@RequestBody Car obj) {
		iServices.guardar(obj);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@GetMapping("/listaall/{id}")
	public  ResponseEntity<List<Object>> listarCarUser(@PathVariable int id) {		
		List<Object> listar = iServices.ListCarUser(id);
		
		return new ResponseEntity<List<Object>>(listar, HttpStatus.OK);
		
	}
	

}
