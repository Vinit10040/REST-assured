package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class PutPatchDeleteExample {
	
	@Test
	
	public void puttest()
	{
		JSONObject request = new JSONObject();
		request.put("name", "vin");
		request.put("Job", "QA");
		System.out.println(request.toJSONString());
		baseURI = "https://reqres.in";
		given().
		header("Content-Type","Application/Json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).
		when().put("/api/users/2").
		then().statusCode(200).log().all();
		
	}
     @Test
	
	public void patchtest()
	{
		JSONObject request = new JSONObject();
		request.put("name", "vin");
		request.put("Job", "QA");
		System.out.println(request.toJSONString());
		baseURI = "https://reqres.in";
		given().
		header("Content-Type","Application/Json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).
		when().patch("/api/users/2").
		then().statusCode(200).log().all();
		
	}
     @Test
 	
 	public void deletetest()
 	{
 		
 		baseURI = "https://reqres.in";
 		when().delete("/api/users/2").
 		then().statusCode(204).log().all();
 		
 	}

}
