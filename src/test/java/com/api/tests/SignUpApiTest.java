package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class SignUpApiTest {
	
	@Test(description="Verify the SignUp API is working...")
	public void createAccountTest() {
		SignUpRequest signUpRequest= new SignUpRequest.Builder()
		.username("ritu123")
		.email("ritu123@gmail.com")
		.password("ritu@123")
		.firstName("Ritu")
		.lastName("Singh")
		.mobileNumber("3435353663")
		.build();
		
		AuthService authService= new AuthService();
		Response response=authService.signUp(signUpRequest);
		
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
	}
	
	

}
