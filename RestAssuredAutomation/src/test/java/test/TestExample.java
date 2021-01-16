package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class TestExample {
	
	@Test
	
	public void test_1()
	{
		Response response = get("http://innovate-stage-209385288.us-east-1.elb.amazonaws.com/api/v2/supply/getAllocatedSurveys");
		response.getHeaders();
		response.getBody();
		System.out.println(response.getStatusCode());
		System.out.println(response.getContentType());
		System.out.println(response.getBody());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		int statuscode =  response.getStatusCode();
		Assert.assertEquals(statuscode, 401);
		

	}
	@Test
	public void test_2()
	{
		baseURI="https://reqres.in";
		given().get("/api/users?page=2").
		then().
		statusCode(200).body("data[1].id", equalTo(8)).
		log().all();
		
		
	}
	
}
