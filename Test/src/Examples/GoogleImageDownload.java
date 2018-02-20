package Examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.JsonObject;

public class GoogleImageDownload {

	public static void main(String[] args) {
		try{
			
			 URL url = new URL("https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=sen+triplets");
			 URLConnection connection = url.openConnection();
			 String line;
			 StringBuilder builder = new StringBuilder();
			 BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			 while((line = reader.readLine()) != null) {
	                builder.append(line);
	            }
			 JsonObject json = new JsonObject();
			
		}catch(Exception e){
			
		}
	}

}
