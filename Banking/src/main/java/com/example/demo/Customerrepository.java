package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Customerrepository extends JpaRepository<Customers,String>{
	Customers findByEmail(String email);
	Customers findByName(String name);
}
