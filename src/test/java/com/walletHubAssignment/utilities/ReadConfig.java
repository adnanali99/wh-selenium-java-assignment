package com.walletHubAssignment.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties property;

	public ReadConfig() {

		// Create Instance of the config File and Load it into the FileInputStream
		File sourceFile = new File("./Configuration/config.properties");

		try {
			FileInputStream fileInputStream = new FileInputStream(sourceFile);
			property = new Properties();
			property.load(fileInputStream);
		} catch (Exception e) {
			System.out.println("Error is: " + e.getMessage());
		}
	}

	// ********** Action Methods for FaceBook Properties **********

	public String getFacebookURL() {
		String url = property.getProperty("facebookURL");
		return url;
	}

	public String getFacebookEmail() {
		String email = property.getProperty("userEmail");
		return email;
	}

	public String getFacebookPassword() {
		String pass = property.getProperty("userPassword");
		return pass;
	}

	public String getFacebookHomePageTitle() {
		String FBHomepageTitle = property.getProperty("facebookHomePageTitle");
		return FBHomepageTitle;
	}

	public String getFacebookProfileName() {
		String profileName = property.getProperty("expectedFbProfileName");
		return profileName;
	}

	public String getChromeDriverPath() {
		String chromePath = property.getProperty("chromeDriverPath");
		return chromePath;
	}

	// ********** Action Methods for WalletHub Properties **********

	public String getWHBaseURL() {
		String url = property.getProperty("WH_BaseURL");
		return url;
	}

	public String getWH_userEmail() {
		String email = property.getProperty("WH_userEmail");
		return email;
	}

	public String getWH_userPassword() {
		String pass = property.getProperty("WH_userPassword");
		return pass;
	}

	public String getWH_profileURL() {
		String url = property.getProperty("WH_profileURL");
		return url;
	}

	public String getWH_CompanyPageTitle() {
		String title = property.getProperty("WH_CompanyPageTitle");
		return title;
	}

	public String getWH_myWallet() {
		String myWallet = property.getProperty("WH_myWallet");
		return myWallet;
	}

	public String getWH_ProfilePageURL() {
		String profileURL = property.getProperty("WH_profilePageURL");
		return profileURL;
	}
}
