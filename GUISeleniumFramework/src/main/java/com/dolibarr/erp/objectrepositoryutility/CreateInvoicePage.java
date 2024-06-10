package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateInvoicePage
{
	WebDriver driver;
	public CreateInvoicePage(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy (xpath="//a[text()='Create']")
	private WebElement create;
	
	@FindBy (xpath="//a[text()='Create Invoice']")
	private WebElement createInvoiceLink;
	
	@FindBy(name="re")
	private WebElement InvoiceDate;
	
	@FindBy(id="select2-cond_reglement_id-container")
	private WebElement PaymentTerms;
	
	@FindBy(xpath="//li[text()='30 days']")
	private WebElement SelectTerms;
	
	@FindBy(name="save")
	private WebElement DraftButton;
	
	@FindBy (xpath="//span[@title='Not paid']")
	private WebElement PaymentStatus;
	
	@FindBy(xpath="//a[text()='Enter payment']")
	private WebElement enterPaymentLink;
	
	@FindBy(id="select2-selectpaiementcode-container")
	private WebElement paymentOption;
	
	@FindBy(xpath="//li[text()='Cash']")
    private WebElement cashOption;
	
	@FindBy(xpath="//input[contains(@id,'amount')]")
	private WebElement paymentAmount;
	
	@FindBy(xpath="//span[@class='amount classfortooltip']")
	private WebElement actualAmount;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement payButton;
	
	@FindBy(id="confirm")
	private WebElement confirmOption;
	
	@FindBy(xpath="//input[@value='Validate']")
	private WebElement validateButton;
	
	@FindBy(xpath="//a[text()='Validate']")
	private WebElement validateLink;
	
	@FindBy(xpath="//button[text()='Yes']")
	private WebElement yesButton;
	
	@FindBy(xpath="//td[contains(@class,'right')]")
	private WebElement paidAmount;
	
	
	public WebElement getPaidAmount() {
		return paidAmount;
	}

	public WebElement getYesButton() {
		return yesButton;
	}

	public WebElement getValidateLink() {
		return validateLink;
	}

	public WebElement getValidateButton() {
		return validateButton;
	}

	public WebElement getConfirmOption() {
		return confirmOption;
	}

	public WebElement getPayButton() {
		return payButton;
	}

	public WebElement getActualAmount() {
		return actualAmount;
	}

	public WebElement getPaymentAmount() {
		return paymentAmount;
	}

	public WebElement getCashOption() {
		return cashOption;
	}

	public WebElement getPaymentOption() {
		return paymentOption;
	}

	public WebElement getEnterPaymentLink() {
		return enterPaymentLink;
	}

	public WebElement getPaymentStatus() {
		return PaymentStatus;
	}

	public WebElement getInvoiceDate() {
		return InvoiceDate;
	}

	public WebElement getPaymentTerms() {
		return PaymentTerms;
	}

	public WebElement getSelectTerms() {
		return SelectTerms;
	}

	
	public WebElement getDraftButton() {
		return DraftButton;
	}
	
	
	public WebElement getCreate() {
		return create;
	}

	public WebElement getCreateInvoiceLink() {
		return createInvoiceLink;
	}

	public void confirmOption()
	{
		Select s1= new Select(confirmOption);
		s1.selectByVisibleText("No");
	}
	public void createInvoice(String date)
	{
		getInvoiceDate().sendKeys(date);
		getPaymentTerms().click();
		getSelectTerms().click();	
		getDraftButton().click();
	}

}
