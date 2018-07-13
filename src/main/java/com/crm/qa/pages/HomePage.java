package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage  extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: Venkat Pannala')]")
	WebElement userlabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement  NewContactlink;
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement TasksLink;
	
	//Intialize the Page Objects 
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
    public String verifyPageTitle() {
    	 return driver.getTitle();
    }
    
    public boolean verifyCorrectUserName() {
    	return userlabel.isDisplayed();
    	
    }
    public ContactsPage  clickonContactsLink() {
    	
    	ContactsLink.click();
    	return new  ContactsPage();
    }
    public DealsPage clickOnDealsLink() {
    	DealsLink.click();
    	return new DealsPage();
    }
    
    public TasksPage clickOnTasksLink() {
    	TasksLink.click();
    	return new TasksPage();
    }
    public void clickOnNewContact() {
    	Actions actions= new Actions(driver);
    	actions.moveToElement(ContactsLink).build().perform();
    	NewContactlink.click();
    }
}   
