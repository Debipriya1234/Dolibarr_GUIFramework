package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThirdPartiesPage {
	
	WebDriver driver;

	public ThirdPartiesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[text()='New Customer']")
	private WebElement NewCustomerLink;

	@FindBy(xpath = "//a[text()='New Prospect']")
	private WebElement NewProspectLink;

	@FindBy(xpath = "//a[text()='List of Customers']")
	private WebElement ListOfCustomersLink;

	@FindBy(xpath = "//a[text()='List of Prospects']")
	private WebElement ListOfProspectsLink;

	public WebElement getNewCustomerLink() {
		return NewCustomerLink;
	}

	public WebElement getNewProspectLink() {
		return NewProspectLink;
	}

	public WebElement getListOfCustomersLink() {
		return ListOfCustomersLink;
	}

	public WebElement getListOfProspectsLink() {
		return ListOfProspectsLink;
	}

	public void clickOnListOfProspectsLink() {
		getListOfProspectsLink().click();
	}

}
