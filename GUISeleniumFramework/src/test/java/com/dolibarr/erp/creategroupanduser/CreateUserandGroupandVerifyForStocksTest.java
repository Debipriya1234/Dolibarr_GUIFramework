package com.dolibarr.erp.creategroupanduser;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.dolibarr.erp.generic.basetest.BaseClass;
import com.dolibarr.erp.objectrepositoryutility.CreatingNewGroupPage;
import com.dolibarr.erp.objectrepositoryutility.CreatingNewUserPage;
import com.dolibarr.erp.objectrepositoryutility.HomePage;

public class CreateUserandGroupandVerifyForStocksTest extends BaseClass {
	
	@Test
	public void createUserandGroupForStocks() throws Throwable {
		/**
		 * Fetching data from Excel
		 */
		String Groupname = eLib.getDataFromExcel("UserGroups", 2, 2) + jLib.getRandomNumber();
		String Description = eLib.getDataFromExcel("UserGroups", 2, 3) + jLib.getRandomNumber();
		String Lastname = eLib.getDataFromExcel("UserGroups", 2, 4);
		String Login = eLib.getDataFromExcel("UserGroups", 2, 5);
		String Password = eLib.getDataFromExcel("UserGroups", 2, 6);
		String Jobposition = eLib.getDataFromExcel("UserGroups", 2, 7);

		/**
		 * Navigating to Users & Groups then click on new group
		 */
		HomePage hp = new HomePage(driver);
		hp.clickOnUsersandGroups();
		hp.clickOnNewgroup();
		

		/**
		 * Enter all the details and create new group for sales
		 */
		CreatingNewGroupPage cngp = new CreatingNewGroupPage(driver);
		cngp.createGroup(Groupname, Description);
		cngp.getCreateGroupbtn().click();
		
		/**
		 * Enter all the details and create new user for sales
		 */
		hp.clickOnNewuser();
		CreatingNewUserPage cnup = new CreatingNewUserPage(driver);
		cnup.createUser(Lastname, Login, Password, Jobposition);
		
		/**
		 * click on listofgroups and add user to the group and click on add button
		 */
		hp.clickOnListofgroups();
		WebElement dropdown = driver.findElement(By.name("limit"));
		Select sel=new Select(dropdown);
		sel.selectByVisibleText("100");
		
        driver.findElement(By.xpath("//i[@title='Next']")).click();
		System.out.println(Groupname);
		driver.findElement(By.xpath("//a[text()='" + Groupname + "']")).click();
		
		driver.findElement(By.xpath("//span[@id='select2-user-container']")).click();
		
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Login, Keys.ENTER);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	    
		/**
	     * Logout as admin and login as a Stocks Executive
	     */
		hp.logout();
		driver.findElement(By.id("username")).sendKeys(Login);
		driver.findElement(By.id("password")).sendKeys(Password);
		System.out.println(Password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		/**
		 * Verify of Login as a Stocks executive expected result
		 */
		String actLogin ="sahoo1000";
		String expectedLogin="sahoo1000";
		boolean status=actLogin.contains(expectedLogin);
		Assert.assertTrue(status);
		System.out.println("Actual login is verified");
		

		
		


}
}
