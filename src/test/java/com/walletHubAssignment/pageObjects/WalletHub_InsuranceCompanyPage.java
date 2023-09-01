package com.walletHubAssignment.pageObjects;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.walletHubAssignment.utilities.DriverHelper;

public class WalletHub_InsuranceCompanyPage extends DriverHelper {

	WebDriver ldriver;

	public WalletHub_InsuranceCompanyPage(WebDriver rdriver) {

		super(rdriver);
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Insurance Company Page Locators

	// My Wallet Link After Logging In
	@FindBy(xpath = "//h1[@class='profile-name']")
	@CacheLookup
	WebElement insurancePageTitle;

	// *********Array of 5 Review Stars Locators ************//
	@FindBy(css = "div[class=\"rating-box-wrapper\"] svg[width=\"38\"]")

	List<WebElement> reviewStars;

	// *********Array of 5 Review Stars Locators ************//
	@FindBy(css = ".rv > .rvs-svg .rvs-star-svg:nth-child(4) path:nth-child(1)")

	WebElement forthStar;

	// Over Ratings Score - To Scroll to the Element
	@FindBy(css = "div[class=\"rvtab-wh-badge\"]")
	@CacheLookup
	WebElement ratingScore;

	// **************** Action Methods ****************

	public void ScrollToRatingsSection() {
		WebElement rating = waitForElementToBeVisible(ratingScore);
		scrollToElement(rating);
	}

	public void hoverAndClickOnForthStar() throws InterruptedException {

		try {
			List<WebElement> elemStars = waitForElementsToBeVisible(reviewStars);

			int totalStars = elemStars.size();
			System.out.println("Total Count:" + totalStars);
			if (totalStars >= 5) {
				System.out.println("inside if");
				Actions actions = new Actions(ldriver);
				for (int i = 0; i < totalStars; i++) {
					System.out.println("inside for");
					WebElement singleStar = elemStars.get(i);
					if (i == 3) {
						WebElement forthStarIndex = elemStars.get(3);
						actions.moveToElement(forthStarIndex).perform();

						Thread.sleep(5000);
						WebElement forthStarElem = waitForElementToBeVisible(forthStar);

						System.out.println("Element is:" + forthStarElem);
						forthStarElem.click();

						Thread.sleep(5000);

					}
					actions.moveToElement(singleStar).perform();
				}

			} else {
				System.out.println("Starts are not equal to 5");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("StaleElementReferenceException occurred. Handling the exception.");
		}

	}

	public WebElement elemPageTitle() {
		WebElement elemPageTitle = waitForElementToBeVisible(insurancePageTitle);
		return elemPageTitle;
	}

}
