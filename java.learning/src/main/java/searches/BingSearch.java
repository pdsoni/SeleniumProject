package searches;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import implementation.search.Search;

public class BingSearch implements Search{
	
	public WebDriver driver;
	
	@FindBy(css="input[name='q']")
	WebElement bingSearchBox;
	
	@FindBy(css="input[name='go']")
	WebElement bingSearchIcon;
	
	@FindBy(css="h2:first-child a[href^='http']")
	List<WebElement> results;
	
	@FindBy(css="div.dc_mn")
	WebElement phraseDef;
	
	@FindBy(css="span.lr_dct_ph>span")
	WebElement phrasePronunciation;
	
	@FindBy(css="#hdtb-msb-vis > div:nth-child(3) > a")
	WebElement imageLink;
	
	@FindBy(css="a[jsname='hSRGPd']")
	List<WebElement> imageResults;
	
	@FindBy(css=".rg_ic.rg_i")
	List<WebElement> imageLocation;
	

	public List<HashMap<String, String>> searchFor(String keyword) {
		List<HashMap<String, String>> searchResults = new ArrayList<HashMap<String, String>>();
		bingSearchBox.sendKeys(keyword);
		bingSearchIcon.click();
		for (WebElement result: results){
			HashMap<String, String> attributes = new HashMap<String, String>();
			attributes.put("linkTitle",result.getText());
			attributes.put("pageLink",result.getAttribute("href"));
			searchResults.add(attributes);
		}
		return searchResults;
	}

	public HashMap<String, String> definePhrase(String phrase) {
		HashMap<String, String> searchPhrase = new HashMap<String, String>();
		bingSearchBox.sendKeys(phrase);
		bingSearchIcon.click();
		searchPhrase.put("phraseDefinition", phraseDef.getText());
		searchPhrase.put("phrasePronunciation", phrasePronunciation.getAttribute(""));
		return searchPhrase;
	}

	public List<File> searchImagesFor(String SearchTerm) {
		bingSearchBox.sendKeys(SearchTerm);
		bingSearchIcon.click();
		//try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		imageLink.click();
		int i = 1;
		for (WebElement img: imageResults)
		{
			System.out.println("Image link =" + img.getAttribute("href"));
			if (i == 10) 
			break;
			i++; 
		}
		File directory = new File("C:/Users/pradeep_kumar/workspace/Learning/bin");
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            System.out.println(file.getName());
        }
		return null;
	}

}
