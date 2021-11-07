package com.example.carmicroservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carmicroservices.entity.Car;

@Repository
public interface ICarRepo extends JpaRepository<Car, Integer>{
	
	List<Car> findByUserid(int user);
	

}
