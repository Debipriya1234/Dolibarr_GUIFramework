package com.dolibarr.erp.customertest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.dolibarr.erp.generic.basetest.BaseClass;
import com.dolibarr.erp.objectrepositoryutility.CustomerInfoPage;
import com.dolibarr.erp.objectrepositoryutility.CustomerPage;
import com.dolibarr.erp.objectrepositoryutility.HomePage;
import com.dolibarr.erp.objectrepositoryutility.ListOfCustomerPage;
import com.dolibarr.erp.objectrepositoryutility.NewThirdPartyPage;
import com.dolibarr.erp.objectrepositoryutility.Third_PartiesPage;
import com.dolibarr.erp.objectrepositoryutility.createOrderPage;
import com.dolibarr.erp.objectrepositoryutility.salesOrderPage;

public class CreateOrderAndValidateForCustomerTest extends BaseClass
{
	@Test 
	public void createContract() throws Throwable
	{
		/**
		 * Fetching data from Excel
		 */
		String CName = eLib.getDataFromExcel("ThirdParty",1, 2) + jLib.getRandomNumber();
		String CityName = eLib.getDataFromExcel("ThirdParty",1, 3);
		String RefCust = eLib.getDataFromExcel("ThirdParty",1, 4) + jLib.getRandomNumber();
		String status = eLib.getDataFromExcel("ThirdParty",1, 5);
		String discription = eLib.getDataFromExcel("ThirdParty",1, 6);
		String netPrice = eLib.getDataFromExcel("ThirdParty",1, 7);
		String Qty = eLib.getDataFromExcel("ThirdParty",1, 8);
		String Discount = eLib.getDataFromExcel("ThirdParty",1, 9);
		String statusmsg1=eLib.getDataFromExcel("ThirdParty",4,15);

		/**
		 * Navigating to Third-Parties Menu
		 */
        HomePage hp= new HomePage(driver);
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
         * Click on create order link
         */
        CustomerPage cp= new CustomerPage(driver);
        cp.getCreateOrderLink().click();
        /**
         * Create Order for customer
         */
        createOrderPage cop= new createOrderPage(driver);
        cop.getRef_customer().sendKeys(RefCust);
        cop.getSave().click();
        /**
         * Verify draft status for order
         */
        salesOrderPage sop= new salesOrderPage(driver);
        String draftStatus = sop.getStatus().getText();
        Assert.assertEquals(draftStatus, status);
        Reporter.log(draftStatus+"status is verified",true);
        /**
         * Validate the order
         */
        sop.addLine(discription, netPrice, Qty, Discount);
        sop.getValidate().click();
        sop.getYesButton().click();
        /**
         * Verify the Validate status
         */
       String Actstatusmsg = sop.getAftervalidatestatus().getText();
       Assert.assertEquals(Actstatusmsg, statusmsg1);
       Reporter.log(draftStatus+"status is verified",true);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
}
}
