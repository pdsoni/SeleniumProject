package utility;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CommonUtils {
	
	//***********************************Start - Browser Call ********************************************//
	public static WebDriver driver;	
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

	//***********************************End - Browser Call ********************************************//
	
	//***********************************Start - Properties file read ********************************************//
	
	private static Properties pro = new Properties();
	static {
	    try	{
	    		FileInputStream in = new FileInputStream("C:/Users/pradeep_kumar/workspace/GoogleSearch/src/config.properties");
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
		
	//***********************************End - Properties file read ********************************************//
	
	//***********************************Start - implicit wait ********************************************//
	
	public static void ImplicitWait(int time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	//***********************************End - implicit wait  ********************************************//
	
	//***********************************Start - explicit wait ********************************************//
	public static void EmplicitWait(int timeM)
	{
		try {
			Thread.sleep(timeM);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//***********************************End - explicit wait  ********************************************//
}
