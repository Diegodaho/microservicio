package com.example.carmicroservices.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carmicroservices.entity.Car;
import com.example.carmicroservices.iserivies.CarIServices;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	@Autowired
	private CarIServices iServices;
	
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardarFacade(@RequestBody Car obj) {
		iServices.guardarUser(obj);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@GetMapping("/listar")
	public  ResponseEntity<List<Car>> listarTodo() {		
		List<Car> listar = iServices.listarUser();
		
		
		if(listar.size()==0) {
			return new ResponseEntity<List<Car>>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<List<Car>>(listar, HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/listarid/{id}")
	public  ResponseEntity<List<Car>> listarCarUser(@PathVariable int id) {		
		List<Car> listar = iServices.listarCarUser(id);
		
		return new ResponseEntity<List<Car>>(listar, HttpStatus.OK);
		
	}

}
