package utilities;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class utils {
	
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
			// To remove OS dependency
			Path path = FileSystems.getDefault().getPath("src/main/resources/IEDriverServer"); 
			System.setProperty("webdriver.ie.driver", path.toString());
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get(env);
			return driver;	 
		}else if(BrowserType.equalsIgnoreCase("FF"))
		{
			// To remove OS dependency
			Path path = FileSystems.getDefault().getPath("src/main/resources/geckodriver.exe"); 
			System.setProperty("webdriver.gecko.driver", path.toString());
			driver = new FirefoxDriver();
			//driver.manage().window().maximize();
			driver.get(env);
			return driver;
		} else
		{
			// To remove OS dependency
			Path path = FileSystems.getDefault().getPath("src/main/resources/chromedriver"); 
			System.setProperty("webdriver.chrome.driver", path.toString());
			driver = new ChromeDriver();
			driver.get(env);
			return driver;
		}
	}

}
