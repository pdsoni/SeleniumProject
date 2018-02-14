package testScenarios;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utility.CommonUtils;
import appTasks.common_Actions;
import appTasks.oneWay_Actions;

@Listeners(utility.listenerUtils.class)

public class irctcTestScenarios {
	common_Actions commTasks = new common_Actions();
	oneWay_Actions oneWayTasks = new oneWay_Actions();
	
	@Test (description = "This test for One Way Trip")
	@Parameters({"Browser"})
	public void TC01(String Browser)
	{
		commTasks.getBrowser(Browser, CommonUtils.getProperty("appURL"));
		CommonUtils.EmplicitWait(1000);
		oneWayTasks.oneWaySearch();
		CommonUtils.driver.close();
	}
	
	@Test (description = "This test for Round Trip")
	public void TC02()
	{
		commTasks.getBrowser(CommonUtils.getProperty("testBrowser"), CommonUtils.getProperty("appURL"));
		CommonUtils.EmplicitWait(1000);
		oneWayTasks.roundTripSearch();
		CommonUtils.driver.close();
	}
}
