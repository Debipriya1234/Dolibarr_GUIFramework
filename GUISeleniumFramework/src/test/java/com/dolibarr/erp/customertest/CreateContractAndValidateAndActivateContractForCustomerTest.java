package com.dolibarr.erp.customertest;
/**
 * @author REKHA GUPTA
 * Create a new contract for customer and validate the contract and activate contract for customer
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.dolibarr.erp.generic.basetest.BaseClass;
import com.dolibarr.erp.objectrepositoryutility.ContractForCustomerPage;
import com.dolibarr.erp.objectrepositoryutility.CustomerInfoPage;
import com.dolibarr.erp.objectrepositoryutility.CustomerPage;
import com.dolibarr.erp.objectrepositoryutility.HomePage;
import com.dolibarr.erp.objectrepositoryutility.ListOfCustomerPage;
import com.dolibarr.erp.objectrepositoryutility.NewContractForCustomerPage;
import com.dolibarr.erp.objectrepositoryutility.NewThirdPartyPage;
import com.dolibarr.erp.objectrepositoryutility.ThirdPartiesPage;

public class CreateContractAndValidateAndActivateContractForCustomerTest extends BaseClass {
	
	@Test
	public void createContract() throws Throwable
	{
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
		String statusOfService_2 = eLib.getDataFromExcel("ThirdParty",1, 13);
		/**
		 * Navigating to Third-Parties Menu
		 */
        HomePage hp= new HomePage(driver);
        hp.clickOnThirdPartiesMenu();
        /**
         * Creating new customer
         */
        ThirdPartiesPage t=new ThirdPartiesPage(driver);
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
        ThirdPartiesPage tpp = new ThirdPartiesPage(driver);
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
		 * Activate Contract
		 */
		ccp.getActivateContractLink().click();
		ccp.getYesButton().click();
		/**
		 * Verify the status after activate the contract
		 */
		String ActivateStatus = ccp.getActivateStatus().getText();
		Assert.assertEquals(ActivateStatus, statusOfService_2);
		Reporter.log(ActivateStatus+"status is verified",true);
        
        
        
        
	}
	

}
