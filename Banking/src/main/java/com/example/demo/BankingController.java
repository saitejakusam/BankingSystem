package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BankingController {

	String sender;
	String mail;
	
	@Autowired
	private CustomerService custser;
	
	@Autowired
	private Customerrepository rep;
	
	@Autowired
	private CustomerService customerservice;
	
	@Autowired
	private TransactionService serv;
	
	@Autowired
	Transactionrepo trpo;
	
	@Autowired
	Feedbackrep feedrep;

	private Transaction tr;
	
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	@PostMapping("/customersubmit")
	public String customer(Customers cust) {
		rep.save(cust);
		return "index";
	}
	
	@PostMapping("/Transfersubmit")
	public String transfer(Transaction trans,Customers cus) {
		Customers some=rep.findByEmail(mail);
		some.setBalance(some.getBalance()-trans.getAmount());
		trans.setSender(sender);
		trpo.save(trans);
		rep.save(some);
		return "Transactions";
	}	
	
	@GetMapping("/Customers")
	public String homies(Model model) {
		model.addAttribute("customers",custser.getAllCustomers());
		return "Customers";
	}
	
	@GetMapping("/Transactions")
	public String homies2(Model model) {
		model.addAttribute("transaction",serv.getAllTransaction());
		return "Transactions";
	}
	
	
	@GetMapping("/add")
	public String add() {
		return "add";
	}
	
	@GetMapping("/Trans")
	public String addo() {
		return "Transfer";
	}
	
	
	@GetMapping("/showFormForUpdate/{email}")
	public String showFormforupdates(@PathVariable(value="email") String email,Model model) {
		Customers customer= customerservice.getCustomersById(email);
		model.addAttribute("customers",customer);
		return "update";
	}
	
	@GetMapping("/showFormFortrans/{email}")
	public String showFormfortrans(@PathVariable(value="email") String email,Model model,Transaction tra) {
		Customers customer= customerservice.getCustomersById(email);
		Customers some=rep.findByEmail(email);
		mail=email;
		//Transaction tx=trpo.getById(idd);
		sender=customer.getName();
		Customers nn=rep.findByName(sender);
		tra.setSender(sender);
		//trpo.save(tra);
		some.setBalance(some.getBalance()-tra.getAmount());
		rep.save(some);
		model.addAttribute("customers",customer);
		return "Transfer";
	}
	
	@GetMapping("/Feedback")
	public String homieez() {
		return "Feedback";
	}

	@PostMapping("/feedbacksubmit")
	public String greetsings(Feedback feedback) {
		feedrep.save(feedback);
		return "index";
	}
	
	@GetMapping("/Deletecustomer/{email}")
	public String deleter(@PathVariable(value="email") String email,Model model) {
		this.customerservice.deleteCustomerByEmail(email);
		return "index";
	}
	
	
	@GetMapping("/Delete")
	public String delete(Model model) {
		model.addAttribute("customers",custser.getAllCustomers());
		return "Delete";
	}
}
