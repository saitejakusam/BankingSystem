package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustServiceImpl implements CustomerService{

	@Autowired
	private Customerrepository custrep;
	

	
	@Override
	public List<Customers> getAllCustomers() {
		List<Customers> optional=custrep.findAll();
		return optional;
	}



	@Override
	public Customers getCustomersById(String email) {
		Optional<Customers> optional=custrep.findById(email);
		Customers expense=null;
		if(optional.isPresent()) {
			expense=optional.get();
		}
		else {
			throw new RuntimeException("Expense not found for id :" + email);
		}
		return expense;
	}



	@Override
	public void deleteCustomerByEmail(String email) {
		this.custrep.deleteById(email);
		
	}



	}


