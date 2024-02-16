package com.perfecto.stepdefinition;

import com.perfecto.pageObjects.BaseWeb;
import com.perfecto.pageObjects.DatosDelDomicilioYMediosDeContacto;
import io.cucumber.java.en.And;
import org.apache.poi.ss.usermodel.Sheet;

public class DatosDelDomicilioYMediosDeContactoSteps extends BaseWeb {

	BaseWeb base = new BaseWeb();

	DatosDelDomicilioYMediosDeContacto ddmc = new DatosDelDomicilioYMediosDeContacto();
    CommonSteps bu;

    public DatosDelDomicilioYMediosDeContactoSteps(CommonSteps bu) {
		this.bu = bu;
    }

	public String filePath= "src//main//resources";
	public String fileName= "DataReader.xlsx";
	public String sheetName= "CapturaDomicilioContacto";

	@And("^captura datos del domicilio y medios de contacto '(.*?)'$")
	public void captura_datos_del_domicilio_y_medios_de_contacto(int RowNum) throws Throwable {
		ddmc.readExcel(filePath, fileName, sheetName);
		ddmc.captura_datos_del_domicilio_y_medios_de_contacto(bu.getDriver(), bu.getReportiumClient(), sheetName,RowNum);
	}

}
