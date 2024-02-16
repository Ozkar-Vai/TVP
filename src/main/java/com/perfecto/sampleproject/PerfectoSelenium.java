package com.perfecto.sampleproject;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResult;
import com.perfecto.reportium.test.result.TestResultFactory;


public class PerfectoSelenium {
	RemoteWebDriver driver;
	ReportiumClient reportiumClient;
	//Replace <<cloud name>> with your perfecto cloud name (e.g. testingcloud ) or pass it as maven properties: -DcloudName=<<cloud name>>
	String cloudName = "banorte";
	
	//Replace <<security token>> with your perfecto security token or pass it as maven properties: -DsecurityToken=<<SECURITY TOKEN>>  More info: https://developers.perfectomobile.com/display/PD/Generate+security+tokens
	String securityToken = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICIxMWNkZTNkOS03ZDkxLTQ0ZjYtOGU1Mi1lMDFhMTYyNmM1YjgifQ.eyJpYXQiOjE2OTE2MDI2ODcsImp0aSI6IjMzY2FmYjdlLWJlMjgtNDdiMi04MGQxLTBlYTYxYjc5NzVmNSIsImlzcyI6Imh0dHBzOi8vYXV0aDYucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2Jhbm9ydGUtcGVyZmVjdG9tb2JpbGUtY29tIiwiYXVkIjoiaHR0cHM6Ly9hdXRoNi5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvYmFub3J0ZS1wZXJmZWN0b21vYmlsZS1jb20iLCJzdWIiOiJjM2Y2NThhMC1hMTg1LTRmOWItYTllMS00NmFiMWFhZTc3YTkiLCJ0eXAiOiJPZmZsaW5lIiwiYXpwIjoib2ZmbGluZS10b2tlbi1nZW5lcmF0b3IiLCJub25jZSI6ImRjY2E2NjY4LTFlZGUtNGE0NC1hZGUzLThmZTM2ZjY5Mjc1NyIsInNlc3Npb25fc3RhdGUiOiI0OGRkZmI3MC1mM2VkLTQ5ZjQtYWEzMC05Y2I1NTI0NThjMzciLCJzY29wZSI6Im9wZW5pZCBlbWFpbCBwcm9maWxlIG9mZmxpbmVfYWNjZXNzIn0.F3wIzpldfExFpCxqk_KYOxYuADaoX4-KTn4nRfhDWR0";

	@Test
	public void androidTest() throws Exception {
		//Mobile: Auto generate capabilities for device selection: https://developers.perfectomobile.com/display/PD/Select+a+device+for+manual+testing#Selectadeviceformanualtesting-genCapGeneratecapabilities
		String browserName = "mobileOS";
		DesiredCapabilities capabilities = new DesiredCapabilities(browserName, "", Platform.ANY);
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("useAppiumForWeb", true);
		capabilities.setCapability("openDeviceTimeout", 2);

		// The below capability is mandatory. Please do not replace it.
		capabilities.setCapability("securityToken", PerfectoLabUtils.fetchSecurityToken(securityToken));
				
		driver = new RemoteWebDriver(new URL("https://" + PerfectoLabUtils.fetchCloudName(cloudName) + ".perfectomobile.com/nexperience/perfectomobile/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

		reportiumClient = PerfectoLabUtils.setReportiumClient(driver, reportiumClient); //Creates reportiumClient
		reportiumClient.testStart("Perfecto Android mobile web test", new TestContext("tag2", "tag3")); //Starts the reportium test
		reportiumClient.stepStart("browser navigate to perfecto"); //Starts a reportium step
		driver.get("https://www.perfecto.io");
		reportiumClient.stepEnd();

		reportiumClient.stepStart("Verify title");
		String aTitle = driver.getTitle();
		PerfectoLabUtils.assertTitle(aTitle, reportiumClient); //compare the actual title with the expected title
		reportiumClient.stepEnd();
	}
	
	@Test
	public void iOSTest() throws Exception {
		//Mobile: Auto generate capabilities for device selection: https://developers.perfectomobile.com/display/PD/Select+a+device+for+manual+testing#Selectadeviceformanualtesting-genCapGeneratecapabilities
		// browserName should be set to safari by default to open safari browser.
		String browserName = "safari";
		DesiredCapabilities capabilities = new DesiredCapabilities(browserName, "", Platform.ANY);
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("model", "iPhone.*");
		capabilities.setCapability("deviceStatus", "CONNECTED");
		capabilities.setCapability("openDeviceTimeout", 2);

		// The below capability is mandatory. Please do not replace it.
		capabilities.setCapability("securityToken", PerfectoLabUtils.fetchSecurityToken(securityToken));
				
		driver = new RemoteWebDriver(new URL("https://" + PerfectoLabUtils.fetchCloudName(cloudName) + ".perfectomobile.com/nexperience/perfectomobile/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

		reportiumClient = PerfectoLabUtils.setReportiumClient(driver, reportiumClient); //Creates reportiumClient
		reportiumClient.testStart("Perfecto iOS mobile web test", new TestContext("tag2", "tag3")); //Starts the reportium test
		reportiumClient.stepStart("browser navigate to perfecto"); //Starts a reportium step
		driver.get("https://www.perfecto.io");
		reportiumClient.stepEnd();

		reportiumClient.stepStart("Verify title");
		String aTitle = driver.getTitle();
		PerfectoLabUtils.assertTitle(aTitle, reportiumClient); //compare the actual title with the expected title
		reportiumClient.stepEnd();
	}

	@Test
	public void webTest() throws Exception {
		//Web: Make sure to Auto generate capabilities for device selection: https://developers.perfectomobile.com/display/PD/Select+a+device+for+manual+testing#Selectadeviceformanualtesting-genCapGeneratecapabilities
		DesiredCapabilities capabilities = new DesiredCapabilities("", "", Platform.ANY);
		capabilities.setCapability("platformName", "Windows");
		capabilities.setCapability("platformVersion", "10");
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("browserVersion", "latest");
		capabilities.setCapability("location", "US East");
		capabilities.setCapability("resolution", "1024x768");

		// The below capability is mandatory. Please do not replace it.
		capabilities.setCapability("securityToken", PerfectoLabUtils.fetchSecurityToken(securityToken));
		
		driver = new RemoteWebDriver(new URL("https://" + "banorte" + ".perfectomobile.com/nexperience/perfectomobile/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

		reportiumClient = PerfectoLabUtils.setReportiumClient(driver, reportiumClient); //Creates reportiumClient
		reportiumClient.testStart("Perfecto desktop web test", new TestContext("tag2", "tag3")); //Starts the reportium test
		reportiumClient.stepStart("browser navigate to perfecto"); //Starts a reportium step
		driver.get("https://www.perfecto.io");
		reportiumClient.stepEnd();

		reportiumClient.stepStart("Verify title");
		String aTitle = driver.getTitle();
		PerfectoLabUtils.assertTitle(aTitle, reportiumClient); //compare the actual title with the expected title
		reportiumClient.stepEnd();
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		//STOP TEST
		TestResult testResult = null;

		if(result.getStatus() == result.SUCCESS) {
			testResult = TestResultFactory.createSuccess();
		}
		else if (result.getStatus() == result.FAILURE) {
			testResult = TestResultFactory.createFailure(result.getThrowable());
		}
		reportiumClient.testStop(testResult);

		driver.close();
		driver.quit();
		// Retrieve the URL to the DigitalZoom Report 
		String reportURL = reportiumClient.getReportUrl();
		System.out.println(reportURL);
	}
}

