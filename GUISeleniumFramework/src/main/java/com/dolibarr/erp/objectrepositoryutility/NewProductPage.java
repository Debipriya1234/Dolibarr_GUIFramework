package com.dolibarr.erp.objectrepositoryutility;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dolibarr.erp.generic.webdriverutility.JavaUtility;

/**
 * @author CHIDUSD
 */
public class NewProductPage {

	WebDriver driver;
	JavaUtility javaUtility = new JavaUtility();

	public NewProductPage(WebDriver driver) {
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

	@FindBy(id = "select2-fk_default_warehouse-container")
	private WebElement defaultWarehouseDropdown;

	@FindBy(name = "seuil_stock_alerte")
	private WebElement stockLimitForAlertTextField;

	@FindBy(name = "desiredstock")
	private WebElement desiredStockTextField;

	@FindBy(xpath = "//span[@aria-labelledby='select2-finished-container']")
	private WebElement natureOfProductDropdown;

	@FindBy(name = "weight")
	private WebElement weightTextField;

	@FindBy(name = "volume")
	private WebElement volumeTextField;

	@FindBy(name = "customcode")
	private WebElement customCodeTextField;

	@FindBy(id = "select2-selectcountry_id-container")
	private WebElement countryOfOriginDropdown;

	@FindBy(id = "select2-state_id-container")
	private WebElement stateOfOriginDropdown;

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

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getProductRefTextField() {
		return productRefTextField;
	}

	public WebElement getLabelTextField() {
		return labelTextField;
	}

	public WebElement getSellStatusDropdown() {
		return sellStatusDropdown;
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

	public WebElement getDefaultWarehouseDropdown() {
		return defaultWarehouseDropdown;
	}

	public WebElement getStockLimitForAlertTextField() {
		return stockLimitForAlertTextField;
	}

	public WebElement getDesiredStockTextField() {
		return desiredStockTextField;
	}

	public WebElement getNatureOfProductDropdown() {
		return natureOfProductDropdown;
	}

	public WebElement getWeightTextField() {
		return weightTextField;
	}

	public WebElement getVolumeTextField() {
		return volumeTextField;
	}

	public WebElement getCustomCodeTextField() {
		return customCodeTextField;
	}

	public WebElement getCountryOfOriginDropdown() {
		return countryOfOriginDropdown;
	}

	public WebElement getStateOfOriginDropdown() {
		return stateOfOriginDropdown;
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

	public void createNewProduct(ArrayList<String> data, String warehouseName, int randomNum) {

		getProductRefTextField().sendKeys(data.get(0) + randomNum);
		getLabelTextField().sendKeys(data.get(1) + randomNum);
		selectFromDropDown(getSellStatusDropdown(), data.get(2));
		selectFromDropDown(getPurchaseStatusDropdown(), data.get(3));
		getDescriptionTextBox().sendKeys(data.get(4) + randomNum);
		getPublicUrlTextField().sendKeys(data.get(5) + randomNum);
		selectFromDropDown(getDefaultWarehouseDropdown(), warehouseName);
		getStockLimitForAlertTextField().sendKeys(data.get(6));
		getDesiredStockTextField().sendKeys(data.get(7));
		selectFromDropDown(getNatureOfProductDropdown(), data.get(8));
		getWeightTextField().sendKeys(data.get(9));
		getVolumeTextField().sendKeys(data.get(10));
		getCustomCodeTextField().sendKeys(data.get(11) + randomNum);
		selectFromDropDown(getCountryOfOriginDropdown(), data.get(12));
		selectFromDropDown(getStateOfOriginDropdown(), data.get(13));
		getPrivateNoteTextBox().sendKeys(data.get(14) + randomNum);
		getSellingPriceTextField().sendKeys(data.get(14));
		getMinSellingPriceTextField().sendKeys(data.get(15));
		getSaleAccountingCodeTextField().sendKeys(""+randomNum);
		getSaleExportAccountingCodeTextField().sendKeys(""+randomNum);
		getPurchaseAccountingCodeTextField().sendKeys(""+randomNum);
		getPurchaseImportAccountingCodeTextField().sendKeys(""+randomNum);
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
