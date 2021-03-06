package utiliy;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class commonUtils {

	private Properties pro = new Properties();
	private InputStream inputStream;
	{
		try	{
			inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
			if (inputStream != null) {
				pro.load(inputStream);
				inputStream.close();
			} else {
				throw new FileNotFoundException("property file did not find in the classpath");
			}
		} catch (Exception e) 
		{
			System.out.println("Exception: " + e);
		}
	}
	
	/**
	 * This method will be getting value from properties file
	 * @param key
	 * @return String
	 */
	public String getProperty(String key) 
	{
		return pro.getProperty(key);
	}
	
	public static WebDriver driver;
	/**
	 * This method is for browser call 
	 * @param BrowserType
	 * @param env
	 * @return webDriver
	 */
	public WebDriver setDriver(String BrowserType, String env)
	{
		if (BrowserType.equalsIgnoreCase("IE"))
		{
			//System.setProperty("webdriver.ie.driver", "C://Selenium//Drivers//IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", Thread.currentThread().getContextClassLoader().getResource("IEDriverServer.exe").getFile());
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get(env);
			return driver;	 
		}else if(BrowserType.equalsIgnoreCase("FF"))
		{
			//System.setProperty("webdriver.gecko.driver", "C://Selenium//Drivers//geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", Thread.currentThread().getContextClassLoader().getResource("geckodriver.exe").getFile());
			driver = new FirefoxDriver();
			//driver.manage().window().maximize();
			driver.get(env);
			return driver;
		} else
		{
			//System.setProperty("webdriver.chrome.driver", "C://Selenium//Drivers//chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", Thread.currentThread().getContextClassLoader().getResource("chromedriver.exe").getFile());
			driver = new ChromeDriver();
			//driver.manage().window().maximize();
			driver.get(env);
			return driver;
		}
	}
}
