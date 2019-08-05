package ServerServiceTest;

import static DummyObjectFactory.DummyObjectFactory.getDummyResponseStatus;
import static DummyObjectFactory.DummyObjectFactory.getDummyUserDetails;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.entity.ServerResponse;
import com.example.demo.entity.UserDetails;
import com.example.demo.service.ServerService;
import com.example.demo.service.ServerServiceImpl;
import com.example.demo.service.UserRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ServerServiceTest {

	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	ServerService serverService = new ServerServiceImpl(userRepository);
	
	@Test
	public void test_loginService_Success() {
		
		//Dummy Objects
		ServerResponse serverResponse =getDummyResponseStatus();
		UserDetails userDetails = getDummyUserDetails();
		Boolean test = true;
		
		//when
		when(userRepository.existsById(anyInt())).thenReturn(test);
		when(userRepository.getOne(anyInt())).thenReturn(userDetails);
		
		//then
		ServerResponse result = serverService.loginService(userDetails);
		
		//assert
		assertThat(result.getStatus()).isEqualTo(serverResponse.getStatus());
		
	}
	
	@Test
	public void test_loginService_Fail() {
		
		//Dummy Object
		ServerResponse serverResponse =getDummyResponseStatus();
		serverResponse.setStatus("accountfail");
		UserDetails userDetails = getDummyUserDetails();
		Boolean test = false;
		
		//when
		when(userRepository.existsById(anyInt())).thenReturn(test);

		//then
		ServerResponse result = serverService.loginService(userDetails);
		
		//assert
		assertThat(result.getStatus()).isEqualTo(serverResponse.getStatus());
	}

	@Test
	public void test_registerService_Success() {
		
		//Dummy Object
		ServerResponse serverResponse =getDummyResponseStatus();
		UserDetails userDetails = getDummyUserDetails();
		Boolean test = false;
		
		//when
		when(userRepository.existsById(anyInt())).thenReturn(test);
		when(userRepository.save(userDetails)).thenReturn(userDetails);
		
		//then
		ServerResponse result = serverService.registerService(userDetails);
		
		//assert
		assertThat(result.getStatus()).isEqualTo(serverResponse.getStatus());
	}
	
	@Test
	public void test_registerService_Fail() {
		
		//Dummy Object 
		ServerResponse serverResponse =getDummyResponseStatus();
		serverResponse.setStatus("exists");
		UserDetails userDetails = getDummyUserDetails();
		Boolean test = true;
		
		//When
		when(userRepository.existsById(anyInt())).thenReturn(test);

		//Then
		ServerResponse result = serverService.registerService(userDetails);
		
		//assert
		assertThat(result.getStatus()).isEqualTo(serverResponse.getStatus());
	}
	
	@Test
	public void test_view_Success() {
		
		//Dummy Object
		UserDetails userDetails = getDummyUserDetails();
		
		//When
		when(userRepository.getOne(anyInt())).thenReturn(userDetails);
		
		//Then
		UserDetails result = serverService.view();
		
		//assert
		assertThat(result.getDob()).isEqualTo(userDetails.getDob());
		assertThat(result.getAccount()).isEqualTo(userDetails.getAccount());
		assertThat(result.getName()).isEqualTo(userDetails.getName());
		assertThat(result.getPhone()).isEqualTo(userDetails.getPhone());
		assertThat(result.getEmail()).isEqualTo(userDetails.getEmail());
		
		}
	
	@Test
	public void test_modifyService_Success() {
		
		//Dummy Object
		ServerResponse serverResponse =getDummyResponseStatus();
		UserDetails userDetails = getDummyUserDetails();
		userDetails.setName("newName");
		UserDetails updatedUser = userDetails;
		
		//When
		when(userRepository.getOne(anyInt())).thenReturn(userDetails);
		
		//Then
		ServerResponse result = serverService.modifyService(updatedUser);
		
		//Assert
		assertThat(serverResponse.getStatus()).isEqualTo(result.getStatus());
		
	}
	
	@Test
	public void test_passwordMatch_Success() {
		
		//Dummy Object
		ServerResponse serverResponse =getDummyResponseStatus();
		UserDetails userDetails = getDummyUserDetails();
		String password = "dummyPassword";
		
		//When
		when(userRepository.getOne(anyInt())).thenReturn(userDetails);
		
		//Then
		ServerResponse result = serverService.passwordMatchService(password);
		
		//Assert
		assertThat(result.getStatus()).isEqualTo(serverResponse.getStatus());
		
	}
	
	@Test
	public void test_passwordMatch_Fail() {
		
		//Dummy Object
		ServerResponse serverResponse =getDummyResponseStatus();
		serverResponse.setStatus("fail");
		UserDetails userDetails = getDummyUserDetails();
		String password = "duMmyPassword";
		
		//When
		when(userRepository.getOne(Mockito.anyInt())).thenReturn(userDetails);
		
		//Then
		ServerResponse result = serverService.passwordMatchService(password);
		
		//assert
		assertThat(result.getStatus()).isEqualTo(serverResponse.getStatus());
		
	}
	
	@Test
	public void test_deleteService_Success() {
		
		//Dummy Object
		ServerResponse serverResponse =getDummyResponseStatus();
		UserDetails userDetails = getDummyUserDetails();
		String password = "dummyPassword";
		
		//When
		when(userRepository.getOne(anyInt())).thenReturn(userDetails);
		
		//Then
		ServerResponse result = serverService.deleteService(password);
		
		//Assert
		assertThat(result.getStatus()).isEqualTo(serverResponse.getStatus());
		
	}
	
	@Test
	public void test_deleteService_Fail() {
		
		//Dummy Object
		ServerResponse serverResponse =getDummyResponseStatus();
		serverResponse.setStatus("fail");
		UserDetails userDetails = getDummyUserDetails();
		String password = "duMmyPassword";
		
		//When
		when(userRepository.getOne(Mockito.anyInt())).thenReturn(userDetails);
		
		//Then
		ServerResponse result = serverService.deleteService(password);
		
		//assert
		assertThat(result.getStatus()).isEqualTo(serverResponse.getStatus());
		
	}
}
