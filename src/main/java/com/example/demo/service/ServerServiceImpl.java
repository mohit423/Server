package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ServerResponse;
import com.example.demo.entity.UserDetails;


@Service
public class ServerServiceImpl implements ServerService {
	
	private UserRepository userRepository;
	ServerResponse response=new ServerResponse();
	int account_number;
	
	@Autowired
	public ServerServiceImpl(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	private ServerResponse passwordCheck(UserDetails user) {
		UserDetails userCheck=userRepository.getOne(user.getAccount());
		String passwordCheck=userCheck.getPassword();
		if(passwordCheck.equals(user.getPassword())) {
			account_number=user.getAccount();
			response.setStatus("success");
		}
			
		else
			response.setStatus("passfail");
		return response;
	}
	
	private String getPassword(int account) {
		return userRepository.getOne(account).getPassword();
	}
	
	@Override
	public ServerResponse loginService(UserDetails user) {
		
		boolean test=userRepository.existsById(user.getAccount());
		if(test==true) {
			response=passwordCheck(user);
		}
		else
			response.setStatus("accountfail");
		return response;
	}
	
	@Override
	public ServerResponse registerService(UserDetails user) {
		boolean test=userRepository.existsById(user.getAccount());
		if(test==false) {
			userRepository.save(user);
			response.setStatus("success");
		}
		else
			response.setStatus("exists");
		return response;
	}
	
	@Override
	public ServerResponse modifyService(UserDetails user) {
		UserDetails field=userRepository.getOne(account_number);
		try {
		if(user.getDob()!=null && !user.getDob().isEmpty())
			field.setDob(user.getDob());
		if(user.getEmail()!=null && !user.getEmail().isEmpty())
			field.setEmail(user.getEmail());
		if(user.getName()!=null && !user.getName().isEmpty())
			field.setName(user.getName());
		if(user.getPhone()!=null && !user.getPhone().isEmpty())
			field.setPhone(user.getPhone());
		if(user.getPassword()!=null && !user.getPassword().isEmpty())
			field.setPassword(user.getPassword());
		if(user.getFathername()!=null && !user.getFathername().isEmpty())
			field.setFathername(user.getFathername());
		if(user.getMothername()!=null && !user.getMothername().isEmpty())
			field.setMothername(user.getMothername());
		if(user.getGender()!=null && !user.getGender().isEmpty())
			field.setGender(user.getGender());
		if(user.getAdhaar()!=null)
			field.setAdhaar(user.getAdhaar());
		if(user.getPan()!=null)
			field.setPan(user.getPan());	
		if(user.getBloodgroup()!=null && !user.getBloodgroup().isEmpty())
			field.setBloodgroup(user.getBloodgroup());
		if(user.getAlternatenumber()!=null && !user.getAlternatenumber().isEmpty())
			field.setAlternatenumber(user.getAlternatenumber());;
		userRepository.save(field);
		response.setStatus("success");
		}
		catch(Exception exception) {
			response.setStatus("fail");
		}
		return response;
	}
	
	@Override
	public ServerResponse passwordMatchService(String password) {
		if(password.equals(getPassword(account_number)))
		{
			response.setStatus("success");
		}
		else {
			 response.setStatus("fail");}
		return response;
	}
	
	@Override
	public ServerResponse deleteService(String password) {
		response=passwordMatchService(password);
		if(response.getStatus().equals("success"))
			 userRepository.deleteById(account_number);
		 return response;
	}
	
	@Override
	public UserDetails view() {
		    return userRepository.getOne(account_number);
	}
	
	
	

}


