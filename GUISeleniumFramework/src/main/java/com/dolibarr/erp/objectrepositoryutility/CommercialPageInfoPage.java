package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommercialPageInfoPage {
	public CommercialPageInfoPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this); 
	}
@FindBy(xpath="//span[contains(@title,'Draft')]")
private WebElement status;

@FindBy(id="prod_entry_mode_free")
private WebElement freeTextItem;
@FindBy(id="select2-select_type-container")
private WebElement type;

@FindBy(xpath="//li[text()='Product']")
private WebElement selectType;

@FindBy(id="dp_desc")
private WebElement description; 

@FindBy(id="price_ht")
private WebElement netPrice;

@FindBy(id="qty")
private WebElement qty;

@FindBy(id="remise_percent")
private WebElement discount;

@FindBy(id="addline")
private WebElement add;

@FindBy(xpath="//a[text()='Validate']")
private WebElement validate;

@FindBy(xpath="//button[text()='Yes']")
private WebElement yesButton;

@FindBy(xpath="//span[text()='Not running']")
private WebElement validateafter;
@FindBy(xpath="//a[text()='Activate all contract lines']")
private WebElement activateContract;
@FindBy(xpath="//button[text()='Yes']")
private WebElement clickOnYes;
@FindBy(xpath="//span[text()='Running']")
private WebElement validateactiveContract;
public WebElement getStatus() {
	return status;
}
public WebElement getFreeTextItem() {
	return freeTextItem;
}
public WebElement getType() {
	return type;
}
public WebElement getSelectType() {
	return selectType;
}
public WebElement getDescription() {
	return description;
}
public WebElement getNetPrice() {
	return netPrice;
}
public WebElement getQty() {
	return qty;
}
public WebElement getDiscount() {
	return discount;
}
public WebElement getAdd() {
	return add;
}

public WebElement getYesButton() {
	return yesButton;
}
public WebElement getValidate() {
	return validate;
}

public WebElement getValidateafter() {
	return validateafter;
}

public WebElement getActivateContract() {
	return activateContract;
}
public WebElement getClickOnYes() {
	return clickOnYes;
}
public WebElement getValidateactiveContract() {
	return validateactiveContract;
}
public void setValidateafter(WebElement validateafter) {
	this.validateafter = validateafter;
}
public void addLine(String discription,String Nprice,String qty,String dis) {
	getFreeTextItem().click();
	getType().click();
	getSelectType().click();
	getDescription().sendKeys(discription);
	getNetPrice().sendKeys(Nprice);
	 getQty().sendKeys(qty);
	 getDiscount().sendKeys(dis);
	 getAdd().click();
}
public void addLineContract(String discription,String Nprice,String qty,String dis) {
	getFreeTextItem().click();
	getDescription().sendKeys(discription);
	getNetPrice().sendKeys(Nprice);
	 getQty().sendKeys(qty);
	 getDiscount().sendKeys(dis);
	 getAdd().click();
}
}
