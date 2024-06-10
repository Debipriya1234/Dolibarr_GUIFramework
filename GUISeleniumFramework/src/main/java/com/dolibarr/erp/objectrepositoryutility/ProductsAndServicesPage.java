package com.dolibarr.erp.objectrepositoryutility;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsAndServicesPage {

	WebDriver driver;

	public ProductsAndServicesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='New warehouse']")
	private WebElement newWarehouseLink;
	
	@FindBy(xpath = "//a[@title='New product']")
	private WebElement newProductLink;
	
	@FindBy(css = "a[title='List']")
	private List<WebElement> productListLink;
	
	@FindBy(xpath = "//a[@title='New service']")
	private WebElement newServiceLink;

	public WebElement getNewServiceLink() {
		return newServiceLink;
	}

	public WebElement getProductListLink() {
		return productListLink.get(0);
	}

	public WebElement getNewProductLink() {
		return newProductLink;
	}

	public WebElement getNewWarehouseLink() {
		return newWarehouseLink;
	}
	
	public WebElement getServiceListLink() {
		return productListLink.get(1);
	}

	public void clickOnNewWarehouseLink() {
		getNewWarehouseLink().click();
	}
	
	public void clickOnNewProductLink() {
		getNewProductLink().click();
	}

	public void clickOnProductListLink() {
		getProductListLink().click();
	}
	
	public void clickOnNewServiceLink() {
		getNewServiceLink().click();
	}
	
	public void clickOnServiceListLink() {
		getServiceListLink().click();
	}
}
