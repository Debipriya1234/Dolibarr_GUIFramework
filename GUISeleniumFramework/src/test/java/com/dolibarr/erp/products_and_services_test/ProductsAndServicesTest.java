package com.dolibarr.erp.products_and_services_test;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dolibarr.erp.generic.basetest.BaseClass;
import com.dolibarr.erp.generic.fileutility.ExcelUtility;
import com.dolibarr.erp.generic.webdriverutility.JavaUtility;
import com.dolibarr.erp.objectrepositoryutility.HomePage;
import com.dolibarr.erp.objectrepositoryutility.NewProductPage;
import com.dolibarr.erp.objectrepositoryutility.NewServicePage;
import com.dolibarr.erp.objectrepositoryutility.NewWarehousePage;
import com.dolibarr.erp.objectrepositoryutility.ProductListPage;
import com.dolibarr.erp.objectrepositoryutility.ProductsAndServicesPage;
import com.dolibarr.erp.objectrepositoryutility.ServiceDetailPage;
import com.dolibarr.erp.objectrepositoryutility.ServiceListPage;
import com.dolibarr.erp.objectrepositoryutility.WarehouseDetailPage;

public class ProductsAndServicesTest extends BaseClass {
	ExcelUtility excelUtility = new ExcelUtility();
	JavaUtility javaUtility = new JavaUtility();

	@Test(enabled = true)
	public void CreateWarehouseAndProductAndVerify() throws Throwable {

		ArrayList<String> warehouseData = new ArrayList<String>();
		ArrayList<String> productData = new ArrayList<String>();
		warehouseData = excelUtility.getArrayListFromExcel("ProductsAndServices", 7, 2);
		productData = excelUtility.getArrayListFromExcel("ProductsAndServices", 10, 2);
		int randomNum = javaUtility.getRandomNumber();

		HomePage homePage = new HomePage(driver);
		homePage.clickOnProductsAndServicesMenu();
		ProductsAndServicesPage productsAndServicesPage = new ProductsAndServicesPage(driver);
		productsAndServicesPage.clickOnNewWarehouseLink();
		NewWarehousePage newWarehousePage = new NewWarehousePage(driver);
		newWarehousePage.createNewWarehouse(warehouseData, randomNum);
		driver.navigate().refresh();
		WarehouseDetailPage warehouseDetailPage = new WarehouseDetailPage(driver);
		Assert.assertEquals(driver.getTitle(), "Warehouse card");
		Assert.assertTrue(warehouseDetailPage.getWarehouseHeaderText().contains("New_Warehouse"));
		warehouseDetailPage.naviagateToHomePage();
		homePage.clickOnProductsAndServicesMenu();
		productsAndServicesPage.clickOnNewProductLink();
		NewProductPage newProductPage = new NewProductPage(driver);
		newProductPage.createNewProduct(productData, warehouseData.get(0) + randomNum, randomNum);
		Assert.assertTrue(driver.getTitle().contains("Product"));
		warehouseDetailPage.naviagateToHomePage();
		homePage.clickOnProductsAndServicesMenu();
		productsAndServicesPage.clickOnProductListLink();
		ProductListPage productListPage = new ProductListPage(driver);
		productListPage.searchProduct(productData.get(0) + randomNum);
		String path = "//span[text()='" + productData.get(0) + randomNum + "']";
		Assert.assertTrue(driver.findElement(By.xpath(path)).isDisplayed());
	}

	@Test(enabled = true)
	public void CreateServicesAndVerifyInList() throws Throwable {

		ArrayList<String> serviceData = new ArrayList<String>();
		serviceData = excelUtility.getArrayListFromExcel("ProductsAndServices", 13, 2);
		int randomNum = javaUtility.getRandomNumber();

		HomePage homePage = new HomePage(driver);
		homePage.clickOnProductsAndServicesMenu();
		ProductsAndServicesPage productsAndServicesPage = new ProductsAndServicesPage(driver);
		productsAndServicesPage.clickOnNewServiceLink();
		NewServicePage newServicePage = new NewServicePage(driver);
		newServicePage.createNewService(serviceData, randomNum);
		ServiceDetailPage serviceDetailPage = new ServiceDetailPage(driver);
		String path = "//div[text()='" + serviceData.get(0) + randomNum + "']";
		Assert.assertTrue(serviceDetailPage.verifyServiceDetails(driver.findElement(By.xpath(path))));
		serviceDetailPage.naviagateToHomePage();
		homePage.clickOnProductsAndServicesMenu();
		productsAndServicesPage.clickOnServiceListLink();
		ServiceListPage serviceListPage = new ServiceListPage(driver);
		serviceListPage.searchProduct(serviceData.get(0) + randomNum);
		String xpath = "//span[text()='" + serviceData.get(0) + randomNum + "']";
		Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
	}
}
