package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContractForCustomerPage
{
	WebDriver driver;
	public ContractForCustomerPage(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this); 
	}
	@FindBy(xpath="//span[@title='Draft']")
	private WebElement DraftStatus;
	
	@FindBy(id="prod_entry_mode_free")
	private WebElement RadioSelect;
	
	@FindBy(id="dp_desc")
	private WebElement Disctext;
	
	@FindBy(id="price_ht")
	private WebElement NetPrice;
	
	@FindBy(id="addline")
	private WebElement AddButton;
	
	@FindBy(xpath="//a[text()='Validate']")
	private WebElement ValidateLink;
	
	@FindBy(xpath="//button[text()='Yes']")
	private WebElement YesButton;
	
	@FindBy(xpath="(//span[@title='Not running'])[2]")
	private WebElement StatusofService;
	
	@FindBy(xpath="//a[text()='Activate all contract lines']")
	private WebElement ActivateContractLink;
	
	@FindBy(xpath="//span[@title='Running']")
	private WebElement ActivateStatus;

	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getDraftStatus() {
		return DraftStatus;
	}

	public WebElement getRadioSelect() {
		return RadioSelect;
	}

	public WebElement getDisctext() {
		return Disctext;
	}

	public WebElement getNetPrice() {
		return NetPrice;
	}

	public WebElement getAddButton() {
		return AddButton;
	}
	
	public WebElement getYesButton() {
		return YesButton;
	}

	public WebElement getValidateLink() {
		return ValidateLink;
	}
	
	public WebElement getStatusofService() {
		return StatusofService;
	}
	
	public WebElement getActivateContractLink() {
		return ActivateContractLink;
	}

	public WebElement getActivateStatus() {
		return ActivateStatus;
	}
	
	

	public void addline(String Dis, String NetPrice)
	{
		getRadioSelect().click();
		getDisctext().sendKeys(Dis);
		getNetPrice().sendKeys(NetPrice);
		getAddButton().click();
	}
	
	
	
	
	
	
	

}
