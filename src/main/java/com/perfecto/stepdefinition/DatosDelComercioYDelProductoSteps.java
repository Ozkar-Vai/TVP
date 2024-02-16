package com.perfecto.stepdefinition;

import com.perfecto.pageObjects.BaseWeb;
import com.perfecto.pageObjects.DatosDelComercioYDelProducto;
import io.cucumber.java.en.And;
import org.apache.poi.ss.usermodel.Sheet;

public class DatosDelComercioYDelProductoSteps extends BaseWeb {

	BaseWeb base = new BaseWeb();

	DatosDelComercioYDelProducto dcp = new DatosDelComercioYDelProducto();
    CommonSteps bu;

    public DatosDelComercioYDelProductoSteps(CommonSteps bu) {
    	this.bu = bu;
    }

	public String filePath= "src//main//resources";
	public String fileName= "DataReader.xlsx";
	public String sheetName= "CapturaComercioProducto";


	@And("^captura datos del comercio y del producto '(.*?)'$")
	public void captura_datos_del_comercio_y_del_producto(int RowNum) throws Throwable {
		dcp.readExcel(filePath, fileName, sheetName);
		dcp.captura_datos_del_comercio_y_del_producto(bu.getDriver(), bu.getReportiumClient(), sheetName,RowNum);
	}

}
