package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Transaction {
	
	public Transaction() {
		
	}
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long Id;


private long amount;

private int accountnumber;

private String sender;

private String receiver;

public Transaction(long id, long amount, int accountnumber, String sender, String receiver) {
	super();
	Id = id;
	
	this.amount = amount;
	this.accountnumber = accountnumber;
	this.sender = sender;
	this.receiver = receiver;
}

public long getId() {
	return Id;
}

public void setId(long id) {
	Id = id;
}

public long getAmount() {
	return amount;
}

public void setAmount(long amount) {
	this.amount = amount;
}

public int getAccountnumber() {
	return accountnumber;
}

public void setAccountnumber(int accountnumber) {
	this.accountnumber = accountnumber;
}

public String getSender() {
	return sender;
}

public void setSender(String sender) {
	this.sender = sender;
}

public String getReceiver() {
	return receiver;
}

public void setReceiver(String receiver) {
	this.receiver = receiver;
}


}
