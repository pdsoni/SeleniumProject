package searches;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import implementation.search.Search;

public class GoogleSearch implements Search{
	
public WebDriver driver;
	
	@FindBy(css="input[name='q']")
	WebElement googleSearchBox;
	
	@FindBy(css="input[name='btnK']")
	WebElement googleSearchButton;
	
	@FindBy(css="h3:first-child a[href^='http']")
	List<WebElement> results;
	
	@FindBy(css="div[data-dobid='dfn']>span")
	WebElement phraseDef;
	
	@FindBy(css="span.lr_dct_ph>span")
	WebElement phrasePronunciation;
	
	@FindBy(css="#hdtb-msb-vis > div:nth-child(3) > a")
	WebElement imageLink;
	
	@FindBy(css="img[data-src*='http']")
	List<WebElement> imageResults;
	
	@FindBy(css=".rg_ic.rg_i")
	List<WebElement> imageLocation;

	public List<HashMap<String, String>> searchFor(String keyword) {
		List<HashMap<String, String>> searchResults = new ArrayList<HashMap<String, String>>();
		googleSearchBox.sendKeys(keyword);
		googleSearchButton.click();	
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
		googleSearchBox.sendKeys(phrase);
		googleSearchButton.click();
		searchPhrase.put("phraseDefinition", phraseDef.getText());
		searchPhrase.put("phrasePronunciation", phrasePronunciation.getAttribute(""));
		return searchPhrase;
	}

	public List<File> searchImagesFor(String SearchTerm) {
		List<File> fileList = new ArrayList<File>();
		googleSearchBox.sendKeys(SearchTerm);
		googleSearchButton.click();
		//try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		imageLink.click();
		
		File folder = new File("C:/Program Files/Notepad++/plugins/APIs");
		File[] listofFIles = folder.listFiles();
		
		for (File file : listofFIles) {
		    if (file.isFile()) {
		        System.out.println(file.getName());
		        fileList.add(file);
		    }
		}
		
		int i = 1;
		for (WebElement img: imageResults)
		{
			System.out.println("Image link =" + img.getAttribute("src"));
			try {
				saveImage(img.getAttribute("src"));
			} catch (IOException e) {e.printStackTrace();}
			if (i == 2) 
			break;
			i++; 
		}
		return fileList;
	}
	
	public void saveImage(String imageURL) throws IOException
	{
		URL url = new URL(imageURL);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream("C:/Users/pradeep_kumar/Downloads/");
		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();
	}
	

}
