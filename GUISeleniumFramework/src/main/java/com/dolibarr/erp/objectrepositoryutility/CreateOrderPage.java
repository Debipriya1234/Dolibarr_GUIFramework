package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrderPage {
	WebDriver driver;
	public CreateOrderPage(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this); 
	}
	@FindBy(name="ref_client")
	private WebElement ref_customer;
	@FindBy(name="save")
	private WebElement save;
	public WebElement getRef_customer() {
		return ref_customer;
	}
	public WebElement getSave() {
		return save;
	}
}
