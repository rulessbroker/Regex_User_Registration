package com.bridgelabz.regex.UserRegistrationTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import com.bridgelabz.regex.InvalidUserDetailsException;
import com.bridgelabz.regex.UserRegistrationRegex;

class UserRegistrationTest {

	static UserRegistrationRegex userRegistration;

	@BeforeAll
	public static void initialize() {
		userRegistration = new UserRegistrationRegex();
	}

	@Test
	public void givenFirstName_WhenValid_ShouldReturnsTrue() throws InvalidUserDetailsException {
		boolean result = userRegistration.name.validate("Abc");
		Assertions.assertTrue(result);
	}

	@Test
	public void givenFirstName_WhenInValid_ShouldThrowInvalidUserDetailsException() {
		Assertions.assertThrows(InvalidUserDetailsException.class, () -> userRegistration.name.validate("ab"));
	}

	@Test
	public void givenLastName_WhenValid_ShouldReturnTrue() throws InvalidUserDetailsException {
		boolean result = userRegistration.name.validate("Xyz");
		Assertions.assertTrue(result);
	}

	@Test
	public void givenLastName_WhenInValid_ShouldThrowInvalidUserDetailsException() {
		Assertions.assertThrows(InvalidUserDetailsException.class, () -> userRegistration.name.validate("xy"));
	}

	@Test
	public void givenEmail_WhenValid_ShouldReturnTrue() throws InvalidUserDetailsException {
		boolean result = userRegistration.email.validate("Abc.def@xyz.co.in");
		Assertions.assertTrue(result);
	}

	@Test
	public void givenEmail_WhenInValid_ShouldThrowInvalidUserDetailsException() {
		Assertions.assertThrows(InvalidUserDetailsException.class, () -> userRegistration.email.validate("Abc.co.in"));
	}

	@Test
	public void givenMobileNumber_WhenValid_ShouldReturnTrue() throws InvalidUserDetailsException {
		boolean result = userRegistration.mobileNo.validate("91 9874561230");
		Assertions.assertTrue(result);
	}

	@Test
	public void givenMobileNumber_WhenInValid_ShouldThrowInvalidUserDetailsException() {
		Assertions.assertThrows(InvalidUserDetailsException.class,
				() -> userRegistration.mobileNo.validate("965874526"));
	}

	@Test
	public void givenPassword_WhenValid_ShouldReturnTrue() throws InvalidUserDetailsException {
		boolean result = userRegistration.password.validate("A54tbh15@");
		Assertions.assertTrue(result);
	}

	@Test
	public void givenPassword_WhenInValid_ShouldThrowInvalidUserDetailsException() {
		Assertions.assertThrows(InvalidUserDetailsException.class, () -> userRegistration.password.validate("96526d"));
	}

	@ParameterizedTest
	@ValueSource(strings = { "abc@yahoo.com", "abc-100@yahoo.com", "abc.100@yahoo.com", "abc111@abc.com",
			"abc-100@abc.net", "abc.100@abc.com.au", "abc@1.com", "abc@gmail.com.com", "abc+100@gmail.com" })
	public void givenEmail_WhenValid_ShouldReturnTrue(String email) throws InvalidUserDetailsException {
		Assertions.assertTrue(userRegistration.email.validate(email));
	}

	@ParameterizedTest
	@ValueSource(strings = { "abc", "abc@.com.my", "abc123@gmail.a", "abc123@.com", "abc123@.com.com",
			"abc()*@gmail.com", "abc@%*.com", "abc..2002@gmail.com", "abc.@gmail.com", "abc@abc@gmail.com",
			"abc@gmail.com.1a", "abc@gmail.com.aa.au" })
	public void givenEmail_WhenInValid_ShouldThrowInvalidUserDetailsException(String email) {
		Assertions.assertThrows(InvalidUserDetailsException.class, () -> userRegistration.email.validate(email));
	}
}
