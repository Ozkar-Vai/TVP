package com.perfecto.runner;

import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.perfecto.reportium.test.result.TestResult;
import com.perfecto.reportium.test.result.TestResultFactory;
import com.perfecto.stepdefinition.CommonSteps;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import java.io.IOException;

import static com.perfecto.stepdefinition.CommonSteps.driver;
import static com.perfecto.stepdefinition.CommonSteps.reportiumClient;

//@RunWith(Cucumber.class) 
@CucumberOptions(tags="@Busqueda_Cliente_PM_CP05", features = "src/main/resources/Features/Test_TPV.feature",
glue= {"com.perfecto.stepdefinition"})


public class webRunner extends AbstractTestNGCucumberTests {

	String filePath = "src//main//resources";
	String fileName = "DataReader.xlsx";
	String sheetName = "Usuarios TPV";

	int rowNum = 4;

	int colResult= 3;
	int colURL= 4;
	int colResultFailure = 5;


	@BeforeMethod
	public void beforeMethod() throws Exception {  
		System.out.println("Ejecución del script iniciada");
	} 

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		//STOP TEST
		System.out.println("Informe de la ejecución...");
		CommonSteps.getRC().stepStart("La prueba terminó con la captura de pantalla");
		CommonSteps.getRWD().getScreenshotAs(OutputType.BYTES);
		CommonSteps.getRC();
		TestResult testResult = null;
		if(result.getStatus() == result.SUCCESS) {
			testResult = TestResultFactory.createSuccess();
		}
		else if (result.getStatus() == result.FAILURE) {
			testResult = TestResultFactory.createFailure(result.getThrowable());
		}
		CommonSteps.getRC().testStop(testResult);
		// Retrieve the URL to the DigitalZoom Report
		String reportURL = CommonSteps.getRC().getReportUrl();
		CommonSteps.getRWD().close();
		CommonSteps.getRWD().quit();

		System.out.println(reportURL);

		CommonSteps.writeData(filePath, fileName, sheetName, rowNum, colURL, reportURL);
		CommonSteps.writeData(filePath, fileName, sheetName, rowNum, colResult, String.valueOf(result).substring(36,43));
		CommonSteps.writeData(filePath, fileName, sheetName, rowNum, colResultFailure, String.valueOf(result.getThrowable()));

	}

}

