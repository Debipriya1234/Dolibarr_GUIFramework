package com.dolibarr.erp.customertest;
/**
 * @author REKHA GUPTA
 */
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.dolibarr.erp.generic.basetest.BaseClass;
import com.dolibarr.erp.objectrepositoryutility.ContractForCustomerPage;
import com.dolibarr.erp.objectrepositoryutility.CreateInvoicePage;
import com.dolibarr.erp.objectrepositoryutility.CustomerInfoPage;
import com.dolibarr.erp.objectrepositoryutility.CustomerPage;
import com.dolibarr.erp.objectrepositoryutility.HomePage;
import com.dolibarr.erp.objectrepositoryutility.ListOfCustomerPage;
import com.dolibarr.erp.objectrepositoryutility.NewContractForCustomerPage;
import com.dolibarr.erp.objectrepositoryutility.NewThirdPartyPage;
import com.dolibarr.erp.objectrepositoryutility.Third_PartiesPage;

public class CreateInvoiceAndValidateTest extends BaseClass{
	@Test
	public void createInvoice() throws Throwable {
		/**
		 * Fetching data from Excel
		 */
		String CName = eLib.getDataFromExcel("ThirdParty",1, 2) + jLib.getRandomNumber();
		String CityName = eLib.getDataFromExcel("ThirdParty",1, 3);
		String RefCust = eLib.getDataFromExcel("ThirdParty",1, 4) + jLib.getRandomNumber();
		String status = eLib.getDataFromExcel("ThirdParty",1, 11);
		String discription = eLib.getDataFromExcel("ThirdParty",1, 6);
		String netPrice = eLib.getDataFromExcel("ThirdParty",1, 7);
		String statusOfService1 = eLib.getDataFromExcel("ThirdParty",1, 12);
		String statusOfPayment1 = eLib.getDataFromExcel("ThirdParty",1, 15);
		String statusOfPayment2 = eLib.getDataFromExcel("ThirdParty",1, 16);
		/**
		 * Navigating to Third-Parties Menu
		 */
		HomePage hp=new HomePage(driver);
		hp.clickOnThirdPartiesMenu();
		
		 /**
         * Creating new customer
         */
        Third_PartiesPage t=new Third_PartiesPage(driver);
    	t.getNewCustomerLink().click();
        NewThirdPartyPage ntp = new NewThirdPartyPage(driver);
        ntp.getThirdPartyNameTextField().sendKeys(CName);
        ntp.getSelectCustomerProspect().click();
        ntp.getSelectCustomer().click();
        ntp.getCityTextField().sendKeys(CityName);
        ntp.getCreateThirdPartyButton().click();
        /**
         * Navigating to list of customer link
         */
        Third_PartiesPage tpp = new Third_PartiesPage(driver);
        tpp.getListOfCustomersLink().click();
        ListOfCustomerPage lcp= new ListOfCustomerPage(driver);
        lcp.getSearchCust().sendKeys(CName,Keys.ENTER);
        driver.findElement(By.xpath("//a[text()='"+ CName +"']")).click();
        /**
         * Navigate to customer link
         */
        CustomerInfoPage cip= new CustomerInfoPage(driver);
        cip.getCustomerLink().click();
        /**
         * Click on create contract link
         */
        CustomerPage cp= new CustomerPage(driver);
        cp.getCreateContractLink().click();
        /**
         * create contract
         */
        NewContractForCustomerPage nccp= new NewContractForCustomerPage(driver);
        nccp.getRefCust().sendKeys(RefCust);
        nccp.getCreateButton().click();
        /**
         * Verify the status 
         */
        ContractForCustomerPage ccp= new ContractForCustomerPage(driver);
        String draftstatus = ccp.getDraftStatus().getText();
        Assert.assertEquals(draftstatus, status);
        Reporter.log(draftstatus+"status is verified",true);
        /**
         * Add line for contract
         */
        ccp.addline(discription, netPrice);
        /**
         * Validate the contract
         */
		ccp.getValidateLink().click();
		ccp.getYesButton().click();
		/**
		 * verify the status of service after validate
		 */
		String ActStatusOfService = ccp.getStatusofService().getText();
		Assert.assertEquals(ActStatusOfService, statusOfService1);
		Reporter.log(ActStatusOfService+"status is verified",true);
		/**
		 * Create invoice
		 */
		String invoiceDate = jLib.getSystemDateMMDDYYYY();
		System.out.println(invoiceDate);
		CreateInvoicePage cip1= new CreateInvoicePage(driver);
		cip1.getCreate().click();
		cip1.getCreateInvoiceLink().click();
		cip1.getInvoiceDate().sendKeys(invoiceDate);
		cip1.getPaymentTerms().click();
		cip1.getSelectTerms().click();	
		cip1.getDraftButton().click();
		/**
		 * validate and verify the invoice
		 */
		cip1.getValidateLink().click();
		cip1.getYesButton().click();
		String payStatus = cip1.getPaymentStatus().getText();
		Assert.assertEquals(payStatus, statusOfPayment1);
		Reporter.log(payStatus+"status is verified",true);
		/**
		 * Enter amount
		 */
		cip1.getEnterPaymentLink().click();
		cip1.getInvoiceDate().sendKeys(invoiceDate);
		cip1.getPaymentOption().click();
		cip1.getCashOption().click();
		String AmountToPay = cip1.getActualAmount().getText();
		System.out.println("AmountToPay: "+AmountToPay);
		WebElement PaymentAmountText = cip1.getPaymentAmount();
		Actions action= new Actions(driver);
		action.moveToElement(PaymentAmountText).click().sendKeys(AmountToPay).perform();
		cip1.getPayButton().click();
		cip1.confirmOption();
		cip1.getValidateButton().click();
		String paidStatus = cip1.getPaidAmount().getText();
		Assert.assertEquals(paidStatus, statusOfPayment2);
		Reporter.log(payStatus+"status is verified",true);
		
		
		
		
		
		
		
		
		
	}

}
