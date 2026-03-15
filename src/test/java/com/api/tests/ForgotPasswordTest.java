package com.api.tests;

import org.testng.annotations.Test;

import com.api.services.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	
	@Test(description="Verify if the Forgot Password API is working...")
    public void forgotPassword() {
		AuthService authService = new AuthService();
		Response response=authService.forgotPassword("ritu123@gmail.com");
		System.out.println(response.asPrettyString());
	}
	
}
