package com.walletHubAssignment.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.walletHubAssignment.pageObjects.FacebookHomePage;
import com.walletHubAssignment.pageObjects.FacebookLoginPage;

public class TC_FacebookLogin_001 extends CommonClass {

	@Test
	public void facebookLoginTest() {

		/*
		 *** TEST CASE STEPS*** Login to Facebook. Post a New Status and validate that new
		 * status is Published Once Published, Click on the 3 dotted menu icon on the
		 * Post and Delete the Post and Validate that Post is successfully removed from
		 * the Feeds
		 */

		driver.get(facebookURL);
		logger.info("URL is opened");

		// Creating Objects for Facebook Login and Home Pages
		FacebookLoginPage fbLoginPageObj = new FacebookLoginPage(driver);
		FacebookHomePage fbHomePageObj = new FacebookHomePage(driver);

		// Test Steps
		fbLoginPageObj.setEmail(userEmail);
		fbLoginPageObj.setPassword(userPassword);
		logger.info("Entered email and pasword");

		fbLoginPageObj.clickLoginBtn();
		logger.info("Clicked on the Login button");

		// Getting Profile Name Text that will later be Asserted with the Expected Text
		String profileName = fbHomePageObj.getProfileUserName().getText();
		System.out.println("Profile Name is: " + profileName);

		String pageURL = driver.getCurrentUrl();
		if (pageURL != facebookURL) {
			fbHomePageObj.clickFacebookLogo();
		}

		// Check If User is Landed on the Correct Page after Login
		if (driver.getTitle().equals(facebookHomePageTitle)) {
			Assert.assertTrue(true, "Correct Page Title");
			Assert.assertEquals(expectedFbProfileName, profileName);
			logger.info("User is on the Homepage");
		} else {
			Assert.assertTrue(false, "Incorrect Page Title");
			logger.info("User is not logged in");
		}

		fbHomePageObj.clickWhatsOnYourMindBtn();
		logger.info("Cllicked Post New Status Button on Home Page");

		fbHomePageObj.setStatus("Hello World");
		logger.info("Entered Text: Hello World");

		fbHomePageObj.clickPostBtn();
		logger.info("Clicked on the Post button");

		fbHomePageObj.checkPublishedStatus();
		logger.info("New Status is Published on the Feed");

		fbHomePageObj.clickPostMenu();
		logger.info("Clicked on 3 Dot Menu Button on the Post");

		fbHomePageObj.deletePost();
		logger.info("Post is Deleted");
	}
}
