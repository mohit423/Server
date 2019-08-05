package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.ServerResponse;
import com.example.demo.entity.UserDetails;
import com.example.demo.service.ServerServiceImpl;

@RestController
@EnableAutoConfiguration
//base url mapping for controller
@RequestMapping(value="/bank")
public class ServerController {

	//ServerServices Contains services and operations on database
	private ServerServiceImpl serverService;  
	//ResponseStatus stores response to be send to client end
	private ServerResponse serverResponse;       
	
	//autowired the service class using constructor
	@Autowired
	public ServerController(ServerServiceImpl serverServiceImpl) {
		this.serverService=serverServiceImpl;
	}
	
	//server login url mapping for user
	@PostMapping(value="/login", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ServerResponse> login(@RequestBody UserDetails details) {
		serverResponse=serverService.loginService(details);
	    return new ResponseEntity<ServerResponse>(serverResponse,HttpStatus.OK);
	}
	
	//server register url mapping for user
	@PostMapping(value="/register", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ServerResponse> register(@RequestBody UserDetails details) {
		serverResponse=serverService.registerService(details);
		return new ResponseEntity<ServerResponse>(serverResponse,HttpStatus.OK);
		}
	
	//server modify url mapping for user
	@PostMapping(value="/modify", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ServerResponse> modify(@RequestBody UserDetails details) {
		serverResponse=serverService.modifyService(details);
		return new ResponseEntity<ServerResponse>(serverResponse,HttpStatus.OK);
		}
	
	//server delete url mapping for user
	@PostMapping(value="/delete", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ServerResponse> delete(@RequestBody UserDetails user) {
		serverResponse=serverService.deleteService(user.getPassword());
		return new ResponseEntity<ServerResponse>(serverResponse,HttpStatus.OK);
	}	
	
	//server view user url mapping
	@PostMapping(value="/userDetails", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserDetails> userdetails() {
		UserDetails details=serverService.view();
		return new ResponseEntity<UserDetails>(details,HttpStatus.OK);
	}
	
	//server password checking url for user
	@PostMapping(value="/modifyPassCheck", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ServerResponse> modifyPassCheck(@RequestBody UserDetails user) {
		serverResponse=serverService.passwordMatchService(user.getPassword());
		return new ResponseEntity<ServerResponse>(serverResponse,HttpStatus.OK);
	}
	
}
