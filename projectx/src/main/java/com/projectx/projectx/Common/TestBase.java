package com.projectx.projectx.Common;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	String urlname ="http://automationpractice.com/index.php";
	String Browser = "firefox";
	public static WebDriver driver;
	
	public void selectBrowser(String Browser) {
		if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (Browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "//Drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}		
	}
	public void getUrl(String urlname) {		
		driver.get(urlname);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		
	}
	
	public void startupValidation() {
		PropertyConfigurator.configure("Log4j.properties");
		selectBrowser(Browser);
		getUrl(urlname);		
	}
}

