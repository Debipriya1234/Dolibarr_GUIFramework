package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ServiceDetailPage {
	
	WebDriver driver;

	public ServiceDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyServiceDetails(WebElement element) {
		return element.isDisplayed();
	}
	
	public void naviagateToHomePage() {
		driver.get("http://49.249.28.218:8889/dolibarr/");
	}

}
