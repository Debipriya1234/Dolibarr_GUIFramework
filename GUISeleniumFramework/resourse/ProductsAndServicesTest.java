package com.dolibarr.erp.products_and_services;

import org.testng.annotations.Test;

import com.dolibarr.erp.generic.basetest.BaseClass;
import com.dolibarr.erp.objectrepositoryutility.HomePage;
import com.dolibarr.erp.objectrepositoryutility.Third_PartiesPage;

public class ProductsAndServicesTest extends BaseClass{

	@Test
	public void CreateInvoiceAndPaymentAndValidateForProspect() {
		HomePage homePage = new HomePage(driver);
		homePage.clickOnThirdPartiesMenu();
		Third_PartiesPage third_PartiesPage = new Third_PartiesPage(driver);
		third_PartiesPage.clickOnListOfProspectsLink();
	}
}
