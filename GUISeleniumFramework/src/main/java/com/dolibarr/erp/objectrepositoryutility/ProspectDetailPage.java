package com.dolibarr.erp.objectrepositoryutility;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProspectDetailPage {

	WebDriver driver;

	public ProspectDetailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Create proposal']")
	private WebElement createProposal;

	@FindBy(xpath = "//a[text()='Create contract']")
	private WebElement createcontract;

	@FindBy(xpath = "//a[text()='Create order']")
	private WebElement createorder;

	@FindBy(css = "div[class='inline-block divButAction']")
	private List<WebElement> prospectPageButtons;

	@FindBy(css = "a[title='Third party must be defined as a customer']")
	private List<WebElement> buttonToolTips;

	public List<WebElement> getButtonToolTips() {
		return buttonToolTips;
	}

	public WebElement getCreateInvoiceOrCreditNoteButton() {
		return prospectPageButtons.get(4);
	}

	public WebElement getCreateProposal() {
		return createProposal;
	}

	public WebElement getCreateContract() {
		return createcontract;
	}

	public WebElement getCreateorder() {
		return createorder;
	}

	public boolean isCreateInvoiceButtonToolTipDisplayed() {
		return getButtonToolTips().get(1).isDisplayed();
	}

}
