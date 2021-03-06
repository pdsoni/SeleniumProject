package Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Example {
	
	
	@Test
	@Parameters ({"Browser"})
	public static void TestMethod(String Browser) 
	{	
		System.setProperty("webdriver.gecko.driver", "C://Selenium//Drivers//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys("Technology");
		driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[3]/center/input[1]")).click();
		driver.close();
		System.out.println(Browser +"New Functions");
	}
	@Test
	public static void TestMethod2() 
	{	
		System.setProperty("webdriver.gecko.driver", "C://Selenium//Drivers//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys("Science");
		driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[3]/center/input[1]")).click();
		System.out.println("New Functions");
	}

}
