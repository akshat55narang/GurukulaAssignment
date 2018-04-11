package dataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties prop;
	private FileInputStream fis;
	private static final String PROP_LOCATION = "/src/test/resources/data.properties";
	
	public ConfigFileReader(){
		String userDirectory = System.getProperty("user.dir");
		String path = userDirectory+PROP_LOCATION;
		prop = new Properties();
		try {
			fis = new FileInputStream(path);
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			throw new RuntimeException("Property file not found");
		}
	}
	
	public static void main(String []args){
		ConfigFileReader c = new ConfigFileReader();
		
	}
	
	public String getApplicationURL(){
		String url = prop.getProperty("url");
		if(url != null){ return url;}
		else { throw new RuntimeException("URL value is set to NULL.");}
		}
	
	public String getApplicationBrowser(){
		String browser = prop.getProperty("browser");
		if(browser != null){ return browser;}
		else { throw new RuntimeException("Browser value is set to NULL.");}
		}
	
	public String getChromeDriverPath(){
		String chrome_driverpath = prop.getProperty("chrome_driverpath");
		if(chrome_driverpath != null){ return chrome_driverpath;}
		else { throw new RuntimeException("Chrome Driver Path value is set to NULL.");}
		}
	
	public String getIEDriverPath(){
		String ie_driverpath = prop.getProperty("ie_driverpath");
		if(ie_driverpath != null){ return ie_driverpath;}
		else { throw new RuntimeException("IE Driver Path value is set to NULL.");}
		}
	
	public String getFirefixDriverPath(){
		String firefox_driverpath = prop.getProperty("firefox_driverpath");
		if(firefox_driverpath != null){ return firefox_driverpath;}
		else { throw new RuntimeException("Firefox Gecko Driver value is set to NULL.");}
		}
	
	public String getimplicitWait(){
		String implicitWait = prop.getProperty("implicitWait");
		if(implicitWait != null){ return implicitWait;}
		else { throw new RuntimeException("URL value is set to NULL.");}
		}
	
	public Long getExplicitWait(){
		String wait= prop.getProperty("explicitWait");
		if(wait!=null){ return Long.parseLong(wait);}
		else { throw new RuntimeException("Explicit Wait is not set");
		
		}
	}
}
