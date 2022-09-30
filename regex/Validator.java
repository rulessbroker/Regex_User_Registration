package com.bridgelabz.regex;

public interface Validator {
	
	boolean validate(String data) throws InvalidUserDetailsException;
	
}
