package pageObjects;

import org.openqa.selenium.By;

import utiliy.commonUtils;

public class googleHomePage extends commonUtils {
	
	public void googleSearchBox(String searchTerm)
	{
		driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys(searchTerm);
	}
	
	public void googleSearchButton()
	{
		driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[3]/center/input[1]")).click();
	}
	
	/**
	 * This method is for Basic search
	 */
	public void basicSearchResult(String searchTerm)
	{
		this.googleSearchBox(searchTerm);
		this.googleSearchButton();
	}
	

}
