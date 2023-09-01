package com.walletHubAssignment.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.walletHubAssignment.utilities.DriverHelper;

public class WalletHub_HomePage extends DriverHelper {
	WebDriver ldriver;

	public WalletHub_HomePage(WebDriver rdriver) {

		super(rdriver);
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Wallet Hub Home Page Locators

	// My Wallet Link After Logging In
	@FindBy(xpath = "//a[.='My Wallet']")
	@CacheLookup
	WebElement myWalletLink;

	// **************** Action Methods ****************

	public WebElement getMyWallet() {
		WebElement elemMyWallet = waitForElementToBeVisible(myWalletLink);
		return elemMyWallet;
	}
}
