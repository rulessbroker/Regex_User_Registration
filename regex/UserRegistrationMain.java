package com.bridgelabz.regex;

import java.util.Scanner;

public class UserRegistrationMain {

	public static void main(String[] args) throws InvalidUserDetailsException {

		UserRegistrationRegex regex = new UserRegistrationRegex();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter first name: ");
		regex.name.validate(scanner.next());

		System.out.println("\nEnter last name: ");
		regex.name.validate(scanner.next());
	}

}
