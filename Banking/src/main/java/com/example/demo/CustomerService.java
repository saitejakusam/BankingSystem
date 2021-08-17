package com.example.demo;
import java.util.List;
public interface CustomerService {
	List<Customers> getAllCustomers();
	
	Customers getCustomersById(String email);
	
	void deleteCustomerByEmail(String email);
}
