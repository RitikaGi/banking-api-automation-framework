package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.services.AuthService;
import com.api.services.UserManagementService;
import com.api.models.request.LoginRequest;

import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;


import io.restassured.response.Response;
@Listeners(com.api.listeners.TestListener.class)

public class GetProfileRequestTest {
	
	@Test(description="Verify if the Get Profile Request is working...")
    public void getProfileInfoTest() {
		 AuthService authService=new AuthService();
		 Response response=authService.login(new LoginRequest("uday1234", "uday12345"));
		 
		 LoginResponse loginResponse = response.as(LoginResponse.class);
		 UserManagementService userManagementService = new UserManagementService();
		 response=userManagementService.getProfile(loginResponse.getToken());
		 UserProfileResponse userManagementResponse=response.as(UserProfileResponse.class);
		 System.out.println(response.asPrettyString());
		
		 Assert.assertEquals(userManagementResponse.getUsername(),"uday1234");
		 
	}
}
