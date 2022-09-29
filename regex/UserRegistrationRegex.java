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

	public Validator email = (email) -> {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@([a-z1-9]+)([.][a-z]*)?(\\.[a-z]{2,})$");
		boolean isValid = pattern.matcher(email).matches();
		if (isValid) {
			return true;
		} else {
			throw new InvalidUserDetailsException("Invalid email => " + email);
		}
	};
	
	public Validator mobileNo = (mobileNo) -> {
        Pattern pattern = Pattern.compile("^[\\d]{2}\\s[\\d]{10}$");
        boolean isValid = pattern.matcher(mobileNo).matches();
        if (isValid) {
            return true;
        } else {
            throw new InvalidUserDetailsException("Invalid Mobile Number => " + mobileNo);
        }
    };
}

interface Validator {
	boolean validate(String data) throws InvalidUserDetailsException;
}