package testcases;

import setUp.BaseTest;
import utilities.DataUtil;
import utilities.TestUtil;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import createCustomerAPIs.DeleteCustomerAPI;
import io.restassured.response.Response;
import listeners.CustomListeners;

public class DeleteCustomer extends BaseTest {
	
	@Test(dataProviderClass=DataUtil.class,dataProvider="data")
	public void deleteCustomer(Hashtable<String,String>data){
		
		Response response = DeleteCustomerAPI.deleteCustomerAPIWithValidKey(data);
		response.prettyPrint();
		CustomListeners.testReport.get().info(data.toString());
		System.out.println(response.getStatusCode());
		
	
		String actual_id=TestUtil.jsonKeyValue(response.asString(), "id");
		System.out.println("The id of the deletdCustomer--->"+actual_id);
		
		Assert.assertEquals(actual_id, data.get("id"),"this is not actual key");
		
		
	     Boolean actual=TestUtil.jsonHasKey(response.asString(), "id");
	     System.out.println("This is the actual id of the deleted customer-->"+actual);
	     Assert.assertTrue(actual,"This is not the actual Key expected");
	
	}

}
