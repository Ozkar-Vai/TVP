package com.perfecto.pageObjects;

import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.sampleproject.PerfectoLabUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BusquedaCliente extends BaseWeb {

    public static final String camara_version = "/html/body/div[2]/div/div/div[1]/div/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div/div[5]/div[1]/div/div[1]/a/i";    //seleccion camara para desplegar versiones
    public static final String version_tpv = "//*[@id=\"collapseLaunchsMenu\"]/div/div[5]/div[2]/div/div/div[1]/a";    //seleccion version tpv
    public static final String frame_busqueda_cliente1 = "//iframe[@title=\"BÚSQUEDA DE CLIENTE\"]";
    public static final String frame_busqueda_cliente2 = "//*[contains(@id,'coach_frame')]";
    public static final String button_aceptar = "//*[@id='button-button-PlantillaTPV_CV1:Botones_CV1:botonAceptar']";
    public static final String numero_cliente = "//*[@id='outputtext-text-Busca_Cliente_CV1:seccionResultados:tablaClientes:numeroCliente1[0]']";
    public static final String rfc = "//*[@id='outputtext-text-Busca_Cliente_CV1:seccionResultados:tablaClientes:rfc1[0]']";
    public static final String busqueda_cliente_ref = "//*[@id=\"pnlHdr-lbl-19\"]";
    public static final String radiobtn_pfae = "//*[@id=\"RBGroup_div_6\"]/div[1]/span";
    public static final String radiobtn_pm = "//*[@id=\"radiogroup-item-input-Busca_Cliente_CV1:tipoPersona[1]\"]";
    public static final String radiobtn_numcliente = "//*[@id=\"radiogroup-item-input-Busca_Cliente_CV1:tipoBusqueda[0]\"]";
    public static final String radiobtn_rfc = "//*[@id=\"radiogroup-item-input-Busca_Cliente_CV1:tipoBusqueda[1]\"]";
    public static final String textbox_NumCliente = "//*[@id='text-input-Busca_Cliente_CV1:numeroCliente']";
    public static final String textbox_RFC = "//*[@id='text-input-Busca_Cliente_CV1:rfc']";
    public static final String btn_buscar_busquedacliente = "//*[@id=\"button-button-Busca_Cliente_CV1:botonBuscarCliente\"]";
    public static final String seccionResultados_tablaClientes = "//*[@id='table-rowselect-Busca_Cliente_CV1:seccionResultados:tablaClientes[0]']";
    public static final String tablaClientesRFC = "//*[@id='outputtext-text-Busca_Cliente_CV1:seccionResultados:tablaClientes:RFC1[0]']";

    String filePath = "src//main//resources";
    String fileName = "DataReader.xlsx";
    String sheetName = "Busqueda";

    //seleccionar la version de tpv
    public void selectVersionTPVPrueba(RemoteWebDriver driver, ReportiumClient reportiumClient) throws Throwable {
        try {
            System.out.println("=======================================================");
            System.out.println("Pantalla Selección de última versión Genera TPV");
            System.out.println("=======================================================");

            reportiumClient.stepStart("Selecciona ultima version TPV");
            validateElement(camara_version, driver).click();
            driver.getScreenshotAs(OutputType.BYTES);
            //scrollToBy(driver, 0, 100);
            validateElement(version_tpv, driver).click();

            WebElement versionTPV = driver.findElement(By.xpath(version_tpv));
            System.out.println("Versión TPV: " + versionTPV.getText());
            PerfectoLabUtils.assertContainsText(versionTPV, reportiumClient, "FP_TPV_Onboarding_2.17.11");
            driver.getScreenshotAs(OutputType.BYTES);

        } catch (Exception e) {
            driver.getScreenshotAs(OutputType.BYTES);
            e.printStackTrace();
            System.out.println("Selección de versión no realizada");
            throw new Exception("Selección de versión no realizada");
        }
        //Finaliza reporte
        driver.getScreenshotAs(OutputType.BYTES);
        reportiumClient.stepEnd();
        System.out.println("=======================================================");
        System.out.println("Última versión Genera TPV seleccionada");
        System.out.println("=======================================================");
    }

    public void busquedaClienteTPV(RemoteWebDriver driver, ReportiumClient reportiumClient, String sheetName, int rowNum) throws Throwable {
        try {
            reportiumClient.stepStart("Selecciona Tipo de Cliente");
            Sheet wbSheet = wb.getSheet(sheetName);

            switchToframeChild(frame_busqueda_cliente1, frame_busqueda_cliente2, driver);

            validateElement(busqueda_cliente_ref, driver);
            System.out.println("Verifica titulo busqueda de cliente");
            driver.getScreenshotAs(OutputType.BYTES);

            readData(wbSheet, rowNum, "Tipo_Cliente");
            String tipoCliente = data.toString();

            if (validateNonEmpty(tipoCliente, "Tipo_Cliente")) {
                switch (tipoCliente.toUpperCase()) {
                    case "PFAE":
                        System.out.println("Selecciona PFAE");
                        break;
                    case "PM":
                        System.out.println("Selecciona PM");
                        clickElement(radiobtn_pm, driver);
                        break;
                    default:
                        handleExcelError("Valor no permitido en Tipo_Cliente: " + data);
                }
            } else {
                handleExcelError("Celda vacía en Tipo_Cliente");
            }

            reportiumClient.stepStart("Selecciona Tipo de Busqueda");

            readData(wbSheet, rowNum, "Tipo_Busqueda");
            String tipoBusqueda = data.toString();

            if (validateNonEmpty(tipoBusqueda, "Tipo_Busqueda")) {
                switch (tipoBusqueda.toUpperCase()) {
                    case "NUMERO":
                        System.out.println("Selecciona Número de cliente");
                        ingresarNumeroCliente(driver, reportiumClient, wbSheet, rowNum);
                        break;
                    case "RFC":
                        System.out.println("Selecciona RFC");
                        ingresarRFC(driver, reportiumClient, wbSheet, rowNum);
                        break;
                    default:
                        handleExcelError("Valor no permitido en Tipo_Busqueda: " + data);
                }
            } else {
                handleExcelError("Celda vacía en Tipo_Busqueda");
            }

        } catch (Exception e) {
            handleException(driver, reportiumClient, e);
        } finally {
            driver.getScreenshotAs(OutputType.BYTES);
            reportiumClient.stepEnd();
        }
    }

    private void ingresarNumeroCliente(RemoteWebDriver driver, ReportiumClient reportiumClient, Sheet wbSheet, int rowNum) throws Exception {
        try {
            reportiumClient.stepStart("Busqueda de Numero de Cliente");
            readData(wbSheet, rowNum, "Num_Cliente");
            String numClienteString = data.toString();
            int numCliente = Integer.parseInt(numClienteString);

            WebElement textNumeroCliente = driver.findElement(By.xpath(textbox_NumCliente));
            textNumeroCliente.click();

            writeInElement(textbox_NumCliente, data, driver);
            System.out.println("Cliente Ingresado");

            clickElement(btn_buscar_busquedacliente, driver);

            WebElement elementNumeroCliente = driver.findElement(By.xpath(numero_cliente));
            PerfectoLabUtils.assertContainsText(elementNumeroCliente, reportiumClient, numClienteString);

            clickElement(seccionResultados_tablaClientes, driver);

            WebElement element = driver.findElement(By.xpath(button_aceptar));
            scrollToElement(driver, element);
            validateElementWait(button_aceptar, driver, 6000);

            clickElement(button_aceptar, driver);

        } catch (Exception e) {
            handleException(driver, reportiumClient, e);
        }
    }

    private void ingresarRFC(RemoteWebDriver driver, ReportiumClient reportiumClient, Sheet wbSheet, int rowNum) throws Exception {
        try {
            reportiumClient.stepStart("Busqueda de RFC");
            readData(wbSheet, rowNum, "RFC");
            String RFC = data.toString();

            clickElement(radiobtn_rfc, driver);
            System.out.println("Selecciona RFC");

            WebElement textRFC = driver.findElement(By.xpath(textbox_RFC));
            textRFC.click();

            writeInElement(textbox_RFC, data, driver);
            System.out.println("RFC Ingresado");

            clickElement(btn_buscar_busquedacliente, driver);

            WebElement elementRFC = driver.findElement(By.xpath(tablaClientesRFC));
            PerfectoLabUtils.assertContainsText(elementRFC, reportiumClient, RFC);

            clickElement(seccionResultados_tablaClientes, driver);

            WebElement element = driver.findElement(By.xpath(button_aceptar));
            scrollToElement(driver, element);
            validateElementWait(button_aceptar, driver, 6000);

            clickElement(button_aceptar, driver);

        } catch (Exception e) {
            handleException(driver, reportiumClient, e);
        }
    }
}