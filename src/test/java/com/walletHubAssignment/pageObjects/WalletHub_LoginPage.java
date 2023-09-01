package com.walletHubAssignment.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walletHubAssignment.utilities.DriverHelper;

public class WalletHub_LoginPage extends DriverHelper {

	WebDriver ldriver;

	public WalletHub_LoginPage(WebDriver rdriver) {

		super(rdriver);
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// WalletHub Login Page Locators

	// *********Login Tab ************//
	@FindBy(css = "[ng-click='switch_tab(\\'login\\');']")
	@CacheLookup
	WebElement loginTab;

	// *********Email Field ************//
	@FindBy(css = "input[placeholder=\"Email Address\"]")
	@CacheLookup
	WebElement userEmail;

	// *********Password Field ************//
	@FindBy(css = "input[placeholder=\"Password\"]")
	@CacheLookup
	WebElement userPassword;

	// *********Login Button ************//
	@FindBy(css = "[type='button']")
	@CacheLookup
	WebElement loginBtn;

	// Action Methods for WalletHub Login Page

	public void clickLoginTab() {
		WebElement elemLoginLink = waitForElementToBeVisible(loginTab);
		elemLoginLink.click();
	}

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
