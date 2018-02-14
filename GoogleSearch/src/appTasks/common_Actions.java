package appTasks;

import utility.CommonUtils;

public class common_Actions {
	
	// This method to get browser and launch app URL on it
	public void getBrowser(String browserType, String applicationURL)
	{
		CommonUtils.BrowserCall(browserType, applicationURL);
	}

}
