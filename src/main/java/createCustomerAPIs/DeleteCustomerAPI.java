package createCustomerAPIs;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;



import io.restassured.response.Response;
import setUp.BaseTest;

public class DeleteCustomerAPI extends BaseTest{

	public static Response deleteCustomerAPIWithValidKey(Hashtable<String,String>data) {

		Response response = given().auth().basic(prop.getProperty("validApiKey"), "")
				.delete(prop.getProperty("customerEndPoint") + "/" + data.get("id"));
		return response;
	}

}
