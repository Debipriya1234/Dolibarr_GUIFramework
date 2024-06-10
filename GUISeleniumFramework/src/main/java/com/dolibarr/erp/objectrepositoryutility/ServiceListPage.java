package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServiceListPage {

	WebDriver driver;

	public ServiceListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "search_ref")
	private WebElement searchTextField;

	public WebElement getSearchTextField() {
		return searchTextField;
	}
	
	public void searchProduct(String name) {
		getSearchTextField().sendKeys(name);
		getSearchTextField().sendKeys(Keys.ENTER);
	}
}
