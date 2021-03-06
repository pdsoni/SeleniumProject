package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utiliy.commonUtils;

public class googleAdvancedSearchPage extends commonUtils {
	
	public void googleSettingLink()
	{
		driver.findElement(By.xpath("//*[@id='abar_button_opt']")).click();
	}
	public void googleAdvancedSearchLink()
	{
		driver.findElement(By.xpath("//*[@id='lb']/div/a[4]")).click();
	}
	public void googleAdvancedSearchButton()
	{
		driver.findElement(By.xpath("/html/body/div[1]/div[4]/form/div[5]/div[9]/div[2]/input")).click();
	}

	
	/**
	 * This method is for Advance search
	 * @return List of WebElements
	 */
	
	public List<WebElement> googleAdvancedSearch()
	{
		List<WebElement> results;
		this.googleSettingLink();
		this.googleAdvancedSearchLink();
		this.googleAdvancedSearchButton();
		results = driver.findElements(By.xpath("//*[@id='rso']//h3[@class='r']"));
		System.out.println(results);
		return results;
	}

}
