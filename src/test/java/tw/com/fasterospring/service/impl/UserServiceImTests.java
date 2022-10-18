package tw.com.fasterospring.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.com.fasterospring.service.intf.UserService;

@SpringBootTest
public class UserServiceImTests {
	
	@Autowired UserService service;

	@Test
	public void testLogin() {
		
		service.login("123456@gmail.com", "123456");
		
	}
	
}
