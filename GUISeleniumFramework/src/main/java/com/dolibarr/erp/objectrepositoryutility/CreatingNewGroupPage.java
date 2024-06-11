package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewGroupPage {
	WebDriver driver;
	public CreatingNewGroupPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="nom")
	private WebElement Name;
	@FindBy(id="note")
	private WebElement Description1;
	@FindBy(xpath="//input[@type='submit'][1]")
	private WebElement CreateGroupbtn;
	
	public WebElement getName() {
		return Name;
	}
	
	public WebElement getDescription1() {
		return Description1;
	}

	
	public WebElement getCreateGroupbtn() {
		return CreateGroupbtn;
	}
	
	public void createGroup(String Groupname,String Description) {
		getName().sendKeys(Groupname);
		getDescription1().sendKeys(Description);
		getCreateGroupbtn().click();
		
	}
	
	
	
	
	
	
}
