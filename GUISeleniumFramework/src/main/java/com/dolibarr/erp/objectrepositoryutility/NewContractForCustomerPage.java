package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewContractForCustomerPage 
{
	WebDriver driver;
	public NewContractForCustomerPage(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this); 
	}
	@FindBy (id="ref_customer")
	private WebElement refCust;
	
	@FindBy (name="add")
	private WebElement createButton;
	
	public WebElement getRefCust() {
		return refCust;
	}

	public WebElement getCreateButton() {
		return createButton;
	}
	
	

}
