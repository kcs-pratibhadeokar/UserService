package com.kcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kcs.entity.Account;
import com.kcs.entity.Address;
import com.kcs.entity.User;
import com.kcs.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userservice;
@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/") 
	public String welcome()
	{
		return "Welcome to Home Page";
	}
	@GetMapping("/UserDetails")
	public List<User> getUserDetails() {
		return userservice.getAllUsers();
	}
	@GetMapping("/AccountID/{accid}")
	public Account getAccountDetails(@PathVariable int accid) {
		
	//return	restTemplate.getForObject("http://localhost:9003/AccountById/"+accid, Account.class);
		return userservice.getAccByaccId(accid);
	}
	@PostMapping("/SaveUser")
	public String saveUser(@RequestBody User user)
	{
	return	userservice.saveUser(user);
	}
	
	@GetMapping("/UserAddresses/{uid}")
	public List<Address> getAddressesByuid(@PathVariable int uid) {
		
	//return	restTemplate.getForObject("http://localhost:9003/AccountById/"+accid, Account.class);
		return userservice.getAddresesByUid(uid);
	}
	
}
