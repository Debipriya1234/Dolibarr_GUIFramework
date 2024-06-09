package com.dolibarr.erp.prospectTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dolibarr.erp.generic.basetest.BaseClass;
import com.dolibarr.erp.objectrepositoryutility.HomePage;
import com.dolibarr.erp.objectrepositoryutility.ListOfProspectPage;
import com.dolibarr.erp.objectrepositoryutility.NewThirdPartyPage;
import com.dolibarr.erp.objectrepositoryutility.ThirdPartiesPage;
import com.dolibarr.erp.objectrepositoryutility.CreateOrderPage;
import com.dolibarr.erp.objectrepositoryutility.ProsepectInfoTestPage;
import com.dolibarr.erp.objectrepositoryutility.ProspectDetailPage;
import com.dolibarr.erp.objectrepositoryutility.SalesOrderPage;

@Listeners(com.dolibarr.erp.generic.listenerutility.ListImpClass.class)
public class CreateOrderTest extends BaseClass {
	@Test
	public void createOrder() throws Throwable {
		/**
		 * Fetching the data from excel
		 */
		String PName = eLib.getDataFromExcel("ThirdParty", 4, 2) + jLib.getRandomNumber();
		String city = eLib.getDataFromExcel("ThirdParty", 4, 3);
		String refcus = eLib.getDataFromExcel("ThirdParty", 4, 4) + jLib.getRandomNumber();
		String discription = eLib.getDataFromExcel("ThirdParty", 4, 6);
		String Nprice = eLib.getDataFromExcel("ThirdParty", 4, 7);
		String qty = eLib.getDataFromExcel("ThirdParty", 4, 8);
		String dis = eLib.getDataFromExcel("ThirdParty", 4, 9);
		String statusmsg = eLib.getDataFromExcel("ThirdParty", 4, 5);
		String statusmsg1 = eLib.getDataFromExcel("ThirdParty", 4, 15);
		/**
		 * create Prospect
		 */
		HomePage h = new HomePage(driver);
		h.getThirdPartiesMenu().click();
		ThirdPartiesPage t = new ThirdPartiesPage(driver);
		t.getNewProspectLink().click();
		NewThirdPartyPage ntp = new NewThirdPartyPage(driver);
		ntp.getThirdPartyNameTextField().sendKeys(PName);
		ntp.getSelectCustomerProspect().click();
		ntp.getProspect().click();
		ntp.getCityTextField().sendKeys(city);
		ntp.getCreateThirdPartyButton().click();
		/**
		 * navigating list of prospect
		 */
		t.getListOfProspectsLink().click();
		/**
		 * searching the prospect name in listofProspect
		 */
		ListOfProspectPage lpp = new ListOfProspectPage(driver);
		lpp.getSearch().sendKeys(PName, Keys.ENTER);
		/**
		 * clicking on prospectName
		 */
		driver.findElement(By.xpath("//a[text()='" + PName + "']")).click();
		/**
		 * navigating new prospectinfotestpage
		 */
		ProsepectInfoTestPage pi = new ProsepectInfoTestPage(driver);
		pi.getProspectInfo().click();
		Thread.sleep(3000);
		/**
		 * click on create order
		 */
		ProspectDetailPage pp = new ProspectDetailPage(driver);
		pp.getCreateorder().click();
		/**
		 * creating order
		 */
		CreateOrderPage cop = new CreateOrderPage(driver);
		cop.getRef_customer().sendKeys(refcus);
		cop.getSave().click();
		/**
		 * navigating sales page
		 */
		SalesOrderPage sop = new SalesOrderPage(driver);
		String actmsg = sop.getStatus().getText();
		/**
		 * validating status before validate
		 */
		Assert.assertEquals(actmsg, statusmsg);
		Reporter.log(actmsg + "  status is verified", true);
		/**
		 * passing the details of order price
		 */
		sop.addLine(discription, Nprice, qty, dis);
		sop.getValidate().click();
		sop.getYesButton().click();
		/**
		 * validating status after validate
		 */
		String actmsg1 = sop.getAftervalidatestatus().getText();
		Assert.assertEquals(actmsg1, statusmsg1);
		Reporter.log(actmsg1 + "  status is verified", true);
	}
}
