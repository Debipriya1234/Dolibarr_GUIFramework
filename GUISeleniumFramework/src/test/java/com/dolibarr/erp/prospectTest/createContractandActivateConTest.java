package com.dolibarr.erp.prospectTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dolibarr.erp.generic.basetest.BaseClass;
import com.dolibarr.erp.objectrepositoryutility.CommercialPageInfoPage;
import com.dolibarr.erp.objectrepositoryutility.HomePage;
import com.dolibarr.erp.objectrepositoryutility.ListOfProspectPage;
import com.dolibarr.erp.objectrepositoryutility.NewThirdPartyPage;
import com.dolibarr.erp.objectrepositoryutility.Third_PartiesPage;
import com.dolibarr.erp.objectrepositoryutility.newContractforProspectPage;
import com.dolibarr.erp.objectrepositoryutility.prosepectInfoTestPage;
import com.dolibarr.erp.objectrepositoryutility.prospectPage;
@Listeners(com.dolibarr.erp.generic.listenerutility.ListImpClass.class)
public class createContractandActivateConTest extends BaseClass{
@Test
public void createContractandActivateConTest() throws Throwable  {
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
	String statusmsg=eLib.getDataFromExcel("ThirdParty",4,11);
	String statusmsg1=eLib.getDataFromExcel("ThirdParty",4,12);
	String statusmsg2=eLib.getDataFromExcel("ThirdParty",4,13);
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
	/**
	 * click on create Contract
	 */
	prospectPage pp=new prospectPage(driver);
	pp.getCreateContract().click();
	/**
	 * navigating newContractProspectPage
	 */
	newContractforProspectPage ncfpp=new newContractforProspectPage(driver);
	ncfpp.getRefCustomer().sendKeys(refcus);
	ncfpp.getCreate().click();
	CommercialPageInfoPage cpip =new CommercialPageInfoPage(driver);
	/**
	 * validating status before validate
	 */
	String actmsg=cpip.getStatus().getText();
	Assert.assertEquals(actmsg,statusmsg);
	Reporter.log(actmsg+"    status is verified",true);
	/**
	 * passing the values for prospect Contract
	 */
	cpip.addLineContract(discription, Nprice, qty, dis);
	cpip.getValidate().click();
	cpip.getYesButton().click();
	/**
	 * validating status after creating contract
	 */
	String actmsg1=cpip.getValidateafter().getText();
	Assert.assertEquals(actmsg1,statusmsg1);
	Reporter.log(actmsg1+"    verified",true);
	cpip.getActivateContract().click();
	cpip.getClickOnYes().click();
	/**
	 * validating status after activating the contract
	 */
	String actmsg2=cpip.getValidateactiveContract().getText();
	Assert.assertEquals(actmsg2,statusmsg2);
	Reporter.log(actmsg2+"  verified",true);
	}
}
