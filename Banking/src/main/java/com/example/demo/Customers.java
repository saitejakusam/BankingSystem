package com.example.demo;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customers {

	public Customers() {
		
	}
	
	@Id
	private String email;
	
	private String name;
	
	private long balance;
	
	private int accountnumber;
	
	public int getAccountnumber() {
		return accountnumber;
	}


	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}

	public Customers(String email, String name, long balance,int accountnumber) {
		super();
		this.email = email;
		this.name = name;
		this.balance = balance;
		this.accountnumber=accountnumber;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	
}
