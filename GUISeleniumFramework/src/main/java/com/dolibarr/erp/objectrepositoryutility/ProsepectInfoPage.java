package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProsepectInfoPage {
	
	WebDriver driver;
	public ProsepectInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(linkText="Prospect")
	private WebElement prospectInfo;

	public WebElement getProspectInfo() {
		return prospectInfo;
	}
	
	public void goToProspectTab() {
		getProspectInfo().click();
	}
	
}
