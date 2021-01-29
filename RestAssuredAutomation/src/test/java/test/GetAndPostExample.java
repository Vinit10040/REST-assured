package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetAndPostExample {
	
	//@Test
	
	public void getexample() {
		baseURI = "https://reqres.in";
		given().get("/api/users?page=2").
		then().statusCode(200).
		body("data[1].first_name", equalTo("Lindsay")).
		body("data.first_name", hasItems("George","Rachel"));

		
	}
	
	//@Test
	
	public void postexample()
	{
	/*	Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", "vin");
		map.put("Job", "QA");
		System.out.println(map);
		System.out.println(request.toJSONString());
		*/
		JSONObject request = new JSONObject();
		request.put("name", "vin");
		request.put("Job", "QA");

		System.out.println(request.toJSONString());

		baseURI = "https://reqres.in/api";
		given().
		header("Content-Type","Application/Json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when().post("/users").then().statusCode(201).log().all();
	}
	
	//@Test
	
	public void getAllocatedSurveys() {
		
		baseURI = "http://innovate-stage-209385288.us-east-1.elb.amazonaws.com";
		
		given().header("X-access-token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVmZTJlNWM1YTZlMDk0NmVmYmU2YTRjZCIsInVzcl9pZCI6NTAyNiwidXNyX3R5cGUiOiJzdXBwbGllciIsImlhdCI6MTYxMDMwMTU4N30.8mqhwn1LL7kiHA1CeddSlH4770yvlABvVoOrO_odK_4" )
		.get("/api/v2/supply/getAllocatedSurveys").then().statusCode(200).log().all();
	}
	
	
	//access private API using  outh2
	
	@Test 
	public void getAllocatedSurveys2()
	{
		baseURI = "http://innovate-stage-209385288.us-east-1.elb.amazonaws.com";
		given().auth().
        oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYwMDdmMDQ5Nzc1ZDA2MGZiNGVlZTZmYiIsInVzcl9pZCI6NTAzMywidXNyX3R5cGUiOiJzdXBwbGllciIsImlhdCI6MTYxMTEzNTEzNX0.GucRE8lkpAelaRkMZN_c5F_G6CARIFRJCq19sVAC2L8").	
	    //when().get("/api/v2/supply/getAllocatedSurveys").
	    when().get("/api/v2/supply/getAllocatedSurveys").
	    then().assertThat().
	    statusCode(200).log().all();
	}
	//@Test
	
	public void getUniqueIpAndPID() {
		
		JSONObject request =new JSONObject();
		request.put("survNum", "86076");
		request.put("pid", "Qa2");
		request.put("ip", "1.23.82.137");
		System.out.println(request.toJSONString());

		baseURI = "http://innovate-stage-209385288.us-east-1.elb.amazonaws.com";
		given().header("x-access-token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVmZWMxNjNhYThiYmJiM2RhYzBkNWNjYiIsInVzcl9pZCI6NTAwNCwidXNyX3R5cGUiOiJzdXBwbGllciIsImlhdCI6MTYxMDQzNDQyMH0.vlurSyhhWhx9PTXv83PT5hbMfmtw22XNf6g1gr9inb8").
		header("Content-Type","Application/Json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when().post("/api/v2/supply/allowUniquePIDAndIP").then().statusCode(200).log().all();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}	

