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
import com.dolibarr.erp.objectrepositoryutility.Third_PartiesPage;
import com.dolibarr.erp.objectrepositoryutility.createOrderPage;
import com.dolibarr.erp.objectrepositoryutility.prosepectInfoTestPage;
import com.dolibarr.erp.objectrepositoryutility.prospectPage;
import com.dolibarr.erp.objectrepositoryutility.salesOrderPage;
@Listeners(com.dolibarr.erp.generic.listenerutility.ListImpClass.class)
public class createOrderTest extends BaseClass{
@Test
public void createOrder() throws Throwable {
	/**
	 * Fetching the data from excel
	 */
	String PName=eLib.getDataFromExcel("ThirdParty", 4, 2)+jLib.getRandomNumber();
	String city=eLib.getDataFromExcel("ThirdParty", 4, 3);
	String refcus=eLib.getDataFromExcel("ThirdParty",4,4)+jLib.getRandomNumber();
	String discription=eLib.getDataFromExcel("ThirdParty",4,6);
	String Nprice=eLib.getDataFromExcel("ThirdParty",4,7);
	String qty=eLib.getDataFromExcel("ThirdParty",4,8);
	String dis=eLib.getDataFromExcel("ThirdParty",4,9);
	String statusmsg=eLib.getDataFromExcel("ThirdParty",4,5);
	String statusmsg1=eLib.getDataFromExcel("ThirdParty",4,15);
	/**
	 * create Prospect
	 */
	HomePage h=new HomePage(driver);
	h.getThirdPartiesMenu().click();
	Third_PartiesPage t=new Third_PartiesPage(driver);
	t.getNewProspectLink().click();
	NewThirdPartyPage ntp=new NewThirdPartyPage(driver);
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
	ListOfProspectPage lpp=new ListOfProspectPage(driver);
	lpp.getSearch().sendKeys(PName,Keys.ENTER);
	/**
	 * clicking on prospectName
	 */
	driver.findElement(By.xpath("//a[text()='"+PName+"']")).click();
	/**
	 * navigating new prospectinfotestpage
	 */
	prosepectInfoTestPage pi=new prosepectInfoTestPage(driver);
	pi.getProspectInfo().click();
	Thread.sleep(3000);
	/**
	 * click on create order
	 */
	prospectPage pp=new prospectPage(driver);
	pp.getCreateorder().click();
	/**
	 * creating order
	 */
	createOrderPage cop=new createOrderPage(driver);
	cop.getRef_customer().sendKeys(refcus);
	cop.getSave().click();
	/**
	 * navigating sales page
	 */
	salesOrderPage sop=new salesOrderPage(driver);
	String actmsg=sop.getStatus().getText();
	/**
	 * validating status before validate
	 */
	Assert.assertEquals(actmsg,statusmsg);
	Reporter.log(actmsg+"  status is verified",true);
	/**
	 * passing the details of order price
	 */
	sop.addLine(discription, Nprice, qty, dis);
	sop.getValidate().click();
	sop.getYesButton().click();
	/**
	 * validating status after validate
	 */
	String actmsg1=sop.getAftervalidatestatus().getText();
	Assert.assertEquals(actmsg1,statusmsg1);
	Reporter.log(actmsg1+"  status is verified",true);
}
}
