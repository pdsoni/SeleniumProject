package scenarios.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import searches.GoogleSearch;
import utilities.utils;

public class GoogleTest {

	public WebDriver driver;
	utils ut = new utils();
		
	@BeforeMethod()
	public void initializeTestBaseSetup()
	{
		driver = ut.setDriver(ut.getProperty("BrowserType"), ut.getProperty("appURL"));
	}
	
	@Test(priority = 1)
	public void googleSearch() {
		GoogleSearch goooglObj = PageFactory.initElements(driver, GoogleSearch.class);
		List<HashMap<String, String>> searchResults = new ArrayList<HashMap<String, String>>();
		System.out.println(ut.getProperty("SearchTerm"));
		searchResults = goooglObj.searchFor(ut.getProperty("SearchTerm"));
		System.out.println(Collections.singletonList(searchResults));
	}
	@Test (priority = 1)
	public void definePhrase() {
		GoogleSearch goooglObj = PageFactory.initElements(driver, GoogleSearch.class);
		HashMap<String, String> searchResults = new HashMap<String, String>();
		searchResults = goooglObj.definePhrase(ut.getProperty("SearchTerm") +" definition");
		System.out.println(Collections.singletonList(searchResults));
	}
	
	@Test (priority = 2)
	public void seearchImages() {
		GoogleSearch goooglObj = PageFactory.initElements(driver, GoogleSearch.class);
		List<File> searchResults = new ArrayList<File>();
		searchResults = goooglObj.searchImagesFor(ut.getProperty("SearchTerm"));
		System.out.println("=====> "+Collections.singletonList(searchResults));
	}
	
	/*@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}*/
}
