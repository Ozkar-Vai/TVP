package com.perfecto.stepdefinition;

import com.perfecto.pageObjects.BaseWeb;
import com.perfecto.pageObjects.DatosCuentaCheques;
import io.cucumber.java.en.And;
import org.apache.poi.ss.usermodel.Sheet;

public class DatosCuentaChequesSteps extends BaseWeb {

	BaseWeb base = new BaseWeb();

    DatosCuentaCheques dcc = new DatosCuentaCheques();
    CommonSteps bu;

    public DatosCuentaChequesSteps(CommonSteps bu) {
    	this.bu = bu;
    }

	public String filePath= "src//main//resources";
	public String fileName= "DataReader.xlsx";
	public String sheetName= "CuentaCheques";

	@And("^captura datos cuenta cheques '(.*?)'$")
	public void captura_datos_cuenta_cheques(int RowNum) throws Throwable {
		dcc.readExcel(filePath, fileName, sheetName);
		dcc.capturaDatosCuentaCheques(bu.getDriver(), bu.getReportiumClient(), sheetName,RowNum);
	}
}
