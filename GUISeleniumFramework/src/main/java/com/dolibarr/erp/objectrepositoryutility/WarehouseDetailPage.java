package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author CHIDUSD
 */
public class WarehouseDetailPage {
	
	WebDriver driver;

	public WarehouseDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[contains(@class,'inline-block floatleft valignmiddle')]")
	private WebElement warehouseHeader;

	public WebElement getWarehouseHeader() {
		return warehouseHeader;
	}

	public String getWarehouseHeaderText() {
		return getWarehouseHeader().getText();
	}
	
	public void naviagateToHomePage() {
		driver.get("http://49.249.28.218:8889/dolibarr/");
	}

}
