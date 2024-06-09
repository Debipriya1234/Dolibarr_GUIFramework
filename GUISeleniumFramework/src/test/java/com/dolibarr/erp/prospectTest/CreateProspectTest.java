package com.dolibarr.erp.prospectTest;

/**
 * @author anusha
 */

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.dolibarr.erp.generic.basetest.BaseClass;
import com.dolibarr.erp.objectrepositoryutility.CommercialPageInfoPage;
import com.dolibarr.erp.objectrepositoryutility.HomePage;
import com.dolibarr.erp.objectrepositoryutility.NewCommercialProposalPage;
import com.dolibarr.erp.objectrepositoryutility.NewThirdPartyPage;
import com.dolibarr.erp.objectrepositoryutility.ProsepectInfoPage;
import com.dolibarr.erp.objectrepositoryutility.ThirdPartiesPage;
import com.dolibarr.erp.objectrepositoryutility.ProsepectInfoTestPage;
import com.dolibarr.erp.objectrepositoryutility.ProspectDetailPage;

@Listeners(com.dolibarr.erp.generic.listenerutility.ListImpClass.class)
public class CreateProspectTest extends BaseClass {
	/**
	 * This method used to create prospect and proposal and validate
	 */
	@Test
	public void createProspect() throws Throwable {
		/**
		 * Fetching the data from excel sheet
		 */
		String PName = eLib.getDataFromExcel("ThirdParty", 4, 2) + jLib.getRandomNumber();
		String city = eLib.getDataFromExcel("ThirdParty", 4, 3);
		String refcus = eLib.getDataFromExcel("ThirdParty", 4, 4) + jLib.getRandomNumber();
		String statusmsg = eLib.getDataFromExcel("ThirdParty", 4, 5);
		String statusmsg1 = eLib.getDataFromExcel("ThirdParty", 4, 10);
		String discription = eLib.getDataFromExcel("ThirdParty", 4, 6);
		String Nprice = eLib.getDataFromExcel("ThirdParty", 4, 7);
		String qty = eLib.getDataFromExcel("ThirdParty", 4, 8);
		String dis = eLib.getDataFromExcel("ThirdParty", 4, 9);
		/**
		 * navigating HomePage
		 */
		HomePage h = new HomePage(driver);
		h.getThirdPartiesMenu().click();
		/**
		 * navigating thirdparties page
		 */
		ThirdPartiesPage t = new ThirdPartiesPage(driver);
		t.getNewProspectLink().click();
		/**
		 * creating new thirdparty
		 */
		NewThirdPartyPage ntp = new NewThirdPartyPage(driver);
		ntp.getThirdPartyNameTextField().sendKeys(PName);
		ntp.getSelectCustomerProspect().click();
		ntp.getProspect().click();
		ntp.getCityTextField().sendKeys(city);
		ntp.getCreateThirdPartyButton().click();
		/**
		 * navigating prospect info page
		 */
		ProsepectInfoTestPage pi = new ProsepectInfoTestPage(driver);
		pi.getProspectInfo().click();
		/**
		 * creating proposal
		 */
		ProspectDetailPage pp = new ProspectDetailPage(driver);
		pp.getCreateProposal().click();
		/**
		 * navigating new proposal page
		 */
		NewCommercialProposalPage ncpp = new NewCommercialProposalPage(driver);
		ncpp.getRefCustomer().sendKeys(refcus);
		ncpp.getSavedraft().click();

		/**
		 * validating status before Validate
		 */
		CommercialPageInfoPage cpip = new CommercialPageInfoPage(driver);
		String actmsg = cpip.getStatus().getText();
		Assert.assertEquals(actmsg, statusmsg);
		Reporter.log(actmsg + "status is verified", true);
		/**
		 * passing the datails of the product
		 */
		cpip.addLine(discription, Nprice, qty, dis);
		cpip.getValidate().click();
		cpip.getYesButton().click();
		/**
		 * validating status after validate
		 */
		String actMsg1 = cpip.getValidateafter().getText();
		Assert.assertEquals(actMsg1, statusmsg1);
		Reporter.log(actMsg1 + "status is verified", true);
	}
	
	@Test
	public void CreateInvoiceAndPaymentAndValidateForProspect() throws Throwable {
		/**
		 * Fetching the data from excel sheet
		 */
		String prospectName = eLib.getDataFromExcel("ThirdParty", 4, 2) + jLib.getRandomNumber();
		String city = eLib.getDataFromExcel("ThirdParty", 4, 3);

		HomePage homePage = new HomePage(driver);
		homePage.getThirdPartiesMenu().click();
		ThirdPartiesPage thirdPartiesPage = new ThirdPartiesPage(driver);
		thirdPartiesPage.getNewProspectLink().click();
		NewThirdPartyPage newThirdPartyPage = new NewThirdPartyPage(driver);
		newThirdPartyPage.getThirdPartyNameTextField().sendKeys(prospectName);
		newThirdPartyPage.getSelectCustomerProspect().click();
		newThirdPartyPage.getProspect().click();
		newThirdPartyPage.getCityTextField().sendKeys(city);
		newThirdPartyPage.getCreateThirdPartyButton().click();
		ProsepectInfoPage prosepectInfoPage = new ProsepectInfoPage(driver);
		prosepectInfoPage.goToProspectTab();
		ProspectDetailPage prospectDetailPage = new ProspectDetailPage(driver);
		Assert.assertTrue(prospectDetailPage.isCreateInvoiceButtonToolTipDisplayed());
	}
}
