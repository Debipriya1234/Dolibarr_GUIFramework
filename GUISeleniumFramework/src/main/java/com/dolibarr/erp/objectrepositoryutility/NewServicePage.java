package com.dolibarr.erp.objectrepositoryutility;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewServicePage {
	
	WebDriver driver;

	public NewServicePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "ref")
	private WebElement productRefTextField;
	
	@FindBy(name = "label")
	private WebElement labelTextField;
	
	@FindBy(id = "select2-statut-container")
	private WebElement sellStatusDropdown;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchTextField;

	@FindBy(id = "select2-statut_buy-container")
	private WebElement purchaseStatusDropdown;
	
	@FindBy(id = "desc")
	private WebElement descriptionTextBox;

	@FindBy(name = "url")
	private WebElement publicUrlTextField;
	
	@FindBy(name = "duration_value")
	private WebElement duration;
	
	@FindBy(id = "select2-duration_unit-container")
	private WebElement durationDropdown;
	
	public WebElement getDurationDropdown() {
		return durationDropdown;
	}

	@FindBy(id = "note_private")
	private WebElement privateNoteTextBox;
	
	@FindBy(name = "price")
	private WebElement sellingPriceTextField;

	@FindBy(name = "price_min")
	private WebElement minSellingPriceTextField;

	@FindBy(name = "accountancy_code_sell")
	private WebElement saleAccountingCodeTextField;

	@FindBy(name = "accountancy_code_sell_export")
	private WebElement saleExportAccountingCodeTextField;

	@FindBy(name = "accountancy_code_buy")
	private WebElement purchaseAccountingCodeTextField;

	@FindBy(name = "accountancy_code_buy_export")
	private WebElement purchaseImportAccountingCodeTextField;
	
	@FindBy(xpath = "//input[@value='Create']")
	private WebElement createButton;

	public WebElement getProductRefTextField() {
		return productRefTextField;
	}

	public WebElement getLabelTextField() {
		return labelTextField;
	}

	public WebElement getSellStatusDropdown() {
		return sellStatusDropdown;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getPurchaseStatusDropdown() {
		return purchaseStatusDropdown;
	}

	public WebElement getDescriptionTextBox() {
		return descriptionTextBox;
	}

	public WebElement getPublicUrlTextField() {
		return publicUrlTextField;
	}

	public WebElement getDuration() {
		return duration;
	}

	public WebElement getPrivateNoteTextBox() {
		return privateNoteTextBox;
	}

	public WebElement getSellingPriceTextField() {
		return sellingPriceTextField;
	}

	public WebElement getMinSellingPriceTextField() {
		return minSellingPriceTextField;
	}

	public WebElement getSaleAccountingCodeTextField() {
		return saleAccountingCodeTextField;
	}

	public WebElement getSaleExportAccountingCodeTextField() {
		return saleExportAccountingCodeTextField;
	}

	public WebElement getPurchaseAccountingCodeTextField() {
		return purchaseAccountingCodeTextField;
	}

	public WebElement getPurchaseImportAccountingCodeTextField() {
		return purchaseImportAccountingCodeTextField;
	}

	public WebElement getCreateButton() {
		return createButton;
	}

	public void createNewService(ArrayList<String> data, int randomNum) {

		getProductRefTextField().sendKeys(data.get(0) + randomNum);
		getLabelTextField().sendKeys(data.get(1) + randomNum);
		selectFromDropDown(getSellStatusDropdown(), data.get(2));
		selectFromDropDown(getPurchaseStatusDropdown(), data.get(3));
		getDescriptionTextBox().sendKeys(data.get(4) + randomNum);
		getPublicUrlTextField().sendKeys(data.get(5) + randomNum);
		getDuration().sendKeys(data.get(6));
		selectFromDropDown(getDurationDropdown(), data.get(7));
		getPrivateNoteTextBox().sendKeys(data.get(8) + randomNum);
		getSellingPriceTextField().sendKeys(data.get(9));
		getMinSellingPriceTextField().sendKeys(data.get(10));
		getSaleAccountingCodeTextField().sendKeys(data.get(11) + randomNum);
		getSaleExportAccountingCodeTextField().sendKeys(data.get(11) + randomNum);
		getPurchaseAccountingCodeTextField().sendKeys(data.get(11) + randomNum);
		getPurchaseImportAccountingCodeTextField().sendKeys(data.get(11) + randomNum);
		getCreateButton().click();
	}

	public void selectFromDropDown(WebElement element, String data) {
		Actions actions = new Actions(driver);
		element.click();
		actions.pause(500).perform();
		getSearchTextField().sendKeys(data);
		actions.pause(500).perform();
		getSearchTextField().sendKeys(Keys.ENTER);
	}
}
