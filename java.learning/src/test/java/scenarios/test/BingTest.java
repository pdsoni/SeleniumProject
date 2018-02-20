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
import searches.BingSearch;
import utilities.utils;

public class BingTest {
	public WebDriver driver;
	utils ut = new utils();
		
	@BeforeMethod()
	public void initializeTestBaseSetup()
	{
		driver = ut.setDriver(ut.getProperty("BrowserType"), ut.getProperty("appBingURL"));
	}
	
	@Test(priority = 0)
	public void BingSearch() {
		BingSearch BingObj = PageFactory.initElements(driver, BingSearch.class);
		List<HashMap<String, String>> searchResults = new ArrayList<HashMap<String, String>>();
		System.out.println(ut.getProperty("SearchTerm"));
		searchResults = BingObj.searchFor(ut.getProperty("SearchTerm"));
		System.out.println(Collections.singletonList(searchResults));
	}
	
	@Test (priority = 1)
	public void definePhrase() {
		BingSearch BingObj = PageFactory.initElements(driver, BingSearch.class);
		HashMap<String, String> searchResults = new HashMap<String, String>();
		searchResults = BingObj.definePhrase(ut.getProperty("SearchTerm"));
		System.out.println(Collections.singletonList(searchResults));
	}
	
	@Test (priority = 2)
	public void seearchImages() {
		BingSearch BingObj = PageFactory.initElements(driver, BingSearch.class);
		List<File> searchResults = new ArrayList<File>();
		searchResults = BingObj.searchImagesFor(ut.getProperty("SearchTerm"));
		System.out.println(Collections.singletonList(searchResults));
	}

}
