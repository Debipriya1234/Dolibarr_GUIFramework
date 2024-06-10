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
public class NewWarehousePage {

	WebDriver driver;
	JavaUtility javaUtility = new JavaUtility();

	public NewWarehousePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "libelle")
	private WebElement refTextField;

	@FindBy(name = "lieu")
	private WebElement shortNameOfLocation;

	@FindBy(xpath = "//*[@id=\"select2-fk_parent-container\"]")
	private WebElement addInDropDown;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchTextField;

	@FindBy(id = "desc")
	private WebElement descriptionTextField;

	@FindBy(name = "address")
	private WebElement addressTextField;

	@FindBy(id = "zipcode")
	private WebElement zipCode;

	@FindBy(id = "town")
	private WebElement cityTextField;

	@FindBy(id = "select2-selectcountry_id-container")
	private WebElement countryDropDown;

	@FindBy(name = "phone")
	private WebElement phoneTextField;

	@FindBy(name = "fax")
	private WebElement faxTextField;

	@FindBy(id = "select2-warehousestatus-container")
	private WebElement statusDropDown;

	@FindBy(name = "add")
	private WebElement createButton;

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getCreateButton() {
		return createButton;
	}

	public WebElement getRefTextField() {
		return refTextField;
	}

	public WebElement getShortNameOfLocation() {
		return shortNameOfLocation;
	}

	public WebElement getAddInDropDown() {
		return addInDropDown;
	}

	public WebElement getDescriptionTextField() {
		return descriptionTextField;
	}

	public WebElement getAddressTextField() {
		return addressTextField;
	}

	public WebElement getZipCode() {
		return zipCode;
	}

	public WebElement getCityTextField() {
		return cityTextField;
	}

	public WebElement getCountryDropDown() {
		return countryDropDown;
	}

	public WebElement getPhoneTextField() {
		return phoneTextField;
	}

	public WebElement getFaxTextField() {
		return faxTextField;
	}

	public WebElement getStatusDropDown() {
		return statusDropDown;
	}

	public void createNewWarehouse(ArrayList<String> data, int randomNum) {

		getRefTextField().sendKeys(data.get(0) + randomNum);
		getShortNameOfLocation().sendKeys(data.get(1) + randomNum);
		selectFromDropDown(getAddInDropDown(), data.get(2));
		getDescriptionTextField().sendKeys(data.get(3) + randomNum);
		getAddressTextField().sendKeys(data.get(4));
		getZipCode().sendKeys(data.get(5));
		getCityTextField().sendKeys(data.get(6));
		selectFromDropDown(getCountryDropDown(), data.get(7));
		getPhoneTextField().sendKeys(data.get(8));
		getFaxTextField().sendKeys(data.get(9));
		selectFromDropDown(getStatusDropDown(), data.get(10));
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
