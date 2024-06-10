package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommercialInfoForCustomerPage
{
	WebDriver driver;
	public CommercialInfoForCustomerPage(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this); 
	}
	@FindBy(xpath="//span[contains(@title,'Draft')]")
	private WebElement drafttext;
	
	@FindBy(id="select2-select_type-container")
	private WebElement selecttype;
	
	@FindBy(id="dp_desc")
	private WebElement desText;
	
	@FindBy(name="price_ht")
	private WebElement netPriceText;
	
	@FindBy(id="qty")
	private WebElement netQtyText;
	
	@FindBy(id="remise_percent")
	private WebElement DiscText;
	
	@FindBy(id="addline")
	private WebElement addButton;
	
	@FindBy(xpath="//li[text()='Product']")
	private WebElement Product;
	
	@FindBy(xpath= "//a[text()='Validate']")
	private WebElement validateLink;
	
	@FindBy(xpath= "//button[text()='Yes']")
	private WebElement acceptYes;
	
	@FindBy(xpath="//span[contains(@title,'Validated')]")
	private WebElement validateText;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getDrafttext() {
		return drafttext;
	}

	public WebElement getSelecttype() {
		return selecttype;
	}

	public WebElement getDesText() {
		return desText;
	}

	public WebElement getNetPriceText() {
		return netPriceText;
	}

	public WebElement getNetQtyText() {
		return netQtyText;
	}

	public WebElement getDiscText() {
		return DiscText;
	}

	public WebElement getAddButton() {
		return addButton;
	}
	
	
	public WebElement getProduct() {
		return Product;
	}
	

	public WebElement getValidateLink() {
		return validateLink;
	}
    
	
	public WebElement getAcceptYes() {
		return acceptYes;
	}
    
	
	public WebElement getValidateText() {
		return validateText;
	}

	public void selectProduct()
	{
		getSelecttype().click();
		getProduct().click();
	}
	
	public void addLine(String dis,String netPrice, String Qty, String Discount )
	{
		getDesText().sendKeys(dis);
		getNetPriceText().sendKeys(netPrice);
		getNetQtyText().sendKeys(Qty);
		getDiscText().sendKeys(Discount);
		getAddButton().click();
		
	}
	
	
}
