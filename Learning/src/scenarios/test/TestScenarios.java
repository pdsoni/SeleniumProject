package scenarios.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.commonUtilities;
import googlebing.searchimplemetation.Google;

public class TestScenarios {
	
	public WebDriver driver;
		
	@BeforeMethod()
	public void initializeTestBaseSetup()
	{
		driver = commonUtilities.BrowserCall(commonUtilities.getProperty("browserType"), commonUtilities.getProperty("appURL"));
	}
	
	@Test (priority = 0)
	public void googleSearch() {
		Google googleObj = PageFactory.initElements(driver, Google.class);
		List<HashMap<String, String>> searchResults = new ArrayList<HashMap<String, String>>();
		searchResults = googleObj.searchFor(commonUtilities.getProperty("searchTerm"));
		System.out.println(Collections.singletonList(searchResults));
	}
	@Test (priority = 1)
	public void definePhrase() {
		Google googleObj = PageFactory.initElements(driver, Google.class);
		HashMap<String, String> searchResults = new HashMap<String, String>();
		searchResults = googleObj.definePhrase(commonUtilities.getProperty("searchTerm") +" definition");
		System.out.println(Collections.singletonList(searchResults));
	}
	
	@Test (priority = 2)
	public void seearchImages() {
		Google googleObj = PageFactory.initElements(driver, Google.class);
		List<File> searchResults = new ArrayList<File>();
		searchResults = googleObj.searchImagesFor(commonUtilities.getProperty("searchTerm"));
		System.out.println(Collections.singletonList(searchResults));
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	
	
}
