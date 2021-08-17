package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface TransactionService {
	
	List<Transaction> getAllTransaction();
	
	Transaction getTransactionById(long id);


}
