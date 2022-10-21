package tw.com.fasterospring.common;

import java.util.regex.Pattern;

public class Regex {
	
	public static boolean emailCheck(String emailAddress) {
	    return Pattern.compile("^(?=.{6,40}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
	            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
	      .matcher(emailAddress)
	      .matches();
	}
	
	public static boolean passwordCheck(String password) {
		return Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$")
	      .matcher(password)
	      .matches();
	}
	
	public static boolean nameCheck(String name) {
		return Pattern.compile("^[\\u4e00-\\u9fa5]+$|^[a-zA-Z\\s]+$")
				.matcher(name)
				.matches();
		
	}
	
	public static boolean phoneCheck(String phone) {
		
		return Pattern.compile("^09[0-9]{8}$")
				.matcher(phone)
				.matches();
	}
	
	public static boolean idcheck(String id) {
		
		return Pattern.compile("^[A-Za-z][12]\\d{8}$")
				.matcher(id)
				.matches();
	}

}
