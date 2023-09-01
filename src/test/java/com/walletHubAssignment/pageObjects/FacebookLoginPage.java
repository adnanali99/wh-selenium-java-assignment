package com.walletHubAssignment.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walletHubAssignment.utilities.DriverHelper;

public class FacebookLoginPage extends DriverHelper {

	WebDriver ldriver;

	public FacebookLoginPage(WebDriver rdriver) {

		super(rdriver);
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Login Page Locators
	@FindBy(id = "email")
	@CacheLookup // @CacheLookup is an optional thing, just to save execution time
	WebElement userEmail;

	@FindBy(id = "pass")
	@CacheLookup
	WebElement userPassword;

	@FindBy(name = "login")
	@CacheLookup
	WebElement loginBtn;

	// Action Methods for Facebook Login Page
	public void setEmail(String email) {
		WebElement elemEmail = waitForElementToBeVisible(userEmail);
		elemEmail.sendKeys(email);
	}

	public void setPassword(String pass) {
		WebElement elemPass = waitForElementToBeVisible(userPassword);
		elemPass.sendKeys(pass);
	}

	public void clickLoginBtn() {
		WebElement elemLoginBtn = waitForElementToBeVisible(loginBtn);
		elemLoginBtn.click();
	}
}
