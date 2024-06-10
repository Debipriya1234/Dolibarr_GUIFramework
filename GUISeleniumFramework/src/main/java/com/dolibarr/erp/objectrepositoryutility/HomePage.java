package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dolibarr.erp.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Deepak
 * 
 *         Contains Login page elements & business lib like login()
 *
 */
public class HomePage {
	WebDriverUtility Wlib = new WebDriverUtility();
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='topmenu-login-dropdown']")
	private WebElement logoutMenu;
	@FindBy(xpath = "//span[text()='Logout']")
	private WebElement logOut;

	@FindBy(id = "mainmenua_companies")
	private WebElement thirdPartiesMenu;
	@FindBy(xpath = "//a[@title='Users & Groups']")
	private WebElement UsersandGroups;
	@FindBy(xpath = "//a[@title='New group']")
	private WebElement Newgroup;
	@FindBy(xpath = "//a[@title='New user']")
	private WebElement Newuser;
	@FindBy(linkText = "List of groups")
	private WebElement Listofgroups;
	@FindBy(xpath = "//span[text()='MRP']")
	private WebElement MRP;
	@FindBy(xpath = "//a[@title='New bill of materials']")
	private WebElement Newbillofmaterials;
	@FindBy(xpath = "(//a[@title='List'])[1]")
	private WebElement List;
	@FindBy(xpath = "//a[@title='New Manufacturing Order']")
	private WebElement Newmanufacturingorder;
	@FindBy(xpath = "(//a[@title='List'])[2]")
	private WebElement List1;
	@FindBy(id = "mainmenua_products")
	private WebElement productsAndServicesMenu;

	public WebElement getNewgroup() {
		return Newgroup;
	}

	public WebElement getUsersandGroups() {
		return UsersandGroups;
	}
	
    public WebElement getNewuser() {
		return Newuser;
	}
      
    public WebElement getListofgroups() {
		return Listofgroups;
	}
    
    public WebElement getMRP() {
		return MRP;
	}
    

	public WebElement getNewbillofmaterials() {
		return Newbillofmaterials;
	}
	

	public WebElement getNewmanufacturingorder() {
		return Newmanufacturingorder;
	}
	

	public WebElement getList() {
		return List;
	}
	

	public WebElement getList1() {
		return List1;
	}

	public WebElement getProductsAndServicesMenu() {
		return productsAndServicesMenu;
	}

	public WebElement getThirdPartiesMenu() {
		return thirdPartiesMenu;
	}

	public WebElement getLogoutMenu() {
		return logoutMenu;
	}

	public WebElement getLogOut() {
		return logOut;
	}

	public void logout() {
		Wlib.mousemoveOnElement(driver, logoutMenu);
		getLogoutMenu().click();
		getLogOut().click();
	}

	public void clickOnThirdPartiesMenu() {
		getThirdPartiesMenu().click();
	}

	public void clickOnProductsAndServicesMenu() {
		getProductsAndServicesMenu().click();
	}
	
	public void clickOnMRP() {
		getMRP().click();
	}
	public void clickOnNewmanufacturingorder() {
		getNewmanufacturingorder().click();
	}
	public void clickOnList1() {
		getList1().click();
	}
	public void clickOnNewbillofmaterials() {
		getNewbillofmaterials().click();
	}
	public void clickOnList() {
		getList().click();
	}
	public void clickOnUsersandGroups() {
		getUsersandGroups().click();
	}
	public void clickOnNewgroup() {
		getNewgroup().click();
	}
	public void clickOnNewuser() {
		getNewuser().click();
	}
	public void clickOnListofgroups() {
		getListofgroups().click();
	}
}
