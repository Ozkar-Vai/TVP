package com.perfecto.stepdefinition;

import java.io.FileReader;
import java.util.Properties;

import gherkin.formatter.model.Feature;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.perfecto.pageObjects.BaseUtility;
import com.perfecto.pageObjects.BaseWeb;
import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.sampleproject.PerfectoLabUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonSteps extends BaseWeb {
    BaseWeb base = new BaseWeb();
    BaseUtility util = new BaseUtility();
    Properties prop = new Properties();

    public static RemoteWebDriver driver;
    public static ReportiumClient reportiumClient;

    String filePath = "src//main//resources";
    String fileName = "DataReader.xlsx";
    String sheetName = "Usuarios TPV";

    @Given("^abre navegador en nube perfecto para prueba '(.*?)'$")
    public void abre_navegador_nube_perfecto(String caso) throws Throwable {
        System.out.println("=======================================================");
        System.out.println("Abre navegador en perfecto cloud");
        System.out.println("=======================================================");
        // Write code here that turns the phrase above into concrete actions
        FileReader file = new FileReader("src//main//resources//Config.properties");
        prop.load(file);
        driver = util.webDriver(prop);
        reportiumClient = PerfectoLabUtils.setReportiumClient(driver, reportiumClient); //Creates reportiumClient
        reportiumClient.testStart(caso, new TestContext("TPV")); //Starts the reportium test
        base.openBrowser(driver, prop, reportiumClient);
        System.out.println("=======================================================");
        System.out.println("Navegador perfecto cloud abierto");
        System.out.println("=======================================================");
    }

    @When("^inicia sesion en la aplicacion Genera TPV con excel '(.*?)'$")
    public void user_login_into_tpv_application_excel(int RowNum) throws Throwable {
        System.out.println("=======================================================");
        System.out.println("Inicia sesión en la aplicación Genera TPV");
        System.out.println("=======================================================");
        base.readExcel(filePath, fileName, sheetName);
        base.loginTPVwithexcel(driver, prop, reportiumClient, sheetName, RowNum);
        System.out.println("=======================================================");
        System.out.println("Sesión iniciada en la aplicación Genera TPV");
        System.out.println("=======================================================");
    }

    @Then("Click on Logout option")
    public void Click_on_Logout_option() throws Exception {
        base.ClickLogoutOption(driver, reportiumClient);
    }



    public RemoteWebDriver getDriver() {
        return driver;
    }

    public ReportiumClient getReportiumClient() {
        return reportiumClient;
    }

    public static RemoteWebDriver getRWD() {
        return driver;
    }

    public static ReportiumClient getRC() {
        return reportiumClient;
    }

    public Properties getProp() {
        return prop;
    }


}
