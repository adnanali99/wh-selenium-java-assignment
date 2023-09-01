package com.walletHubAssignment.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.walletHubAssignment.utilities.DriverHelper;

public class FacebookHomePage extends DriverHelper {
	WebDriver ldriver;

	public FacebookHomePage(WebDriver rdriver) {

		super(rdriver);
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Home Page and Published Status Post Locators

	// ********* Post Status Button on Home page ************//
	@FindBy(xpath = "//span[contains(text(),\"What's on your mind, \")]\r\n" + "")
	@CacheLookup
	WebElement postStatus;

	// ********* Post Status Button on Home page ************//
	@FindBy(css = "span[id=':r3:']")
	@CacheLookup
	WebElement popUpModalTitle;

	// ********* Enter Text in New Post Text Area ************//
	@FindBy(css = "div[role='textbox']")
	@CacheLookup
	WebElement statusTextArea;

	// ********* Post status Button ************//
	@FindBy(css = "div[aria-label='Post']")
	@CacheLookup
	WebElement postStatusBtn;

	// ********* Published Status on Home Page ************//
	@FindBy(xpath = "//div[text()='Hello World']")
	@CacheLookup
	WebElement publishedStatus;

	// ********* Home Page feeds array of posts ************//
	@FindBy(css = "div[aria-label='Actions for this post']")
	List<WebElement> postsMenu;

	// ********* Delete a Post from the Feed ************//
	@FindBy(xpath = "//span[text()='Move to Recycle bin']")
	@CacheLookup
	WebElement deletePost;

	// ********* Move to Recycle Bin Button ************//
	@FindBy(css = "div[aria-label='Move']")
	@CacheLookup
	WebElement moveToBinBtn;

	// ********* Move to Recycle Bin Dialog Title ************//
	@FindBy(xpath = "//span[text()='Move to your recycle bin?']")
	@CacheLookup
	WebElement moveToBinDialogTitle;

	// ********* User Profile Link on Home Page ************//
	@FindBy(css = "div[data-pagelet='LeftRail'] li")
	@CacheLookup
	WebElement userProfileLink;
	// List<WebElement> userProfileLink;

	// Facebook Logo on Top Right
	@FindBy(css = "a[aria-label='Facebook']")
	@CacheLookup
	WebElement facebookLogo;

	// ********* Post Deleted Confirmation Message ************//
	@FindBy(xpath = "//span[text()='Moving post to your recycle bin']")
	@CacheLookup
	WebElement postDeletedSuccessMsg;

	// Action Methods
	public WebElement getProfileUserName() {
		WebElement elemProfileLink = waitForElementToBeVisible(userProfileLink);
		return elemProfileLink;
	}

	public void clickWhatsOnYourMindBtn() {
		WebElement elemWhatsOnYourMindBtn = waitForElementToBeVisible(postStatus);
		elemWhatsOnYourMindBtn.click();
	}

	public void clickFacebookLogo() {
		WebElement elemFacebookLogo = waitForElementToBeVisible(facebookLogo);
		elemFacebookLogo.click();
	}

	public WebElement getPopUpModalTitle() {
		WebElement elemPopUpModalTitle = waitForElementToBeVisible(popUpModalTitle);
		return elemPopUpModalTitle;
	}

	public void setStatus(String statusText) {
		WebElement elemStatus = waitForElementToBeVisible(statusTextArea);
		elemStatus.click();
		elemStatus.sendKeys(statusText);
	}

	public void clickPostBtn() {
		WebElement elemPostBtn = waitForElementToBeVisible(postStatusBtn);
		elemPostBtn.click();
	}

	public WebElement checkPublishedStatus() {
		WebElement elemPublishedStatus = waitForElementToBeVisible(publishedStatus);
		return elemPublishedStatus;
	}

	// Click on the Menu icon of the First Post i\on the Feed
	public void clickPostMenu() {
		List<WebElement> elemPostMenu = waitForElementsToBeVisible(postsMenu);
//		int totalPosts = elemPostMenu.size();
//		System.out.println("Total Size:"+totalPosts);
		if (!elemPostMenu.isEmpty()) {
			WebElement firstPostMenu = elemPostMenu.get(0);
			firstPostMenu.click();
		} else {
			System.out.println("There is no visible elements found");
		}
	}

	// Delete a post from the Feed
	public void deletePost() {
		;
		WebElement elemMoveToRB = waitForElementToBeVisible(deletePost);

		// Scroll to the element to the view and click on it
		scrollToElement(elemMoveToRB);
		elemMoveToRB.click();

		waitForElementToBeVisible(moveToBinDialogTitle);
		WebElement elemMoveToBinBtn = waitForElementToBeVisible(moveToBinBtn);
		elemMoveToBinBtn.click();

		WebElement elemPostDeletedSuccessMsg = waitForElementToBeVisible(postDeletedSuccessMsg);

		// Check for the Post Successfully Deleted Message
		String message = elemPostDeletedSuccessMsg.getText();
		System.out.println("Success Message: " + message);
		if (message.equalsIgnoreCase("Moving post to your recycle bin")) {
			Assert.assertTrue(true, "Post deleted successfully");
		} else {
			Assert.assertTrue(false, "Post is not deleted");
		}
	}
}
