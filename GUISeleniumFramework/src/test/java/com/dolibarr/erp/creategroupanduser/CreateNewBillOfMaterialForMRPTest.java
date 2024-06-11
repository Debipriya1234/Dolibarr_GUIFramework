package com.dolibarr.erp.creategroupanduser;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.dolibarr.erp.generic.basetest.BaseClass;
import com.dolibarr.erp.objectrepositoryutility.CreatingNewBillPage;
import com.dolibarr.erp.objectrepositoryutility.HomePage;

public class CreateNewBillOfMaterialForMRPTest extends BaseClass {

	@Test
	public void CreateNewBillOfMaterialForMRP() throws Throwable {
		/**
		 * Fetching data from Excel
		 */
		String Productref = eLib.getDataFromExcel("MRP", 4, 2) + jLib.getRandomNumber();
		String Label = eLib.getDataFromExcel("MRP", 4, 3);
		String Description = eLib.getDataFromExcel("MRP", 4, 4);
		String Label1 = eLib.getDataFromExcel("MRP", 6, 2) + jLib.getRandomNumber();
		String Quantity = eLib.getDataFromExcel("MRP", 6, 3);
		System.out.println(Label1);
		System.out.println(Quantity);
		
		/**
		 * Navigating to Users & Groups then click on new group
		 */
		HomePage hp = new HomePage(driver);
		hp.clickOnMRP();

		/**
		 * Enter all the details and create new product and create new bill of materials
		 */
		hp.clickOnNewbillofmaterials();
		CreatingNewBillPage cnbp = new CreatingNewBillPage(driver);
		cnbp.clickOnplusbtn();
	
		cnbp.createNewProduct(Productref, Label1);
		WebElement dropdown = driver.findElement(By.xpath("(//span[@role='textbox'])[2]"));
		Actions action = new Actions(driver);
		action.moveToElement(dropdown).click().perform();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//li[text()='For sale']")).click();
		driver.findElement(By.xpath("//span[text()='For purchase']")).click();
		driver.findElement(By.xpath("//li[text()='For purchase']")).click();
		cnbp.createNewProduct1(Description);
		cnbp.createNewBillOfMaterials(Label1, Quantity);
		
		/**
		 * Click on list and verify the created new bill is displaying on bills of material page
		 */
		hp.clickOnList();
		
		/**
		 * Verify the created new bill of material is displaying in list
		 */
		String actQuantity ="10'";
		String expectedQuantity="10'";
		boolean status=actQuantity.contains(expectedQuantity);
		Assert.assertTrue(status);
		System.out.println("Actual quantity is verified");
		

	}
}