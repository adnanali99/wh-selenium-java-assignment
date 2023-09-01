package com.walletHubAssignment.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.walletHubAssignment.pageObjects.WalletHub_HomePage;
import com.walletHubAssignment.pageObjects.WalletHub_InsuranceCompanyPage;
import com.walletHubAssignment.pageObjects.WalletHub_LoginPage;
import com.walletHubAssignment.pageObjects.WalletHub_ProfilePage;
import com.walletHubAssignment.pageObjects.WalletHub_WriteReviewPage;
import com.walletHubAssignment.utilities.DriverHelper;
import com.github.javafaker.Faker;

public class TC_001_WH_CompanyReview extends CommonClass {

	@Test
	public void ReviewACompany() throws InterruptedException {

		DriverHelper helper = new DriverHelper(driver);
		Faker faker = new Faker();

		// Generate 210 Random Characters
		String fReviewText = faker.lorem().characters(210);

		driver.get(WH_BaseURL);
		logger.info("URL is opened");

		// Creating Objects for WalletHub Login and Home and Profile Pages
		WalletHub_LoginPage WHLoginPageObj = new WalletHub_LoginPage(driver);
		WalletHub_HomePage WHHomePageObj = new WalletHub_HomePage(driver);
		WalletHub_InsuranceCompanyPage WHInsuranceCompanyPageObj = new WalletHub_InsuranceCompanyPage(driver);
		WalletHub_WriteReviewPage WHWriteReviewPageObj = new WalletHub_WriteReviewPage(driver);
		WalletHub_ProfilePage WHProfilePageObj = new WalletHub_ProfilePage(driver);

		// Test Steps
		WHLoginPageObj.clickLoginTab();
		WHLoginPageObj.setEmail(WH_userEmail);
		WHLoginPageObj.setPassword(WH_userPassword);
		logger.info("Entered email and pasword");

		WHLoginPageObj.clickLoginBtn();
		logger.info("Clicked on the Login button");

		helper.assertPageTitle(WHHomePageObj.getMyWallet(), WH_myWallet);
		logger.info("I am on the WalletHub Home Page");

		driver.get(WH_profileURL);
		logger.info("Redirecting to WalletHub Profile Page");

		helper.assertPageTitle(WHInsuranceCompanyPageObj.elemPageTitle(), WH_CompanyPageTitle);
		logger.info("I am on Insurance Company Page");

		WHInsuranceCompanyPageObj.ScrollToRatingsSection();
		WHInsuranceCompanyPageObj.hoverAndClickOnForthStar();
		logger.info("In Review Stars Section");

		helper.assertPageTitle(WHWriteReviewPageObj.writeReviewPageTitle(), WH_CompanyPageTitle);
		WHWriteReviewPageObj.clickOnDropDown();
		Thread.sleep(3000);
		WHWriteReviewPageObj.selectValueFromDropDown("Health Insurance");
		logger.info("Clicked on Dropdown");

		WHWriteReviewPageObj.setReviewText(fReviewText);
		WHWriteReviewPageObj.clickSubmitBtn();
		logger.info("Entered Review Text and Clicked on Submit");
		Thread.sleep(8000);

		driver.get(WH_profilePageURL);
		logger.info("Redirected to My WalletHub Profile Page");

		logger.info("Checking if Review exists on My Profile");
		Assert.assertEquals(WHProfilePageObj.CheckReviewExists(), true);

	}

}
