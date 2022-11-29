package setUp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import utilities.ExcelReader;

public class BaseTest {
	
	public static Properties prop = new Properties();
	public FileInputStream fis;
	public static ExcelReader excel = new ExcelReader("C:/Rest-assured/APITestingFramework1/src/test/resources/excel/TestData.xlsx");
	
	@BeforeSuite
	public void setUp(){
		
		
		
		try {
			fis= new FileInputStream("C:\\Rest-assured\\APITestingFramework1\\src\\test\\resources\\properties\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RestAssured.baseURI=prop.getProperty("baseURI");
		RestAssured.basePath=prop.getProperty("basePath");
		
	}
	
	@AfterSuite
	public void tearDown(){
		
		
	}

}
