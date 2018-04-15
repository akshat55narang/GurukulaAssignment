package managers;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import objectRepository.HomePage;
import objectRepository.LoginPage;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.Log;
import dataProvider.ConfigFileReader;

public class WebDriverManager {

	public WebDriver driver;
	public ConfigFileManager fileReadManager;
	public ConfigFileReader config;
	public HomePage home;
	public PageObjectManager page;
	public WebDriverWait wait;
	
	public WebDriverManager(){
		
	}
	
	public WebDriver getDriver(){
		return (driver==null)? driver = openBrowser():driver;
	}
	
	
	public WebDriver openBrowser(){
		String path = System.getProperty("user.dir");
		String url = ConfigFileManager.getInstance().getConfiguration().getApplicationURL();
		String browser = ConfigFileManager.getInstance().getConfiguration().getApplicationBrowser();
		String chromeDriverWindows = path+ConfigFileManager.getInstance().getConfiguration().getChromeDriverPathWindows();
		String chromeDriverLinux = path+ConfigFileManager.getInstance().getConfiguration().getChromeDriverPathLinux();
		Long implicitWait = Long.parseLong(ConfigFileManager.getInstance().getConfiguration().getimplicitWait());
		String operatingSystem=ConfigFileManager.getInstance().getConfiguration().getOS();
		
		if(browser.equals("chrome")){
			if(operatingSystem.equals("Linux")){
				System.setProperty("webdriver.chrome.driver", chromeDriverLinux);
				Log.info("Opening Browser");
			driver = new ChromeDriver();
			}
		
			if(operatingSystem.equals("Windows")){
				System.setProperty("webdriver.chrome.driver", chromeDriverWindows);
				Log.info("Opening Browser");
			driver = new ChromeDriver();
	}
		}
		
		driver.get(url);
		Log.info("Setting Implicit Wait="+implicitWait);
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		
		return driver;
	}
	// Method to Close Browser
	public void closeBrowser(){
		Log.info("Closing Browser");
		driver.close();
		
	}
	
	// Method to close all browsers
	public void closeAllBrowsers(){
		Log.info("Closing All Browsers");
		driver.quit();
	}
	
	// Generic Method to generate Explicit Wait , based on the type of wait provided as Argument
	public WebDriverWait getExplicitWaitForElement(WebElement element,String waitType){
		Long explicitWait = ConfigFileManager.getInstance().getConfiguration().getExplicitWait();
		Log.info("Setting Explicit Wait Type = "+waitType);
		wait = new WebDriverWait(getDriver(), explicitWait);
		if(waitType.equals("visibility")){
		wait.until(ExpectedConditions.visibilityOf(element));
		return wait;}
		else if(waitType.equals("invisibility")){
			wait.until(ExpectedConditions.invisibilityOf(element));
			return wait;}
		
		else if(waitType.equals("clickable")){
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return wait;
		}
		
		else { throw new RuntimeException("Wait "+waitType+" Type is not Supported");}
	
		
	}
	// Method to take screen shot of Web Page.
	public void getScreenShot(String testcase){
		Log.info("Taking Screen Shot for testcase="+testcase);
		File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		
		String path = System.getProperty("user.dir");
		try {
			
			FileUtils.copyFile(src,new File(path+"/screenshots/screenshot"+testcase+".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
			throw new RuntimeException("Screenshot location not found");
		}
	}
	
	
}
