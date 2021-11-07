package com.example.usermicroservices.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.usermicroservices.modelo.Car;

@FeignClient(name= "car-microservices", url= "http://localhost:8080")
@RequestMapping("/cars")
public interface IFeignClient {
	
	@PostMapping("/guardar")
	Object guardarFacade(@RequestBody Car obj);
	
	@GetMapping("/listarid/{id}")
	List<Car> listarCarUser(@PathVariable int id);
		
		
		
	
	
}
