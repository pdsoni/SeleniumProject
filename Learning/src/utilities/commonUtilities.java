package utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class commonUtilities {
	
	public static WebDriver driver;	
	/**
	 * This method is for browser call 
	 * @param BrowserType
	 * @param env
	 * @return webDriver
	 */
	public static WebDriver BrowserCall (String BrowserType, String env)
	{
		if (BrowserType.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C://Selenium//Drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get(env);
			return driver;	 
		}else if(BrowserType.equalsIgnoreCase("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "C://Selenium//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			//driver.manage().window().maximize();
			driver.get(env);
			return driver;
		} else
		{
			System.setProperty("webdriver.chrome.driver", "C://Selenium//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
			//driver.manage().window().maximize();
			driver.get(env);
			return driver;
		}
	}
	
	private static Properties pro = new Properties();
	static {
	    try	{
	    		FileInputStream in = new FileInputStream("C:/Users/pradeep_kumar/workspace/Learning/src/config.properties");
	    		pro.load(in);
	    		in.close();
	    	} catch (Exception e) {e.printStackTrace();}
		}
	/**
	 * 
	 * @param key
	 * @return 
	 */
	public static String getProperty(String key) 
	{
	    return pro.getProperty(key);
	}

}
