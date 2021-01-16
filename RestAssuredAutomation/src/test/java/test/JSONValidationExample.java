package test;



import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;
public class JSONValidationExample {
	
	@Test 
	
	public void get()
	{
		baseURI = "https://reqres.in/api";
		given().get("/users?page=2").then().
		assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json")).
		statusCode(200).log().all();
	
	}


}
