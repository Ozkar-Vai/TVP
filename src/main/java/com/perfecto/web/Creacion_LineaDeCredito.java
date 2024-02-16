package com.perfecto.web;

import java.io.FileReader;
import java.util.Properties;
import com.perfecto.sampleproject.PerfectoLabUtils;
import com.perfecto.pageObjects.BaseWeb;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResult;
import com.perfecto.reportium.test.result.TestResultFactory;

public class Creacion_LineaDeCredito {
    BaseWeb base = new BaseWeb();
    RemoteWebDriver driver;
    ReportiumClient reportiumClient;
   // Lineadecredito lc = new Lineadecredito();
    Properties prop = new Properties();
    
       
    @Test
    public void CreationOfCreditLine() throws Throwable{
        //Web: Make sure to Auto generate capabilities for device selection: https://developers.perfectomobile.com/display/PD/Select+a+device+for+manual+testing#Selectadeviceformanualtesting-genCapGeneratecapabilities
    	FileReader file = new FileReader("src//main//resources//Config.properties");
    	prop.load(file);
    	driver = base.webDriver(prop);
        reportiumClient = PerfectoLabUtils.setReportiumClient(driver, reportiumClient); //Creates reportiumClient
        reportiumClient.testStart("Web Test - SICRED", new TestContext("Ejemplo")); //Starts the reportium test        
        //Hacer Login
        //base.loginSICRED(driver, prop, reportiumClient);
        //base.searchFolio(driver,reportiumClient,69678);
        //base.clickSearchIcon(driver, reportiumClient);
        //base.selectFolio(driver,reportiumClient, 69678);
        //base.clickInformationTab(driver, reportiumClient);
        //base.clickSolicitudTab(driver, reportiumClient);
        //lc.getLineasAddedList(driver, reportiumClient);
       /* lc.clickLineaNuevaOption(driver, reportiumClient);
//        lc.enterGeneralDetails(driver, reportiumClient,"Global client");
//        lc.enterTermsAndCondition(driver, reportiumClient,"Global client");
//        lc.selectSpecializedCreditOptions(driver, reportiumClient, "Agropecuario&Inmobiliario&Turismo");
//        lc.selectSumarioDeTérminos(driver, reportiumClient, "yes");
        lc.clickSaveButton(driver, reportiumClient);
        lc.clickAcceptButton(driver, reportiumClient);
       // lc.getAddedListAfterLineaCreated(driver, reportiumClient);

        */
    }
    
    //@Test
    public void verificationOfFirmaMancomunadaFieldsBasedOnTipoDeLineaAndTipoDeCreditoSelection() throws Throwable{
        //Web: Make sure to Auto generate capabilities for device selection: https://developers.perfectomobile.com/display/PD/Select+a+device+for+manual+testing#Selectadeviceformanualtesting-genCapGeneratecapabilities
    	FileReader file = new FileReader("src//main//resources//Config.properties");
    	prop.load(file);
    	driver = base.webDriver(prop);
        reportiumClient = PerfectoLabUtils.setReportiumClient(driver, reportiumClient); //Creates reportiumClient
        reportiumClient.testStart("Web Test - SICRED", new TestContext("Ejemplo")); //Starts the reportium test        
        //Hacer Login
        //base.loginSICRED(driver, prop, reportiumClient);
        //base.searchFolio(driver,reportiumClient,69678);
        //base.clickSearchIcon(driver, reportiumClient);
        //base.selectFolio(driver,reportiumClient, 69678);
        //base.clickInformationTab(driver, reportiumClient);
        //base.clickSolicitudTab(driver, reportiumClient);
        //lc.clickLineaNuevaOption(driver, reportiumClient);
//        lc.verifyFirmaMancomunadaFields(driver, reportiumClient, "No Revolvente (Simple)", "ACCC");
//        lc.verifyFirmaMancomunadaFields(driver, reportiumClient, "Revolvente", "ACS");
//        lc.verifyFirmaMancomunadaFields(driver, reportiumClient, "No Revolvente (Simple)", "COM/INV");
//        lc.verifyFirmaMancomunadaFields(driver, reportiumClient, "Revolvente", "ARREND F");
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
