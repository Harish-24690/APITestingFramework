package testcases;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;

import org.testng.Assert;

import org.testng.annotations.Test;

import createCustomerAPIs.CreateCustomerAPI;
import io.restassured.response.Response;
import listeners.CustomListeners;
import setUp.BaseTest;
import utilities.DataUtil;

public class CreateCustomer extends BaseTest {

	@Test(dataProviderClass=DataUtil.class,dataProvider="data")
	public void validateCreateCustomer(Hashtable<String,String>data) {

		Response response= CreateCustomerAPI.createCustomerAPIWithValidAPIKey(data);
		response.prettyPrint();
		System.out.println(response.statusCode());
		CustomListeners.testReport.get().info(data.toString());
		Assert.assertEquals(200, response.statusCode());

	}

	@Test(dataProviderClass=DataUtil.class,dataProvider="data")
	public void validateCreateCustomerwithInvalidAuthKey(Hashtable<String,String>data) {

		Response response =CreateCustomerAPI.createCustomerAPIWithInValidAPIKey(data);
		response.prettyPrint();
		CustomListeners.testReport.get().info(data.toString());
		System.out.println(response.statusCode());
      Assert.assertEquals(401, response.statusCode());
	}
	
	
	
	

}
