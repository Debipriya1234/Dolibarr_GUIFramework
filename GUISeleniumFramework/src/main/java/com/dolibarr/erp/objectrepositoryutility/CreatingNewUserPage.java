package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewUserPage {
	WebDriver driver;
	public CreatingNewUserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='lastname']")
	private WebElement lastname;
	
	@FindBy(id="login")
	private WebElement login;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(name="job")
	private WebElement jobposition;
	
	@FindBy(xpath="//input[@value='Create user']")
	private WebElement createuserbtn;
	
	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getJobposition() {
		return jobposition;
	}

	public WebElement getCreateuserbtn() {
		return createuserbtn;
	}
	
	public void createUser(String Lastname, String Login, String Password, String Jobposition) {
		getLastname().sendKeys(Lastname);
		getLogin().sendKeys(Login);
		getPassword().sendKeys(Password);
		getJobposition().sendKeys(Jobposition);
		getCreateuserbtn().click();
	}
	
	
	
	

}
