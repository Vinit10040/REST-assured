package Demodatadriven;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.mozilla.javascript.ObjArray;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import test.DataForTest;

public class DatadrivenExample extends DataForTest {
	
	
	
	//@Test(dataProvider = "dateforpost") 
	public void post(String firsname, String lastname,int subjectid)
	{
	   
		JSONObject request = new JSONObject();
		request.put("firstName", firsname);
		request.put("lastName", lastname);
		request.put("subjectId",subjectid);
		
		baseURI = "http://localhost:3000/"; 
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when().post("users").then().statusCode(201).log().all();
       
	}
	
//@Test(dataProvider = "deleteuserid")
	
public void delete(int userid)
	{
		System.out.println("value is"+userid);
		baseURI = "http://localhost:3000/";
		when().delete("/users/"+userid).then().statusCode(200).log().all();
	}
	
      @Parameters("userid")
      @Test
public void delete2(int userid)
	{
		System.out.println("value is"+userid);
		baseURI = "http://localhost:3000/";
		when().delete("/users/"+userid).then().statusCode(200).log().all();
	}
	
}
