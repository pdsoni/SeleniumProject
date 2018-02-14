package pageWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.CommonUtils;

public class irctcAirHomePage extends CommonUtils {
	
	public WebElement homeFrom()
	{
		 return driver.findElement(By.xpath("//*[@id='from']")); 
	}
	
	public WebElement homeTo()
	{
		 return driver.findElement(By.xpath("//*[@id='to']")); 
	}

	public WebElement homeDepartureDate()
	{
		 return driver.findElement(By.xpath("//*[@id='departureDate']")); 
	}

	public WebElement homeReturnDate()
	{
		 return driver.findElement(By.xpath("//*[@id='returnDate']")); 
	}
	
	public WebElement homeTravellerDetails()
	{
		 return driver.findElement(By.xpath("//*[@id='noOfpaxEtc']")); 
	}
	
	public WebElement homeSearchButton()
	{
		 return driver.findElement(By.xpath("//*[@id='index']/div[1]/div[2]/div/div/div[1]/div/div/form/div[3]/button")); 
	}

}
