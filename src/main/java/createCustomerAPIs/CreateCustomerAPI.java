package createCustomerAPIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import io.restassured.response.Response;
import setUp.BaseTest;

public class CreateCustomerAPI extends BaseTest{

	public static Response createCustomerAPIWithValidAPIKey(Hashtable<String,String>data) {
		Response response = given().auth()
				.basic(prop.getProperty("validApiKey"),"")
				.formParam("email", data.get("email"))
				.formParam("description", data.get("description"))
				.post(prop.getProperty("customerEndPoint"));
		return response;

	}

	public static Response createCustomerAPIWithInValidAPIKey(Hashtable<String,String>data) {
		Response response = given().auth()
				.basic(prop.getProperty("inValidAPIKey"),"")
				.formParam("email", data.get("email"))
				.formParam("description", data.get("description"))
				.post(prop.getProperty("customerEndPoint"));
		return response;

	}

}
