package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewBillPage {
	WebDriver driver;
	public CreatingNewBillPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[@class='fa fa-plus-circle valignmiddle']")
	private WebElement plusbtn;
	@FindBy(id="ref")
	private WebElement Productref;
	@FindBy(name="label")
	private WebElement Label;
	@FindBy(id="desc")
	private WebElement Description;
	@FindBy(xpath="//input[@type='submit']")
	private WebElement createbtn;
	@FindBy(xpath="//input[@type='text']")
	private WebElement Label1;
	@FindBy(id="qty")
	private WebElement quantity;
	@FindBy(xpath="//input[@value='Create']")
	private WebElement createbtn1;
	
	public WebElement getPlusbtn() {
		return plusbtn;
	}

	public WebElement getProductref() {
		return Productref;
	}

	public WebElement getLabel() {
		return Label;
	}

	public WebElement getDescription() {
		return Description;
	}

	public WebElement getCreatebtn() {
		return createbtn;
	}

	public WebElement getLabel1() {
		return Label1;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getCreatebtn1() {
		return createbtn1;
	}
	
	public void clickOnplusbtn() {
		getPlusbtn().click();
	}
	
	public void createNewProduct(String Productref,String Label) {
		getProductref().sendKeys(Productref);
		getLabel().sendKeys(Label);
	}
		public void createNewProduct1(String Description) {
		getDescription().sendKeys(Description);
		getCreatebtn().click();
	}
	
	public void createNewBillOfMaterials(String Label1,String Quantity) {
		getLabel1().sendKeys(Label1);
		getQuantity().sendKeys(Quantity);
		getCreatebtn1().click();
	}
	
	
	
}
