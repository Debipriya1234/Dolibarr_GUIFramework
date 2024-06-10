package com.dolibarr.erp.customertest;
/**
 * @author REKHA GUPTA
 * Create New Customer and create new Proposal for customer and Validate Proposal 
 */

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dolibarr.erp.generic.basetest.BaseClass;
import com.dolibarr.erp.objectrepositoryutility.CommercialInfoForCustomerPage;
import com.dolibarr.erp.objectrepositoryutility.CustomerInfoPage;
import com.dolibarr.erp.objectrepositoryutility.CustomerPage;
import com.dolibarr.erp.objectrepositoryutility.HomePage;
import com.dolibarr.erp.objectrepositoryutility.NewCommercialProposalForCustomerPage;
import com.dolibarr.erp.objectrepositoryutility.NewThirdPartyPage;
import com.dolibarr.erp.objectrepositoryutility.Third_PartiesPage;

public class CreateNewCustomerWithNewProposalAndValidateProposalTest extends BaseClass 
{
	@Test
	 public void createNewCustomer() throws Throwable
	 {
		/**
		 * Fetching data from Excel
		 */
		String CName = eLib.getDataFromExcel("ThirdParty",1, 2) + jLib.getRandomNumber();
		String CityName = eLib.getDataFromExcel("ThirdParty",1, 3);
		String RefCust = eLib.getDataFromExcel("ThirdParty",1, 4) + jLib.getRandomNumber();
		String status1 = eLib.getDataFromExcel("ThirdParty",1, 5);
		String discription = eLib.getDataFromExcel("ThirdParty",1, 6);
		String netPrice = eLib.getDataFromExcel("ThirdParty",1, 7);
		String Qty = eLib.getDataFromExcel("ThirdParty",1, 8);
		String Discount = eLib.getDataFromExcel("ThirdParty",1, 9);
		String status2 = eLib.getDataFromExcel("ThirdParty",1, 10);
		
		/**
		 * Navigating to Third-Parties Menu
		 */
        HomePage hp= new HomePage(driver);
        hp.clickOnThirdPartiesMenu();
        /**
         * Navigating to new customer link
         */
        Third_PartiesPage tpp = new Third_PartiesPage(driver);
        tpp.getNewCustomerLink().click();
        /**
         * Creating new customer
         */
        NewThirdPartyPage ntp = new NewThirdPartyPage(driver);
        ntp.getThirdPartyNameTextField().sendKeys(CName);
        ntp.getSelectCustomerProspect().click();
        ntp.getSelectCustomer().click();
        ntp.getCityTextField().sendKeys(CityName);
        ntp.getCreateThirdPartyButton().click();
        /**
         * Navigating to customer info page
         */
        CustomerInfoPage cip= new CustomerInfoPage(driver);
        cip.getCustomerLink().click();
        /**
         * Navigating to customer page
         */
        CustomerPage cp = new CustomerPage(driver);
        cp.clickCreateProposal();
        NewCommercialProposalForCustomerPage ncpc= new NewCommercialProposalForCustomerPage(driver);
        ncpc.getRefCustomer().sendKeys(RefCust);
        ncpc.getCreateDraftButton().click();
        /**
         * Verify the draft status
         */
        CommercialInfoForCustomerPage cipc = new CommercialInfoForCustomerPage(driver);
        String actMsg = cipc.getDrafttext().getText();
        Assert.assertEquals(actMsg, status1);
        /**
         * Add line for validate proposal
         */
        cipc.selectProduct();
        cipc.addLine(discription, netPrice, Qty, Discount);
        /**
         * Validate the proposal
         */
        cipc.getValidateLink().click();
        cipc.getAcceptYes().click();
        /**
         * Validate the status
         */
        String actStatus = cipc.getValidateText().getText();
        Assert.assertEquals(actStatus, status2);
        
	 }
	
	

}
