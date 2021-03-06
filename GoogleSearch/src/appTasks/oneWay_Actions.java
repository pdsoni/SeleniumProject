package appTasks;

import pageWebElements.irctcAirHomePage;
import utility.CommonUtils;

public class oneWay_Actions {
	
	irctcAirHomePage objHomePage = new irctcAirHomePage();
	
	public void enterFrom()
	{
		objHomePage.homeFrom().sendKeys(CommonUtils.getProperty("oneWayFrom"));
	}
	public void enterTo()
	{
		objHomePage.homeTo().sendKeys(CommonUtils.getProperty("oneWayTo"));
	}
	
	public void oneWaySearch()
	{
		enterFrom();
		enterTo();
	}
	
	public void roundTripSearch()
	{
		enterFrom();
		enterTo();
	}

}
