package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewContractForProspectPage {

	public NewContractForProspectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="ref_customer")
	private WebElement refCustomer;
	@FindBy(name="add")
	private WebElement create;
	public WebElement getRefCustomer() {
		return refCustomer;
	}
	public WebElement getCreate() {
		return create;
	}
	
}
