package com.example.carmicroservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carmicroservices.entity.Car;
import com.example.carmicroservices.iserivies.CarIServices;
import com.example.carmicroservices.repository.ICarRepo;

@Service
public class CarServices implements  CarIServices{
	
	@Autowired
	private ICarRepo repoUser;
	
	

	@Override
	public void guardarUser(Car clase) {
		 repoUser.save(clase);
		
	}

	@Override
	public List<Car> listarUser() {
		List<Car> lista=repoUser.findAll();
		return lista;
	}

	@Override
	public List<Car> listarCarUser(int useri) {
		
		List<Car> lista= repoUser.findByUserid(useri);
		return lista;
	}

	

}
