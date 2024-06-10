package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCommercialProposalForCustomerPage 
{
	WebDriver driver;
	public NewCommercialProposalForCustomerPage(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(name="ref_client")
	private WebElement RefCustomer;
	
	@FindBy(id="re")
	private WebElement proposalDate;
	
	@FindBy(name="save")
	private WebElement createDraftButton;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getRefCustomer() {
		return RefCustomer;
	}

	public WebElement getProposalDate() {
		return proposalDate;
	}

	public WebElement getCreateDraftButton() {
		return createDraftButton;
	}
	
	public void createProposal(String rfcs, String date)
	{
		getRefCustomer().sendKeys(rfcs);
	
		getCreateDraftButton().click();
	}
	
	


}
