package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class transserviceimpl implements TransactionService{
	
	
	@Autowired
	private Transactionrepo trrepo;

	@Override
	public List<Transaction> getAllTransaction() {
		List<Transaction> optional=trrepo.findAll();
		return optional;
	}

	@Override
	public Transaction getTransactionById(long id) {
		Optional<Transaction> optional=trrepo.findById(id);
		Transaction trnx=null;
		if(optional.isPresent()) {
			trnx=optional.get();
		}
		else {
			throw new RuntimeException("Expense not found for id :" + id);
		}
		return trnx;
	}
	}


