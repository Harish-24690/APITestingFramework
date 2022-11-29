package utilities;

import org.json.JSONObject;
import org.testng.Assert;

import listeners.CustomListeners;

public class TestUtil {

	public static boolean jsonHasKey(String json, String key) {

		JSONObject jsonObject = new JSONObject(json);
		Boolean actual = jsonObject.has(key);
		CustomListeners.testReport.get().info("Validating the presence of key--->"+key);
		return actual;
	}

	public static String jsonKeyValue(String json, String key) {

		JSONObject jsonObject = new JSONObject(json);
		String actual_id = jsonObject.get(key).toString();
		CustomListeners.testReport.get().info("Validating the Value of presence of key-->"+key);
		return actual_id;
	}

}
