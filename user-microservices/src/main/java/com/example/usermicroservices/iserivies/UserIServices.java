package com.example.usermicroservices.iserivies;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.example.usermicroservices.entity.User;
import com.example.usermicroservices.modelo.Car;

public interface UserIServices {
	
	public void guardarUser(User clase);
	public List<User> listarUser();
	public void guardar(Car clase);
	public List<Object> ListCarUser(int id);

}
