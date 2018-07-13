package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	//Create Constructor
	
	   public HomePageTest() {
		super();
	}


	   @BeforeMethod
		public void setup() {
			intialization();
			testutil=new TestUtil();
			contactspage=new ContactsPage();
			loginpage= new LoginPage();
			homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		}
	 @Test(priority=1)
	 public void verifyHomePageTitleTest() {
		 String HomePageTitle = homepage.verifyPageTitle();
		 Assert.assertEquals(HomePageTitle, "CRMPRO","Home page title is not matched");
		 
	 }
	 
	 @Test(priority=2)
	 public void verifyuserNameTest() {
		 testutil.swithToFrame();
		 Assert.assertTrue(homepage.verifyCorrectUserName());
		 
		 
	 }
	 
	 @Test(priority=3)
	 public void verifyContactsLinkTest() {
		 testutil.swithToFrame();
		 contactspage=homepage.clickonContactsLink();
		 
	 }
	 
	 
	 @AfterMethod
	 public void tearDown() {
		 driver.quit();
	 }
}
