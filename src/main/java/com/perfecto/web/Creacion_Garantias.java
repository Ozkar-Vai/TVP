package com.perfecto.web;

import java.util.Properties;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.pageObjects.BaseWeb;

public class Creacion_Garantias {
	
	BaseWeb base = new BaseWeb();
    RemoteWebDriver driver;
    ReportiumClient reportiumClient;
    Properties prop = new Properties();
   // Garantias ga = new Garantias();
    
       /*
    //@Test
    public void CreationOfRealHipotecariaGarantias() throws Throwable{
        //Web: Make sure to Auto generate capabilities for device selection: https://developers.perfectomobile.com/display/PD/Select+a+device+for+manual+testing#Selectadeviceformanualtesting-genCapGeneratecapabilities
    	FileReader file = new FileReader("src//main//resources//Config.properties");
    	prop.load(file);
    	driver = base.webDriver(prop);
        reportiumClient = PerfectoLabUtils.setReportiumClient(driver, reportiumClient); //Creates reportiumClient
        reportiumClient.testStart("SICRED - Creacion de Garantias", new TestContext("Garantias")); //Starts the reportium test        
        //Hacer Login
        base.loginSICRED(driver, prop, reportiumClient);
        base.searchFolio(driver,reportiumClient,69678);
        base.clickSearchIcon(driver, reportiumClient);
        base.selectFolio(driver,reportiumClient, 69678);        
        base.clickInformationTab(driver, reportiumClient);  
        ga.getRazonSocialDetailsFromClientInfo(driver, reportiumClient);
        ga.selectDomicilo(driver, reportiumClient);
        ga.getCalleInfo(driver, reportiumClient);
        ga.getEstadoInfo(driver, reportiumClient);
        ga.getMunicipioInfo(driver, reportiumClient);
        ga.getNumeroExteriorInfo(driver, reportiumClient);
        ga.getpostalCodeInfo(driver, reportiumClient);
        ga.getTipoDePersona(driver, reportiumClient);
        base.clickSolicitudTab(driver, reportiumClient);  
        ga.clickGarantaisTab(driver, reportiumClient);

      //  ga.enterGarantiasDetails(driver, reportiumClient, "Hipotecaria","Real",ga.getRazonSocialDetailsFromClientInfo(driver,reportiumClient),
      //  		ga.getCalleInfo(driver, reportiumClient),ga.getNumeroExteriorInfo(driver, reportiumClient),
      //  		ga.getpostalCodeInfo(driver, reportiumClient),ga.getTipoDePersona(driver, reportiumClient),
      //  		ga.getEstadoInfo(driver, reportiumClient),ga.getMunicipioInfo(driver, reportiumClient));
        
        ga.clickGuardarGarantias(driver, reportiumClient);
        ga.clickAceptarGarantias(driver, reportiumClient);
        ga.clickAgainAceptar(driver, reportiumClient);
    }
    
   // @Test
    public void CreationOfRealPrendariaGarantias() throws Throwable{
        //Web: Make sure to Auto generate capabilities for device selection: https://developers.perfectomobile.com/display/PD/Select+a+device+for+manual+testing#Selectadeviceformanualtesting-genCapGeneratecapabilities
    	FileReader file = new FileReader("src//main//resources//Config.properties");
    	prop.load(file);
    	driver = base.webDriver(prop);
        reportiumClient = PerfectoLabUtils.setReportiumClient(driver, reportiumClient); //Creates reportiumClient
        reportiumClient.testStart("SICRED - Creacion de Garantias", new TestContext("Garantias")); //Starts the reportium test        
        //Hacer Login
        base.loginSICRED(driver, prop, reportiumClient);
        base.searchFolio(driver,reportiumClient,69678);
        base.clickSearchIcon(driver, reportiumClient);
        base.selectFolio(driver,reportiumClient, 69678);        
        base.clickInformationTab(driver, reportiumClient);  
        ga.getRazonSocialDetailsFromClientInfo(driver, reportiumClient);
        ga.selectDomicilo(driver, reportiumClient);
        ga.getCalleInfo(driver, reportiumClient);
        ga.getEstadoInfo(driver, reportiumClient);
        ga.getMunicipioInfo(driver, reportiumClient);
        ga.getNumeroExteriorInfo(driver, reportiumClient);
        ga.getpostalCodeInfo(driver, reportiumClient);
        ga.getTipoDePersona(driver, reportiumClient);
        base.clickSolicitudTab(driver, reportiumClient);
       // ga.getGuarantiasAddedList(driver, reportiumClient);
        ga.clickGarantaisTab(driver, reportiumClient);
       // ga.enterGarantiasDetails(driver, reportiumClient, "Prendaria","Real",ga.getRazonSocialDetailsFromClientInfo(driver,reportiumClient),
//        		ga.getCalleInfo(driver, reportiumClient),ga.getNumeroExteriorInfo(driver, reportiumClient),
//      //  		ga.getpostalCodeInfo(driver, reportiumClient),ga.getTipoDePersona(driver, reportiumClient),
//        		ga.getEstadoInfo(driver, reportiumClient),ga.getMunicipioInfo(driver, reportiumClient));
//        
        ga.clickGuardarGarantias(driver, reportiumClient);
        ga.clickAceptarGarantias(driver, reportiumClient);
        ga.clickAgainAceptar(driver, reportiumClient);
       // ga.getGuarantiasAddedListAfterGarantiaCreated(driver, reportiumClient);
    }
    
  @Test
    public void CreationOfPersonalAvalGarantias() throws Throwable{
        //Web: Make sure to Auto generate capabilities for device selection: https://developers.perfectomobile.com/display/PD/Select+a+device+for+manual+testing#Selectadeviceformanualtesting-genCapGeneratecapabilities
    	FileReader file = new FileReader("src//main//resources//Config.properties");
    	prop.load(file);
    	driver = base.webDriver(prop);
        reportiumClient = PerfectoLabUtils.setReportiumClient(driver, reportiumClient); //Creates reportiumClient
        reportiumClient.testStart("SICRED - Creacion de Garantias", new TestContext("Garantias")); //Starts the reportium test        
        //Hacer Login
        base.loginSICRED(driver, prop, reportiumClient);
        base.searchFolio(driver,reportiumClient,69678);
        base.clickSearchIcon(driver, reportiumClient);
        base.selectFolio(driver,reportiumClient, 69678);        
        base.clickInformationTab(driver, reportiumClient);  
        base.clickSolicitudTab(driver, reportiumClient);
       // ga.getGuarantiasAddedList(driver, reportiumClient);
        ga.clickGarantaisTab(driver, reportiumClient);
//        ga.enterGarantiasDetails(driver, reportiumClient, "Aval","Personal",ga.getRazonSocialDetailsFromClientInfo(driver,reportiumClient),
//        		ga.getCalleInfo(driver, reportiumClient),ga.getNumeroExteriorInfo(driver, reportiumClient),
//        		ga.getpostalCodeInfo(driver, reportiumClient),ga.getTipoDePersona(driver, reportiumClient),
//        		ga.getEstadoInfo(driver, reportiumClient),ga.getMunicipioInfo(driver, reportiumClient));
//        
        ga.clickGuardarGarantias(driver, reportiumClient);
        ga.clickAceptarGarantias(driver, reportiumClient);
        ga.clickAgainAceptar(driver, reportiumClient);
       // ga.getGuarantiasAddedListAfterGarantiaCreated(driver, reportiumClient);
    }
    
 // @Test
    public void AssignGuarantiaToLines() throws Throwable{
    	FileReader file = new FileReader("src//main//resources//Config.properties");
    	prop.load(file);
    	driver = base.webDriver(prop);
        reportiumClient = PerfectoLabUtils.setReportiumClient(driver, reportiumClient); //Creates reportiumClient
        reportiumClient.testStart("SICRED - Creacion de Garantias", new TestContext("Garantias")); //Starts the reportium test        
        //Hacer Login
        base.loginSICRED(driver, prop, reportiumClient);
        base.searchFolio(driver,reportiumClient,69678);
        base.clickSearchIcon(driver, reportiumClient);
        base.selectFolio(driver,reportiumClient, 69678);        
        base.clickInformationTab(driver, reportiumClient);  
        base.clickSolicitudTab(driver, reportiumClient);
        ga.assignGuarantiasToList(driver, reportiumClient);
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
*/

}