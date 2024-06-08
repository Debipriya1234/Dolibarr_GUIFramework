package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewMOPage {
	WebDriver driver;
	public CreatingNewMOPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//span[@class='select2-selection__arrow'])[4]")
	private WebElement Product;
    @FindBy(id="qty")
	private WebElement qtytoproduce;
	@FindBy(id="label")
	private WebElement Label;
	@FindBy(xpath="(//span[@role='textbox'])[6]")
	private WebElement Warehouseforproduction;
	@FindBy(id="date_start_planned")
	private WebElement Datestartplanned;
	@FindBy(id="date_end_planned")
	private WebElement Dateendplanned;
	@FindBy(xpath="(//input[@type='submit'])[1]")
	private WebElement Createbtn;
	
    public WebElement getProduct() {
		return Product;
	}


	public WebElement getQtytoproduce() {
		return qtytoproduce;
	}

	public WebElement getLabel() {
		return Label;
	}
	
	public WebElement getWarehouseforproduction() {
		return Warehouseforproduction;
	}

	public WebElement getDatestartplanned() {
		return Datestartplanned;
	}

	public WebElement getDateendplanned() {
		return Dateendplanned;
	}

	public WebElement getCreatebtn() {
		return Createbtn;
	}

	public void createNewMo(String Qtytoproduce,String Label) {
		getQtytoproduce().sendKeys(Qtytoproduce);
		getLabel().sendKeys(Label);
		}
	public void createNewMo(String DateStartPlanned) {
		getDatestartplanned().sendKeys(DateStartPlanned);
	}
	public void createNewMO(String DateEndPlanned) {
		getDateendplanned().sendKeys(DateEndPlanned);
	}
	public void clickOnCreatebtn() {
		getCreatebtn().click();
	}
	
	 
	
	
}
