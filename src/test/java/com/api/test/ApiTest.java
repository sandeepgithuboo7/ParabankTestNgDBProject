package com.api.test;

import java.util.Properties;

import org.testng.annotations.Test;

import com.api.page.ApiPage;
import com.framework.utilities.ReadProp;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ApiTest extends ApiPage{
	
	Properties prop = ReadProp.readData("Config.properties");
	String projectName=null;
	
	@Test
	public void verifyCreateRepositoryRequest() {
		RestAssured.baseURI=prop.getProperty("baseurl");
		String token="Bearer "+prop.getProperty("token");
		String endpoint="/user/repos";
		projectName="RestAssuredProject";
		String requestBody=getRequestBodyToCreateNewRepo(projectName);
		
		Response response= given()
				.contentType("application/json")
				.headers("Authorization",token)
				.body(requestBody)
				.when()
				.post(endpoint);
//		token = response.getBody().jsonPath().getString("token");
		
		verifyStatusCode(response, 201);
		verifyStatusMessage(response, "Created");
		verifyResponseTime(response,2);
		verifyResponseBody(response, "name", projectName);
	}
	
	@Test
	public void verifyDeleteRepositoryRequest() {
		RestAssured.baseURI=prop.getProperty("baseurl");
		String token="Bearer "+prop.getProperty("token");
		String endpoint="/repos/"+prop.getProperty("username")+"/"+projectName;
			
		Response response= given()
				.contentType("application/json")
				.headers("Authorization",token)
				.when()
				.delete(endpoint);
		
		verifyStatusCode(response, 204);
		verifyStatusMessage(response, "No Content");
		verifyResponseTime(response,2);
	}

}
