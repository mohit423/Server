package com.example.demo.service;

import com.example.demo.entity.ServerResponse;
import com.example.demo.entity.UserDetails;

public interface ServerService {

	public ServerResponse loginService(UserDetails user);
	
	public ServerResponse registerService(UserDetails user);
	
	public ServerResponse modifyService(UserDetails user);
	
	public ServerResponse passwordMatchService(String password);
	
	public ServerResponse deleteService(String password);
	
	public UserDetails view();
}
