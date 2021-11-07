package com.example.usermicroservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.usermicroservices.entity.User;




@Repository
public interface IUserRepo extends JpaRepository<User, Integer>{

}
