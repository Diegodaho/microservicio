package com.example.carmicroservices.iserivies;

import java.util.List;

import com.example.carmicroservices.entity.Car;

public interface CarIServices {
	
	public void guardarUser(Car clase);
	public List<Car> listarUser();
	public List<Car> listarCarUser(int userid);
	
}
