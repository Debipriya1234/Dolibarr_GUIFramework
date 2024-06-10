package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage 
{
	WebDriver driver;
	public CustomerPage(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy (xpath= "//a[text()='Create proposal']")
	private WebElement CreateProposalLink;
	
	@FindBy ( xpath= "//a[text()='Create order']")
	private WebElement CreateOrderLink;
	
	@FindBy (xpath= "//a[text()='Create contract']")
	private WebElement CreateContractLink;
	
	@FindBy(xpath="//a[text()='Create invoice or credit note']")
	private WebElement createInvoiceLink;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateProposalLink() {
		return CreateProposalLink;
	}

	public WebElement getCreateOrderLink() {
		return CreateOrderLink;
	}

	public WebElement getCreateContractLink() {
		return CreateContractLink;
	}
	
	
	public WebElement getCreateInvoiceLink() {
		return createInvoiceLink;
	}

	public void clickCreateProposal()
	{
		Actions action= new Actions(driver);
		action.moveToElement(getCreateProposalLink()).click().perform();
	}
	
	
	

}
