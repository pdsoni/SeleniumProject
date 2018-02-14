package testScenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.googleAdvancedSearchPage;
import pageObjects.googleHomePage;
import utiliy.commonUtils;

public class googleSearch {
	
	commonUtils b = new commonUtils();
	googleHomePage gHomePage = new googleHomePage();
	googleAdvancedSearchPage gAdvPage = new googleAdvancedSearchPage();
	
	@BeforeClass
	public void initializeTestBaseSetup()
	{
		b.setDriver(b.getProperty("BrowserType"), b.getProperty("appURL")); //Initialize browser
	}
     
	
	@Test (priority = 0, dataProvider = "SearchTerm")
	public void googleBasicSearch(String searchTerm)
	{
		gHomePage.basicSearchResult(searchTerm);
	}
	
	@Test (priority = 1)
	public void googleAdvancedBasicSearch()
	{
		gAdvPage.googleAdvancedSearch();
	}
	
	@DataProvider (name = "SearchTerm")
	public Object[] ValidSearchTerm(){
		return new Object[]{"Technology"};
	}
	
	@AfterClass
	public void closeBroswer()
	{
		commonUtils.driver.close();
	}
	
}
