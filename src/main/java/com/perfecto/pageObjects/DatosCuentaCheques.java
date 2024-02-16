package com.perfecto.pageObjects;

import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.sampleproject.PerfectoLabUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DatosCuentaCheques extends BaseWeb {
    public static final String frame_cuenta_cheques_hijo = "//*[contains(@id,'coach_frame')]";
    public static final String frame_cuenta_cheques_padre = "//iframe[@class='cshsTaskWindow fill-vertical']";
    public static final String datosClienteNumeroCliente = "//p[@id='outputtext-text-CV_DatosCliente1:numeroCliente']";
    public static final String radioBtnSI = "//div[@id='RBGroup_div_4_1_1_1_1_1']//div[1]//span[1]//input[1]";

    public static final String radioBtnNO = "//div[@id='RBGroup_div_4_1_1_1_1_1']//div[1]//span[1]//input[2]";
    public static final String drowdownAntedecedentesInternos = "//select[@id='singleselect-Antecedentes_CV1:Select_Ant_Int']";
    public static final String drowdownAntedecedentesExternos = "//select[@id='singleselect-Antecedentes_CV1:Select_Ant_Ext']";

    public static final String radioBtnMXN = "//div[@id='RBGroup_div_4_1_1_1_1_1']//div[1]//span[1]//input[1]";
    public static final String radioBtnUSD = "//*[@id='radiogroup-item-input-Capturar_Cuentas_CV1:opcionDivisaStr[1]']";

    public static final String radioBtnCuentaCliente = "//*[@id='table-rowselect-Capturar_Cuentas_CV1:Lista_Productos_Cliente_CV1:tablaProductosCliente[1]']";
    public static final String radioBtnCuentaCliente1 = "//*[@id='table-rowselect-Capturar_Cuentas_CV1:Lista_Productos_Cliente_CV1:tablaProductosCliente[0]']";
    public static final String radioBtnNOEjecutivoCaptura = "//div[@id='RBGroup_div_38_1_1_1_1']//div[1]//span[1]//input[1]";
    public static final String radioBtnSIOtroCR = "//div[@id='RBGroup_div_37_1_1_1_1']//div[1]//span[1]//input[1]";
    public static final String radioBtnSIApoyoEspecialista = "//div[@id='RBGroup_div_36_1_1_1_1']//div[1]//span[1]//input[1]";
    public static final String drowdownBanca = "//select[@id='singleselect-Capturar_Cuentas_CV1:Banca_y_Territorios_CV1:bancaID']";
    public static final String drowdownDireccionTerritorial = "//select[@id='singleselect-Capturar_Cuentas_CV1:Banca_y_Territorios_CV1:direccionID']";
    public static final String buttonSiguiente = "//button[@id='button-button-PlantillaTPV_CV1:Botones_CV1:botonSiguiente']";
    public static final String mensajeAviso = "//p[@id='outputtext-text-Dialogo_TPV1:Mensaje_Aviso_TPV1:Output_Text2']";

    public static final String buttonCancelar = "//button[@id='button-button-PlantillaTPV_CV1:Botones_CV1:botonCancelar']";

    public static final String buttonGuardarPosponer = "//button[@id='button-button-PlantillaTPV_CV1:Botones_CV1:botonGPosponer']";
    public static final String buttonBuscarEmpleadoProducto = "//button[@id='button-button-Capturar_Cuentas_CV1:Consultar_Empleado_CV1:buscarEmpleado']";
    public static final String buttonBuscarEmpleadoColocacion = "//button[@id='button-button-Capturar_Cuentas_CV1:Consultar_Empleado_CV2:buscarEmpleado']";
    public static final String buttonBuscarCR = "//button[@id='button-button-Capturar_Cuentas_CV1:Consultar_CR_CV1:buscarCR']";
    public static final String idSucursalCR = "//input[@id='text-input-Capturar_Cuentas_CV1:Consultar_CR_CV1:idSucursal']";
    public static final String idEmpleadoColocacion = "//input[@id='text-input-Capturar_Cuentas_CV1:Consultar_CR_CV2:idEmpleado']";
    public static final String idEmpleadoProducto = "//input[@id='text-input-Capturar_Cuentas_CV1:Consultar_CR_CV1:idEmpleado']";
    public static final String buttonAceptar = "//*[@id='button-button-Dialogo_TPV1:Mensaje_Aviso_TPV1:aceptar_popUp']";


    public void capturaDatosCuentaCheques(RemoteWebDriver driver, ReportiumClient reportiumClient, String sheetName, int rowNum) throws Throwable {
        try {
            System.out.println("=========================================");
            System.out.println("Pantalla Capturar Datos Cuenta Cheques");
            System.out.println("=========================================");

            //Inicia reporte
            reportiumClient.stepStart("Captura Datos Cuenta Cheques");
            //Lectura de archivo Contrato_Anticipado SI / NO
            Sheet wbSheet = wb.getSheet(sheetName);
            readData(wbSheet, rowNum, "Contrato_Anticipado");
            String Contrato_Anticipado = data.toString();

            //Mover a frames anidados
            esperaExplicitaIframesAnidados(driver, frame_cuenta_cheques_padre, frame_cuenta_cheques_hijo, datosClienteNumeroCliente);
            //Mover 500 pixeles
            scrollToBy(driver, 0, 500);
            driver.getScreenshotAs(OutputType.BYTES);

            System.out.println("=========================================");
            System.out.println("Sección Contrato Anticipado");
            System.out.println("=========================================");

            if (Contrato_Anticipado.equalsIgnoreCase("SI")) {
                System.out.println("Requiere Contrato anticipado");
                Thread.sleep(4000);
                explicitWaitWithClick(radioBtnSI, driver);
            } else if (Contrato_Anticipado.equalsIgnoreCase("NO")) {
                System.out.println("Sin Contrato Anticipado");
                //explicitWaitWithSendkeys(radioBtnContratoAnticipadoSI, "hola", driver);
            } else {
                // Acciones para otro valor
                System.out.println("Error Excel: Celda vacía o valor diferente al permitido" + data);
            }
            System.out.println("=========================================");
            System.out.println("Sección Antecedentes del Cliente");
            System.out.println("=========================================");
            //Lectura de archivo Antecedente_Externo
            readData(wbSheet, rowNum, "Antecedente_Interno");
            String Antecedente_Interno = data.toString();
            //Ingresar Antecedentes Internos del Cliente
            explicitWaitWithClick(drowdownAntedecedentesInternos, driver);
            selectItemByVisibleText(drowdownAntedecedentesInternos, Antecedente_Interno, driver);
            //selectByVisibleTextHiddenJS(drowdownAntedecedentesInternos, Antecedente_Interno, driver);

            //String optionAntedecedentesInternos = "//*[@id='singleselect-Antecedentes_CV1:Select_Ant_Int']//option[text()='" + Antecedente_Interno + "']";
            //System.out.println(optionAntedecedentesInternos);
            //explicitWaitWithClick(optionAntedecedentesInternos, driver);
            //Lectura de archivo Antecedente_Externo
            readData(wbSheet, rowNum, "Antecedente_Externo");
            String Antecedente_Externo = data.toString();
            //Ingresar Antecedentes Externos del Cliente
            explicitWaitWithClick(drowdownAntedecedentesExternos, driver);
            selectItemByVisibleText(drowdownAntedecedentesExternos, Antecedente_Externo, driver);

            //String optionAntedecedentesExternos = "//*[@id='singleselect-Antecedentes_CV1:Select_Ant_Ext']//option[text()='" + Antecedente_Externo + "']";
            //System.out.println(optionAntedecedentesExternos);
            //explicitWaitWithClick(optionAntedecedentesExternos, driver);
            driver.getScreenshotAs(OutputType.BYTES);

            System.out.println("=========================================");
            System.out.println("Sección Información de la Cuenta");
            System.out.println("=========================================");

            //Mover 200 pixeles
            scrollToBy(driver, 0, 200);
            //Lectura de archivo Antecedente_Externo
            readData(wbSheet, rowNum, "Afiliacion_Moneda");
            String Afiliacion_Moneda = data.toString();

            if (Afiliacion_Moneda.equals("MXN")) {
                System.out.println("Cliente Requiere Afiliación en pesos");
            } else if (Afiliacion_Moneda.equals("USD")) {
                explicitWaitWithClick(radioBtnUSD, driver);
                System.out.println("Cliente Requiere Afiliación en dolares");
            } else {
                System.out.println("Error Excel: Celda vacía o valor diferente al permitido: " + data);
            }
            driver.getScreenshotAs(OutputType.BYTES);

            //Tabla Cuenta Cliente
            scrollToBy(driver, 0, 100);
            explicitWaitWithClick(radioBtnCuentaCliente1, driver);
            driver.getScreenshotAs(OutputType.BYTES);

            //Mover 200 pixeles
            scrollToBy(driver, 0, 500);
            //Lectura de archivo Antecedente_Externo
            readData(wbSheet, rowNum, "Ejecutivo_Captura");
            String Ejecutivo_Captura = data.toString();

            //Lectura de archivo Ejecutivo_Producto
            readData(wbSheet, rowNum, "Ejecutivo_Producto");
            String Ejecutivo_Producto = data.toString();

            if (Ejecutivo_Captura.equalsIgnoreCase("SI")) {
                System.out.println("Ejecutivo de captura que coloco el producto");
            } else if (Ejecutivo_Captura.equalsIgnoreCase("NO")) {
                explicitWaitWithClick(radioBtnNOEjecutivoCaptura, driver);
                System.out.println("El Ejecutivo de captura NO que coloco el producto");
                explicitWaitWithSendkeys(idEmpleadoProducto,Ejecutivo_Producto, driver);
                explicitWaitWithClick(buttonBuscarEmpleadoProducto, driver);
            } else {

                System.out.println("Error Excel: Celda vacía o valor diferente al permitido: " + data);

            }
            driver.getScreenshotAs(OutputType.BYTES);

            //Lectura de archivo Otro_CR
            readData(wbSheet, rowNum, "Otro_CR");
            String Otro_CR = data.toString();

            //Lectura de archivo CR_Sucursal
            readData(wbSheet, rowNum, "CR_Sucursal");
            String CR_Sucursal = data.toString();

            if (Otro_CR.equalsIgnoreCase("NO")) {
                System.out.println("La afiliación no pertenecerá a otro CR");
            } else if (Otro_CR.equalsIgnoreCase("SI")) {
                explicitWaitWithClick(radioBtnSIOtroCR, driver);
                System.out.println("La afiliación pertenecerá a otro CR");
                explicitWaitWithSendkeys(idSucursalCR,CR_Sucursal, driver);
                explicitWaitWithClick(buttonBuscarCR, driver);
            } else {
                System.out.println("Error Excel: Celda vacía o valor diferente al permitido: " + data);

            }
            driver.getScreenshotAs(OutputType.BYTES);

            //Lectura de archivo Apoyo_Especialista
            readData(wbSheet, rowNum, "Apoyo_Especialista");
            String Apoyo_Especialista = data.toString();

            //Lectura de archivo Ejecutivo_Colocacion
            readData(wbSheet, rowNum, "Ejecutivo_Colocacion");
            String Ejecutivo_Colocacion = data.toString();

            if (Apoyo_Especialista.equalsIgnoreCase("NO")) {
                System.out.println("No se obtuvo apoyo en la colocación por parte de un Especialista en Soluciones Digitales");
            } else if (Apoyo_Especialista.equalsIgnoreCase("SI")) {
                explicitWaitWithClick(radioBtnSIApoyoEspecialista, driver);
                System.out.println("Se obtuvo apoyo en la colocación por parte de un Especialista en Soluciones Digitales");
                explicitWaitWithSendkeys(idEmpleadoColocacion,Ejecutivo_Colocacion, driver);
                explicitWaitWithClick(buttonBuscarEmpleadoColocacion, driver);
            } else {
                // Acciones para otro valor
                System.out.println("Error Excel: Celda vacía o valor diferente al permitido: " + data);
            }
            driver.getScreenshotAs(OutputType.BYTES);

            System.out.println("=========================================");
            System.out.println("Sección Banca y Territorios");
            System.out.println("=========================================");

            readData(wbSheet, rowNum, "Banca");
            String Banca = data.toString();

            //Ingresar Banca
            explicitWaitWithClick(drowdownBanca, driver);
            selectItemByVisibleText(drowdownBanca, Banca, driver);
            //String optionBanca = "//select[@id='singleselect-Capturar_Cuentas_CV1:Banca_y_Territorios_CV1:bancaID']//option[text()='" + Banca + "']";
            //System.out.println(optionBanca);
            //explicitWaitWithClick(optionBanca, driver);

            //Lectura de archivo Direccion_TerrItorial
            readData(wbSheet, rowNum, "Direccion_Territorial");
            String Direccion_Territorial = data.toString();

            //Ingresar Antecedentes Direccion_TerrItorial
            explicitWaitWithClick(drowdownDireccionTerritorial, driver);
            selectItemByVisibleText(drowdownDireccionTerritorial, Direccion_Territorial, driver);
            //String optionDireccionTerritorial = "//select[@id='singleselect-Capturar_Cuentas_CV1:Banca_y_Territorios_CV1:direccionID']//option[text()='" + Direccion_Territorial + "']";
            //System.out.println(optionDireccionTerritorial);
            //explicitWaitWithClick(optionDireccionTerritorial, driver);
            driver.getScreenshotAs(OutputType.BYTES);

            //Boton Siguiente
            explicitWaitWithClick(buttonSiguiente, driver);

            WebElement ConfirmacionCRGestor = driver.findElement(By.xpath(mensajeAviso));
            System.out.println("Confirmación de CR Gestor: " + ConfirmacionCRGestor.getText());
            //PerfectoLabUtils.assertContainsText(ConfirmacionCRGestor, reportiumClient, "El CR Gestor será el CR de la cuenta seleccionada ¿Estás de acuerdo?");

            //Boton Aceptar en modal
            explicitWaitWithClick(buttonAceptar, driver);
            //explicitWaitWithClick(buttonCancelar, driver);
            driver.getScreenshotAs(OutputType.BYTES);

        } catch (Exception e) {
            driver.getScreenshotAs(OutputType.BYTES);
            e.printStackTrace();
            System.out.println("Captura de Datos de Cheques incorrecta");
            throw new Exception("Captura de Datos de Cheques incorrecta");
        }

        driver.getScreenshotAs(OutputType.BYTES);
        reportiumClient.stepEnd();

        System.out.println("=============================================");
        System.out.println("Fin de Pantalla Capturar Datos Cuenta Cheques");
        System.out.println("=============================================");
    }
}

