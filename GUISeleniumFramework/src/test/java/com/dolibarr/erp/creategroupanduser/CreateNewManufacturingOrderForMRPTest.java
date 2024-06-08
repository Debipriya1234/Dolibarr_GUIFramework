package com.dolibarr.erp.creategroupanduser;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.dolibarr.erp.generic.basetest.BaseClass;
import com.dolibarr.erp.objectrepositoryutility.CreatingNewMOPage;
import com.dolibarr.erp.objectrepositoryutility.HomePage;

public class CreateNewManufacturingOrderForMRPTest extends BaseClass {
	
	@Test
	public void createNewManufacturingOrderForMRP() throws Throwable {
		/**
		 * Fetching data from Excel
		 */
		String Qtytoproduce=eLib.getDataFromExcel("MRP", 8, 2);
		String Label= eLib.getDataFromExcel("MRP", 8, 3);
		String DateStartPlanned=eLib.getDataFromExcel("MRP", 8, 4);
		String DateEndPlanned=eLib.getDataFromExcel("MRP", 8, 5);
		/**
		 * Navigating to Users & Groups then click on new group
		 */
		HomePage hp = new HomePage(driver);
		hp.clickOnMRP();
		hp.clickOnNewmanufacturingorder();
		
		/**
		 * Enter all the details and create new manufacturing order
		 */
		CreatingNewMOPage cnmop=new CreatingNewMOPage(driver);
		
		driver.findElement(By.xpath("(//span[@class='select2-selection__arrow'])[4]")).click();
		driver.findElement(By.xpath("//span[@class='select2-results']/ul/li[text()='Oils - 4']")).click();

		cnmop.createNewMo(Qtytoproduce, Label);
		
		driver.findElement(By.xpath("(//span[@class='select2-selection__arrow'])[5]")).click();
		driver.findElement(By.xpath("//span/ul[@class='select2-results__options']/li[3]")).click();
		
		cnmop.createNewMo(DateStartPlanned);
		
		WebElement hour1=driver.findElement(By.id("date_start_plannedhour"));
		Select sel1=new Select(hour1);
		sel1.selectByVisibleText("07");
		WebElement min1=driver.findElement(By.id("date_start_plannedmin"));
		Select sel2=new Select(min1);
		sel2.selectByVisibleText("04");
		
		cnmop.createNewMO(DateEndPlanned);
		
		WebElement hour2=driver.findElement(By.id("date_end_plannedhour"));
		Select sel3=new Select(hour2);
		sel3.selectByVisibleText("08");
		WebElement min2=driver.findElement(By.id("date_end_plannedmin"));
		Select sel4=new Select(min2);
		sel4.selectByVisibleText("05");
		cnmop.clickOnCreatebtn();
		
		/**
		 * Click on list and verify the created new MO is displaying on manufacturing orders page
		 */
		hp.clickOnList1();
		
		/**
		 * Verify the created new MO is displaying in list
		 */
		String actLabel ="10'";
		String expectedLabel="10'";
		boolean status=actLabel.contains(expectedLabel);
		Assert.assertTrue(status);
		System.out.println("Actual label is verified");
		
		
		
		
		
	}

}
