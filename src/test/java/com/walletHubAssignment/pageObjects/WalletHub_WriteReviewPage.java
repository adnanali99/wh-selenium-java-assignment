package com.walletHubAssignment.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walletHubAssignment.utilities.DriverHelper;

public class WalletHub_WriteReviewPage extends DriverHelper {

	WebDriver ldriver;

	public WalletHub_WriteReviewPage(WebDriver rdriver) {

		super(rdriver);
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Write Your Review Company Page Locators

	// Click on Dropdown
	@FindBy(css = ".opened .dropdown-placeholder")
	WebElement SelectDropDown;

	// Write Review Page Title
	@FindBy(xpath = "//h4[@class='wrev-prd-name']")
	WebElement writeReviewPageTitle;

	// Values of Opened Dropdown
	@FindBy(css = "div[class=\"dropdown second opened\"] li")
	List<WebElement> reviewStars;

	// Write Review Textbox
	@FindBy(xpath = "//textarea[@class='textarea wrev-user-input validate']")
	WebElement reviewTextBox;

	// Submit Btn
	@FindBy(xpath = "//div[@class='sbn-action semi-bold-font btn fixed-w-c tall']")
	WebElement submitBtn;

	// **************** Action Methods ****************

	public void clickOnDropDown() {
		WebElement dropDown = waitForElementToBeVisible(SelectDropDown);
		waitForAndClickElement(dropDown);
	}

	public void selectValueFromDropDown(String selectedValue) {
		List<WebElement> elemDropDownValues = waitForElementsToBeVisible(reviewStars);
		int count = elemDropDownValues.size();
		System.out.println("Total Count:" + count);

		for (int i = 0; i < count; i++) {
			WebElement elem = elemDropDownValues.get(i);
			String dropDownTxt = elem.getText();
			System.out.println("Dropdown Text: " + dropDownTxt);
			if (dropDownTxt.equalsIgnoreCase(selectedValue)) {
				elem.click();
				System.out.println("Clicked on: " + elem);
				return;
			} else {
				System.out.println("Dropdown is not Opened");
			}
		}
	}

	public WebElement writeReviewPageTitle() {
		WebElement elemReviewPageTitle = waitForElementToBeVisible(writeReviewPageTitle);
		return elemReviewPageTitle;
	}

	public void setReviewText(String reviewText) {
		WebElement text = waitForElementToBeVisible(reviewTextBox);
		text.sendKeys(reviewText);
	}

	public void clickSubmitBtn() {
		WebElement elemSubmitBtn = waitForElementToBeVisible(submitBtn);
		elemSubmitBtn.click();
	}

}
