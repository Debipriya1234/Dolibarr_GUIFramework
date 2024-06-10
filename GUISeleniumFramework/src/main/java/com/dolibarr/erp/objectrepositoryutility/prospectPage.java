package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class prospectPage {
	
	WebDriver driver;
	public prospectPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//a[text()='Create proposal']")
	private WebElement createProposal;
	@FindBy(xpath="//a[text()='Create contract']")
	private WebElement createcontract;
	@FindBy(xpath="//a[text()='Create order']")
	private WebElement createorder;
	
	public WebElement getCreateProposal() {
		return createProposal;
	}
	public WebElement getCreateContract() {
		return createcontract;
	}
	public WebElement getCreateorder() {
		return createorder;
	}
	
}
