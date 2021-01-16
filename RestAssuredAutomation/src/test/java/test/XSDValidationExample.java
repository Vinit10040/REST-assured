package test;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers;

public class XSDValidationExample {

	@Test
	public void xsdexample() throws IOException
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
		and().body("//*:AddResult.text()", equalTo("10")).and().
		assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("calculator.xsd"));
		//and().assertThat().body(RestAssuredMatchers.matchesXsd("./SOAPRequest/calculator.xsd"));
		
	}
}
