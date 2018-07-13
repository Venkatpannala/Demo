package com.crm.qa.base;


import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public TestBase() {
		try {
			prop=new Properties();
			FileInputStream ip= new FileInputStream("\\Users\\ntc-3\\CRM\\src\\main\\java\\com\\crm"+
			"\\qa\\config\\config.properties");
			prop.load(ip);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void intialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium Softwares\\Drivers\\chromedriver.exe");
		    driver=new ChromeDriver();
		}
		else if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"Browsers/geckodriver.exe");
		    driver=new FirefoxDriver();
	   }
		 e_driver= new EventFiringWebDriver(driver);
		 //Create oject for EventListenerHandler to register with EvenFiringwebDriver
		 eventListener=new WebEventListener();
		 e_driver.register(eventListener);
		 driver=e_driver;
		 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
   }
}

