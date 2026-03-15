package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.services.AuthService;
import com.api.services.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.UserProfileRequest;
import com.api.models.response.LoginResponse;

import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {
	
	@Test(description="Verify if Update Profile API is working...")
	public void updateProfileInfoTest() {
		AuthService authService=new AuthService();
		 Response response=authService.login(new LoginRequest("uday1234", "uday12345"));
		 System.out.println(response.asPrettyString());
		 LoginResponse loginResponse = response.as(LoginResponse.class);
		 
		 UserManagementService userManagementService = new UserManagementService();
		 response=userManagementService.getProfile(loginResponse.getToken());
		 
		 UserProfileResponse userProfileResponse=response.as(UserProfileResponse.class);
		 System.out.println(response.asPrettyString());
		 Assert.assertEquals(userProfileResponse.getUsername(),"uday1234");
		 
		 UserProfileRequest userProfileRequest = new UserProfileRequest.Builder()
				 .firstName("Ritu")
				 .lastName("Singh")
				 .email("ritusingh34@gmail.com")
				 .mobileNumber("3353646567")
				 .build();
		 
		 response=userManagementService.updateProfile(loginResponse.getToken(),userProfileRequest);
		 System.out.println(response.asPrettyString());
	}

}
