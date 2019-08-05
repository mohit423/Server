package DummyObjectFactory;

import com.example.demo.entity.ServerResponse;
import com.example.demo.entity.UserDetails;

public class DummyObjectFactory {

	public static ServerResponse getDummyResponseStatus() {
		
		ServerResponse serverResponse = new ServerResponse();
		serverResponse.setStatus("success");
		
		return serverResponse;
	}
	
	public static UserDetails getDummyUserDetails() {
		UserDetails userDetails = new UserDetails();
		userDetails.setAccount(12345);
		userDetails.setDob("20-11-1996");
		userDetails.setEmail("dummyEmail@domain.com");
		userDetails.setName("dumyName");
		userDetails.setPassword("dummyPassword");
		userDetails.setPhone("987453210");
		return userDetails;
	}
}
