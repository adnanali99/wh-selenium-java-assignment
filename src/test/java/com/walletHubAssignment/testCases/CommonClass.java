package com.walletHubAssignment.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.walletHubAssignment.utilities.ReadConfig;

public class CommonClass {

	ReadConfig config = new ReadConfig();

	// Properties for Facebook Application
	public String facebookURL = config.getFacebookURL();
	public String userEmail = config.getFacebookEmail();
	public String userPassword = config.getFacebookPassword();
	public String facebookHomePageTitle = config.getFacebookHomePageTitle();
	public String expectedFbProfileName = config.getFacebookProfileName();

	// Properties for WalletHub Application
	public String WH_BaseURL = config.getWHBaseURL();
	public String WH_userEmail = config.getWH_userEmail();
	public String WH_userPassword = config.getWH_userPassword();
	public String WH_profileURL = config.getWH_profileURL();
	public String WH_CompanyPageTitle = config.getWH_CompanyPageTitle();
	public String WH_myWallet = config.getWH_myWallet();
	public String WH_profilePageURL = config.getWH_ProfilePageURL();

	public static WebDriver driver;

	public static Logger logger;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", config.getChromeDriverPath());
		ChromeOptions options = new ChromeOptions();
		options.setBinary(
				"C:\\Users\\AdnanShafiq\\eclipse-workspace\\walletHubAssignmentV1\\Drivers\\chrome-win64\\chrome.exe");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		logger = Logger.getLogger("Facebook");
		PropertyConfigurator.configure("Log4j.properties");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
