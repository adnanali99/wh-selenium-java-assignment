package com.walletHubAssignment.pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walletHubAssignment.utilities.DriverHelper;

public class WalletHub_ProfilePage extends DriverHelper {
	WebDriver ldriver;

	public WalletHub_ProfilePage(WebDriver rdriver) {

		super(rdriver);
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Profile Page Locators

	// Review Link
	@FindBy(xpath = "//a[.='Test Insurance Company']")
	WebElement myReview;

	// **************** Action Methods ****************

	// Check if the review is there
	public Boolean CheckReviewExists() {
		try {
			WebElement review = waitForElementToBeVisible(myReview);
			return review != null;
		} catch (NoSuchElementException | TimeoutException e) {
			return false;
		}
	}
}
