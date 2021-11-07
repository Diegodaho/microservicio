package com.example.usermicroservices.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usermicroservices.entity.User;
import com.example.usermicroservices.feignClient.IFeignClient;
import com.example.usermicroservices.iserivies.UserIServices;
import com.example.usermicroservices.modelo.Car;
import com.example.usermicroservices.repository.IUserRepo;

@Service
public class UserServices implements  UserIServices{
	
	@Autowired
	private IUserRepo repoUser;
	
	@Autowired
	private IFeignClient feign;
	

	@Override
	public void guardarUser(User clase) {
		 repoUser.save(clase);
		
	}

	@Override
	public List<User> listarUser() {
		List<User> lista=repoUser.findAll();
		return lista;
	}

	@Override
	public void guardar(Car clase) {
		feign.guardarFacade(clase);
	}

	@Override
	public List<Object> ListCarUser(int id) {
		
		List<Object> lista = new ArrayList<>();
		
		User u = repoUser.findById(id).orElse(null);
		
	
		if(u == null) {
			lista.add("no se encontro el usario");
			
			return lista;
		
		}
			
		lista.add(u);
			
			
	
		List<Car> cars = feign.listarCarUser(id);
		
		if(cars.isEmpty()) {
			lista.add("el usuario no tinene carros");
			
		}
		else {
			lista.add(cars);
		}
		
		
		return lista;
		
		
	}

	
	
}
