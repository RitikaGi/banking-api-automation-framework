package com.api.base;

import static io.restassured.RestAssured.*;
import com.api.filters.LoggingFilter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	
	private static final String BASE_URL="http://64.227.160.186:8080";
	private RequestSpecification requestSpec;
	
	static{
		RestAssured.filters(new LoggingFilter());
	}
	
	protected BaseService(){
		requestSpec=given().baseUri(BASE_URL);
	}
	
	protected void setAuthToken(String token) {
		requestSpec.header("Authorization","Bearer "+token);
	}
	
	protected Response postRequest(Object payload, String endpoint) {
		return requestSpec.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	protected Response putRequest(Object payload, String endpoint) {
		return requestSpec.contentType(ContentType.JSON).body(payload).put(endpoint);
	}
	
	protected Response getRequest(String endpoint) {
		return requestSpec.get(endpoint);
	}

}
