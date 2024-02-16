package com.perfecto.stepdefinition;

import com.perfecto.pageObjects.BaseWeb;
import com.perfecto.pageObjects.BusquedaCliente;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.usermodel.Sheet;

public class BusquedaClienteSteps extends BaseWeb {

    BaseWeb base = new BaseWeb();
    BusquedaCliente bc = new BusquedaCliente();
    CommonSteps bu;

    public BusquedaClienteSteps(CommonSteps bu) {
        this.bu = bu;
    }

    public String filePath = "src//main//resources";
    public String fileName = "DataReader.xlsx";
    public String sheetName = "Busqueda";

    @Then("selecciona ultima version TPV")
    public void select_version_TPV() throws Throwable {
        bc.selectVersionTPVPrueba(bu.getDriver(), bu.getReportiumClient());
    }

    @And("^realiza busqueda de cliente '(.*?)'$")
    public void busqueda_cliente(int RowNum) throws Throwable {
        bc.readExcel(filePath, fileName, sheetName);
        bc.busquedaClienteTPV(bu.getDriver(), bu.getReportiumClient(), sheetName, RowNum);
    }

}
