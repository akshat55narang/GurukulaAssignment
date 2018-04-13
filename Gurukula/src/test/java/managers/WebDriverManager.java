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
			if(operatingSystem.equals("Linux"))
			System.setProperty("webdriver.chrome.driver",chromeDriverLinux);
			driver = new ChromeDriver();
		}
		else if(browser.equals("chrome")){
			if(operatingSystem.equals("Linux"))
			System.setProperty("webdriver.chrome.driver",chromeDriverWindows);
			driver = new ChromeDriver();
		}
		
		//driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public void closeBrowser(){
		driver.close();
		
	}
	public void closeAllBrowsers(){
		driver.quit();
	}
	
	public WebDriverWait getExplicitWaitForElement(WebElement element,String waitType){
		Long explicitWait = ConfigFileManager.getInstance().getConfiguration().getExplicitWait();
		//System.out.println("Explicit Wait = "+explicitWait);
		
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
	
	public void getScreenShot(){
		File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src,new File("/home/akshat/screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Screenshot location not found");
		}
	}
	
	
}
