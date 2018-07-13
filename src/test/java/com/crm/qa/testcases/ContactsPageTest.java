package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	String sheetname="Contacts";
	
	//Create Constructor
	
	   public ContactsPageTest() {
		super();
	}
	   @BeforeMethod
		public void setup() {
			intialization();
			testutil=new TestUtil();
			contactspage=new ContactsPage();
			loginpage= new LoginPage();
			homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			testutil.swithToFrame();
			contactspage=homepage.clickonContactsLink();
		}
	   @Test(priority=1)
	   public void verifyContactsPageLabel() {
		   
		   Assert.assertTrue(contactspage.verifyContactsLabel(),"Contacts label is missing on the page");
	   }
	   @Test(priority=2)
	   public void selectContactsTest() {
		   contactspage.selectContactsByName("Kavitha Pannala");
		   
	   } 
	   @Test(priority=3)
	   public void selectMultileContacts() {
		   contactspage.selectContactsByName("Kavitha Pannala");
		   contactspage.selectContactsByName("Sahithi P");
		 
	   }
	    @DataProvider
	    public Object[][] getCRMTestData() {
	    	 Object data[][]=testutil.getTestData(sheetname);
	    	 return data;
	    	
	    }
	   
	   
	   @Test(priority=4,dataProvider="getCRMTestData")
	   public void validateCreateNewContactTest(String title, String firstname, String lastname, String company, String email) {
		   homepage.clickOnNewContact();
		   //contactspage.createNewCntact("Mr.", "Tom", "Peter", "Google", "tom@gmail.com");
		   contactspage.createNewContact(title, firstname, lastname, company, email);
		   
	   }
	
	   @AfterMethod
		 public void tearDown() {
			 driver.quit();
		 }
}
