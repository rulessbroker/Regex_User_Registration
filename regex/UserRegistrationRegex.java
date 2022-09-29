package com.bridgelabz.regex;

import java.util.regex.Pattern;

public class UserRegistrationRegex {
	 public Validator name = (name) -> {
	        Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z]{2,}");
	        boolean isValid = pattern.matcher(name).matches();
	        if (isValid) {
	            return true;
	        } else {
	            throw new InvalidUserDetailsException("Invalid Name => " + name);
	        }
	    };
}

 interface Validator {
    boolean validate(String data) throws InvalidUserDetailsException;
}