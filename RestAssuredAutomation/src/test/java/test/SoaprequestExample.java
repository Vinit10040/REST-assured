package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
public class SoaprequestExample {

	@Test
	
	public void soaprequest() throws IOException 
	{
		File file = new File("./SOAPRequest/Add.xml");
		if(file.exists())
		{
			System.out.println(">> file exist");
		}
		
		FileInputStream filein = new FileInputStream(file);
		String requestbody = IOUtils.toString(filein, "UTF-8");
		
		RestAssured.baseURI = "http://www.dneonline.com/";
		RestAssured.given().contentType("text/xml").
		body(requestbody).when().post("calculator.asmx").then().statusCode(200).log().all().
		and().body("//*:AddResult.text()", equalTo("10"));
		
	
	}
	}
