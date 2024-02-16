package com.perfecto.pageObjects;

import com.perfecto.reportium.client.ReportiumClient;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

public class DatosDelComercioYDelProducto extends BaseWeb {

    //Iframes Datos Del Comercio Y Del Producto
    public static final String frame_datos_comercio_hijo = "//*[contains(@id,'coach_frame')]";
    public static final String frame_datos_comercio_padre = "//iframe[@class='cshsTaskWindow fill-vertical']";

    //Seccion Informacion del Comercio
    public static final String datosClienteNumeroCliente = "//p[@id='outputtext-text-CV_DatosCliente1:numeroCliente']";
    public static final String radioBtnSIAfiliacionesBanorte = "//div[@id='div_3_1_1_1']//div[2]//span[1]//input[1]";
    public static final String radioBtnSIAfiliacionesOtrosBancos = "//div[@id='div_3_1_1_2']//div[2]//span[1]//input[1]";

    public static final String radioBtnNO = "//div[@id='RBGroup_div_4_1_1_1_1_1']//div[1]//span[1]//input[2]";
    public static final String radioBtnSIAfiliacionAdicional = "//*[@id='radiogroup-item-input-Datos_Conocimiento_Cliente_CV1:afiliacionAdicional[3]']";;
    public static final String afiliacionActual = "//*[@id='text-input-Datos_Conocimiento_Cliente_CV1:afiliacionActual']";
    public static final String drowdownSeleccionBanco = "//select[@id='singleselect-Datos_Conocimiento_Cliente_CV1:seleccionBanco']";
    public static final String afiliacionBanco = "//input[@id='text-input-Datos_Conocimiento_Cliente_CV1:afiliacionBanco']";

    //Seccion Datos del Producto
    public static final String drowdownProducto= "//select[@id='singleselect-Datos_Producto_CV1:producto']";
    public static final String inputTecnologia = "//*[@id='table-rowselect-Datos_Producto_CV1:Lista_Productos_CV1:tablaDispositivos[0]']";
    public static final String inputCantidadTecnologia = "//*[@id='decimal-input-Datos_Producto_CV1:Lista_Productos_CV1:tablaDispositivos:Cantidad_CV2[0]']";
    public static final String inputAplicativos = "//*[@id='table-rowselect-Datos_Producto_CV1:Lista_Productos_CV1:tablaAplicativos[0]']";
    public static final String inputOperativas = "//*[@id='table-rowselect-Datos_Producto_CV1:Lista_Productos_CV1:tablaOperativas[0]']";
    public static final String inputServicios = "//*[@id='table-rowselect-Datos_Producto_CV1:Lista_Productos_CV1:tablaServicios[0]']";

    //Seccion Informacion del Comercio
    public static final String drowdownGiro = "//select[@id='singleselect-Datos_Generales_Comercio_CV1:giro']";
    public static final String checkboxCatalogoCompleto = "//*[@id='checkbox-input-Datos_Generales_Comercio_CV1:catalogoCompleto']";
    public static final String inputBuscarGiro = "//*[@id='text-input-Datos_Generales_Comercio_CV1:palabraClave_text']";
    public static final String inputNombreComercial = "//*[@id='text-input-Datos_Generales_Comercio_CV1:NombreComercial_CV1:nombreComercial']";
    public static final String inputAbreviatura = "//*[@id='text-input-Datos_Generales_Comercio_CV1:NombreComercial_CV1:abreviatura']";

    //SubSeccion Contacto del Comercio
    public static final String inputNombre = "//*[@id='text-input-Datos_Generales_Comercio_CV1:Datos_Contacto_CV1:nombre']";
    public static final String inputApellidoPaterno = "//*[@id='text-input-Datos_Generales_Comercio_CV1:Datos_Contacto_CV1:apellidoPaterno']";
    public static final String inputApellidoMaterno = "//*[@id='text-input-Datos_Generales_Comercio_CV1:Datos_Contacto_CV1:apellidoMaterno']";
    public static final String inputCorreo = "//*[@id='text-input-Datos_Generales_Comercio_CV1:Datos_Contacto_CV1:correo']";
    public static final String inputLada = "//*[@id='text-input-Datos_Generales_Comercio_CV1:Datos_Contacto_CV1:lada']";
    public static final String inputTelefono = "//*[@id='text-input-Datos_Generales_Comercio_CV1:Datos_Contacto_CV1:telefono']";
    public static final String inputExt = "//*[@id='text-input-Datos_Generales_Comercio_CV1:Datos_Contacto_CV1:ext']";

    //SubSeccion Datos del Producto

    //Apoderado de la Afiliacion
    public static final String checkboxCheckFirma = "//*[@id='checkbox-input-Apoderados_CV1:CheckFirma']";
    public static final String checkboxCheckApoderadoAdd = "//*[@id='checkbox-input-Apoderados_CV1:checkApoAdd']";

    //Primer Apoderado
    public static final String inputNombreApoderado = "//*[@id='text-input-Apoderados_CV1:Datos_Apoderado1:nombre']";
    public static final String inputApellidoPaternoApoderado = "//*[@id='text-input-Apoderados_CV1:Datos_Apoderado1:apellidoPaterno']";
    public static final String inputApellidoMaternoApoderado = "//*[@id='text-input-Apoderados_CV1:Datos_Apoderado1:apellidoMaterno']";
    public static final String inputRFCApoderado = "//*[@id='text-input-Apoderados_CV1:Datos_Apoderado1:rfc']";
    public static final String drowdownPaisApoderado = "//*[@id='singleselect-Apoderados_CV1:Datos_Apoderado1:cbPais']";
    public static final String inputCorreoApoderado = "//*[@id='text-input-Apoderados_CV1:Datos_Apoderado1:correo']";
    public static final String inputLadaApoderado = "//*[@id='text-input-Apoderados_CV1:Datos_Apoderado1:lada']";
    public static final String inputTelefonoApoderado = "//*[@id='text-input-Apoderados_CV1:Datos_Apoderado1:telefono']";
    public static final String inputExtApoderado = "//*[@id='text-input-Apoderados_CV1:Datos_Apoderado1:ext']";

    //Segundo Apoderado
    public static final String inputNombreSegundoApoderado= "//*[@id='text-input-Apoderados_CV1:Datos_Apoderado2:nombre']";
    public static final String inputApellidoPaternoSegundoApoderado = "//*[@id='text-input-Apoderados_CV1:Datos_Apoderado2:apellidoPaterno']";
    public static final String inputApellidoMaternoSegundoApoderado = "//*[@id='text-input-Apoderados_CV1:Datos_Apoderado2:apellidoMaterno']";
    public static final String inputRFCSegundoApoderado = "//*[@id='text-input-Apoderados_CV1:Datos_Apoderado2:rfc']";
    public static final String drowdownPaisSegundoApoderado = "//*[@id='singleselect-Apoderados_CV1:Datos_Apoderado2:cbPais']";
    public static final String inputCorreoSegundoApoderado = "//*[@id='text-input-Apoderados_CV1:Datos_Apoderado2:correo']";
    public static final String inputLadaSegundoApoderado = "//*[@id='text-input-Apoderados_CV1:Datos_Apoderado2:lada']";
    public static final String inputTelefonoSegundoApoderado = "//*[@id='text-input-Apoderados_CV1:Datos_Apoderado2:telefono']";
    public static final String inputExtSegundoApoderado= "//*[@id='text-input-Apoderados_CV1:Datos_Apoderado2:ext']";

    //Botones
    public static final String buttonSiguiente = "//button[@id='button-button-PlantillaTPV_CV1:Botones_CV1:botonSiguiente']";
    public static final String buttonCancelar = "//button[@id='button-button-PlantillaTPV_CV1:Botones_CV1:botonCancelar']";
    public static final String buttonGuardarPosponer = "//button[@id='button-button-PlantillaTPV_CV1:Botones_CV1:botonGPosponer']";
    public static final String buttonAceptar = "//*[@id='button-button-Dialogo_TPV1:Mensaje_Aviso_TPV1:aceptar_popUp']";

    public void captura_datos_del_comercio_y_del_producto(RemoteWebDriver driver, ReportiumClient reportiumClient, String sheetName, int rowNum) throws Throwable {
        try {
            System.out.println("=======================================================");
            System.out.println("Pantalla Capturar Datos del Comercio y del Producto");
            System.out.println("=======================================================");
            //Inicia reporte
            reportiumClient.stepStart("Captura Datos del Comercio y del Producto");

            Sheet wbSheet = wb.getSheet(sheetName);
            //Mover a frames anidados
            esperaExplicitaIframesAnidados(driver, frame_datos_comercio_padre, frame_datos_comercio_hijo, datosClienteNumeroCliente);

            //Mover 500 pixeles
            scrollToBy(driver, 0, 500);
            driver.getScreenshotAs(OutputType.BYTES);

            System.out.println("=======================================================");
            System.out.println("Sección Conociendo al Cliente");
            System.out.println("=======================================================");

            //Ingresar Comociendo al Cliente
            //Lectura de archivo Afiliaciones_Banorte SI / NO
            readData(wbSheet, rowNum, "Afiliaciones_Banorte");
            String Afiliaciones_Banorte = data.toString();
            //System.out.println("Afiliaciones_Banorte: " + data);
            //Lectura de archivo Afiliacion_Adicional
            readData(wbSheet, rowNum, "Afiliacion_Adicional");
            String Afiliacion_Adicional = data.toString();
            //System.out.println("Afiliacion_Adicional: " + data);
            //Lectura de archivo Numero_Afiliacion
            readData(wbSheet, rowNum, "Numero_Afiliacion");
            String Numero_Afiliacion = data.toString();
            //System.out.println("Numero_Afiliacion: " + data);

            if (Afiliaciones_Banorte.equalsIgnoreCase("SI")) {
                System.out.println("Cliente tiene o ha tenido Afiliaciones con Banorte");
                explicitWaitWithClick(radioBtnSIAfiliacionesBanorte, driver);

                if (Afiliacion_Adicional.equalsIgnoreCase("SI")) {
                    System.out.println("Cliente require afiliación adicional");
                    explicitWaitWithClick(radioBtnSIAfiliacionAdicional, driver);
                    explicitWaitWithSendkeys(afiliacionActual,Numero_Afiliacion, driver);
                } else if (Afiliacion_Adicional.equalsIgnoreCase("NO")) {
                    System.out.println("Cliente sin afiliación adicional");
                    //explicitWaitWithSendkeys(radioBtnContratoAnticipadoSI, "hola", driver);
                } else {
                    // Acciones para otro valor
                    System.out.println("Error Excel: Celda vacía o valor diferente al permitido" + data);
                }
            } else if (Afiliaciones_Banorte.equalsIgnoreCase("NO")) {
                System.out.println("Sin Afiliaciones con Banorte");
                //explicitWaitWithSendkeys(radioBtnContratoAnticipadoSI, "hola", driver);
            } else {
                // Acciones para otro valor
                System.out.println("Error Excel: Celda vacía o valor diferente al permitido" + data);
            }

            System.out.println("Elige Afiliaciones_Otros_Bancos");
            //Lectura de archivo Afiliaciones_Otros_Bancos
            readData(wbSheet, rowNum, "Afiliaciones_Otros_Bancos");
            String Afiliaciones_Otros_Bancos = data.toString();
            //System.out.println("Afiliaciones_Otros_Bancos: " + data);
            driver.getScreenshotAs(OutputType.BYTES);

            //Lectura de archivo Seleccion_Banco
            readData(wbSheet, rowNum, "Seleccion_Banco");
            String Seleccion_Banco = data.toString();
            //System.out.println("Seleccion_Banco: " + data);

            //Lectura de archivo Afiliacion_Banco
            readData(wbSheet, rowNum, "Afiliacion_Banco");
            String Afiliacion_Banco = data.toString();
            //System.out.println("Afiliacion_Banco: " + data);

            if (Afiliaciones_Otros_Bancos.equalsIgnoreCase("SI")) {
                System.out.println("Tiene o ha tenido Afiliaciones con Otros Bancos");
                explicitWaitWithClick(radioBtnSIAfiliacionesOtrosBancos, driver);

                //Ingresar Antecedentes Externos del Cliente
                explicitWaitWithClick(drowdownSeleccionBanco, driver);

                selectItemByVisibleText(drowdownSeleccionBanco, Seleccion_Banco, driver);
                /*
                String optionSeleccionBanco = "//select[@id='singleselect-Datos_Conocimiento_Cliente_CV1:seleccionBanco']//option[text()='" + Seleccion_Banco + "']";
                System.out.println(optionSeleccionBanco);
                explicitWaitWithClick(optionSeleccionBanco, driver);
                driver.getScreenshotAs(OutputType.BYTES);
                 */
                //Ingresa Numero de Afiliacion
                explicitWaitWithSendkeys(afiliacionBanco,Afiliacion_Banco, driver);

            } else if (Afiliaciones_Otros_Bancos.equalsIgnoreCase("NO")) {
                System.out.println("Sin Afiliaciones con Otros Bancos");
                //explicitWaitWithSendkeys(radioBtnContratoAnticipadoSI, "hola", driver);
            } else {
                // Acciones para otro valor
                System.out.println("Error Excel: Celda vacía o valor diferente al permitido" + data);
            }
            driver.getScreenshotAs(OutputType.BYTES);

            System.out.println("=======================================================");
            System.out.println("Sección Información del comercio");
            System.out.println("=======================================================");

            /*
            //Lectura de archivo Giro
            readData(wbSheet, rowNum, "Buscar_giro");
            String Buscar_giro = data.toString();
            System.out.println("Buscar_giro: " + data);

            //Ingresa Numero de Afiliacion
            explicitWaitWithSendkeys(inputBuscarGiro,Buscar_giro, driver);
            */
            //Checkbox Catalogo Completo
            //explicitWaitWithClick(checkboxCatalogoCompleto, driver);

            //Lectura de archivo Giro
            readData(wbSheet, rowNum, "Giro");
            String Giro = data.toString();
            //System.out.println("Giro: " + data);
            //Ingresar Giro
            explicitWaitWithClick(drowdownGiro, driver);
            //selectByVisibleTextHiddenJS(drowdownGiro, Giro, driver);
            selectItemByVisibleText(drowdownGiro, Giro, driver);
            //String optionGiro = "//select[@id='singleselect-Datos_Generales_Comercio_CV1:giro']//option[text()='" + Giro + "']";
            //System.out.println(optionGiro);
            //explicitWaitWithClick(optionGiro, driver);
            driver.getScreenshotAs(OutputType.BYTES);

            //Lectura de archivo Nombre_Comercial
            readData(wbSheet, rowNum, "Nombre_Comercial");
            String Nombre_Comercial = data.toString();

            //Ingresar Nombre Comercial
            waitForElementAndType(inputNombreComercial,Nombre_Comercial, driver);
            writeInElement(inputNombreComercial,Nombre_Comercial, driver);

            System.out.println("=======================================================");
            System.out.println("Sección Contacto del comercio");
            System.out.println("=======================================================");

            //Lectura de archivo Nombre
            readData(wbSheet, rowNum, "Nombre");
            String Nombre = data.toString();
            //System.out.println("Nombre: " + data);
            //Ingresa Numero de Afiliacion
            explicitWaitWithSendkeys(inputNombre,Nombre, driver);
            //Lectura de archivo Apellido_Paterno
            readData(wbSheet, rowNum, "Apellido_Paterno");
            String Apellido_Paterno = data.toString();
            //System.out.println("Apellido_Paterno: " + data);
            //Ingresa Apellido_Paterno
            explicitWaitWithSendkeys(inputApellidoPaterno,Apellido_Paterno, driver);
            //Lectura de archivo Apellido_Materno
            readData(wbSheet, rowNum, "Apellido_Materno");
            String Apellido_Materno = data.toString();
            //System.out.println("Apellido_Materno: " + data);
            //Ingresa Apellido_Materno
            explicitWaitWithSendkeys(inputApellidoMaterno,Apellido_Materno, driver);
            //Lectura de archivo Correo_Electronico
            readData(wbSheet, rowNum, "Correo_Electronico");
            String Correo_Electronico = data.toString();
            //System.out.println("Correo_Electronico: " + data);
            //Ingresa Correo_Electronico
            explicitWaitWithSendkeys(inputCorreo,Correo_Electronico, driver);

            //Lectura de archivo Lada
            readData(wbSheet, rowNum, "Lada");
            String Lada = data.toString();
            //System.out.println("Lada: " + data);
            //Ingresa Correo_Electronico
            explicitWaitWithSendkeys(inputLada,Lada, driver);

            //Lectura de archivo Telefono
            readData(wbSheet, rowNum, "Telefono");
            String Telefono = data.toString();
            //Ingresa Telefono
            explicitWaitWithSendkeys(inputTelefono,Telefono, driver);

            //Lectura de archivo Ext
            readData(wbSheet, rowNum, "Ext");
            String Ext = data.toString();
            explicitWaitWithSendkeys(inputExt, Ext, driver);

            scrollToBy(driver, 0, 100);
            driver.getScreenshotAs(OutputType.BYTES);

            System.out.println("==========================================================");
            System.out.println("Sección Datos del Producto");
            System.out.println("==========================================================");
            //Lectura de archivo Producto
            readData(wbSheet, rowNum, "Producto");
            String Producto = data.toString();

            selectItemByIndex(drowdownProducto, 1, driver);

            scrollToBy(driver, 0, 200);
            driver.getScreenshotAs(OutputType.BYTES);

            System.out.println("Definición del Producto Tecnología");
            //Lectura de archivo Tecnologia
            readData(wbSheet, rowNum, "Tecnologia");
            String Tecnologia = data.toString();
            //System.out.println("Tecnologia: " + data);
            explicitWaitWithClick(inputTecnologia, driver);
            System.out.println("Definición del Producto Tecnología Cantidad");
            //Lectura de archivo Tecnologia_Cantidad
            readData(wbSheet, rowNum, "Tecnologia_Cantidad");
            String Tecnologia_Cantidad = data.toString();
            //System.out.println("Tecnologia_Cantidad: " + data);
            explicitWaitWithSendkeys(inputCantidadTecnologia, Tecnologia_Cantidad, driver);
            System.out.println("Definición del Producto Aplicativos");
            //Lectura de archivo Aplicativos
            readData(wbSheet, rowNum, "Aplicativos");
            String Aplicativos = data.toString();
            //System.out.println("Aplicativos: " + data);
            explicitWaitWithClick(inputAplicativos, driver);
            System.out.println("Definición del Producto Operativas");
            //Lectura de archivo Operativas
            readData(wbSheet, rowNum, "Operativas");
            String Operativas = data.toString();
            //System.out.println("Operativas: " + data);
            explicitWaitWithClick(inputOperativas, driver);
            System.out.println("Definición del Producto Servicios");
            //Lectura de archivo Servicios
            readData(wbSheet, rowNum, "Servicios");
            String Servicios = data.toString();
            //System.out.println("Servicios: " + data);
            explicitWaitWithClick(inputServicios, driver);

            scrollToBy(driver, 0, 100);
            driver.getScreenshotAs(OutputType.BYTES);

            System.out.println("Definición del Producto Afiliación con Servicio AMEXOB");
            System.out.println("Definición del Producto MKT AMEX");

            System.out.println("==========================================================");
            System.out.println("Sección Firma Digital sin modificaciones");
            System.out.println("==========================================================");

            scrollToBy(driver, 0, 100);
            driver.getScreenshotAs(OutputType.BYTES);

            System.out.println("==========================================================");
            System.out.println("Sección Apoderados de la Afiliacion");
            System.out.println("==========================================================");

            //Lectura de archivo Firma_Mancomunada
            readData(wbSheet, rowNum, "Firma_Mancomunada");
            String Firma_Mancomunada = data.toString();
            //System.out.println("Firma_Mancomunada: " + data);

            //Lectura de archivo Registrar_Apoderados_Diferentes
            readData(wbSheet, rowNum, "Registrar_Apoderados_Diferentes");
            String Registrar_Apoderados_Diferentes = data.toString();
            //System.out.println("Registrar_Apoderados_Diferentes: " + data);

            if (Firma_Mancomunada.equalsIgnoreCase("SI")) {
                System.out.println("Cliente requiere Firma Mancomunada");
                //Checkbox CheckFirmaMancomunada
                explicitWaitWithClick(checkboxCheckFirma, driver);
                //Checkbox CheckApoderado
                explicitWaitWithClick(checkboxCheckApoderadoAdd, driver);
                //Primer Apoderado Diferente Registrado
                System.out.println("Primer Apoderado Diferente Registrado");
                registrarPrimerApoderado(driver, rowNum, wbSheet);
                //Segundo Apoderado Difrente Registrado
                System.out.println("Segundo Apoderado Diferente Registrado");
                registrarSegundoApoderado(driver, rowNum, wbSheet);
            } else if (Firma_Mancomunada.equalsIgnoreCase("NO")) {
                System.out.println("Sin Firma Mancomunada");
                //Checkbox CheckApoderado
                explicitWaitWithClick(checkboxCheckApoderadoAdd, driver);
                //Registrar Apoderado
                System.out.println("Registrar Apoderado");
                registrarPrimerApoderado(driver, rowNum, wbSheet);
            } else {
                // Acciones para otro valor
                System.out.println("Error Excel: Celda vacía o valor diferente al permitido" + data);
            }
            driver.getScreenshotAs(OutputType.BYTES);

            //Boton Siguiente
            explicitWaitWithClick(buttonSiguiente, driver);

        } catch (Exception e) {
            driver.getScreenshotAs(OutputType.BYTES);
            e.printStackTrace();
            System.out.println("Captura de Datos del Comercio y Producto incorrecta");
            throw new Exception("Captura de Datos del Comercio y Producto incorrecta");
        }
        //Finaliza reporte
        driver.getScreenshotAs(OutputType.BYTES);
        reportiumClient.stepEnd();
        System.out.println("==========================================================");
        System.out.println("Fin de Pantalla Capturar Datos del Comercio y del Producto");
        System.out.println("==========================================================");
    }

    private void registrarPrimerApoderado(RemoteWebDriver driver, int rowNum, Sheet wbSheet) throws IOException {
        //Lectura de archivo Nombre_Apoderado
        readData(wbSheet, rowNum, "Nombre_Apoderado");
        String Nombre_Apoderado = data.toString();
        //System.out.println("Nombre_Apoderado: " + data);
        //Ingresa Nombre_Apoderado
        explicitWaitWithSendkeys(inputNombreApoderado,Nombre_Apoderado, driver);

        //Lectura de archivo Apellido_Paterno_Apoderado
        readData(wbSheet, rowNum, "Apellido_Paterno_Apoderado");
        String Apellido_Paterno_Apoderado = data.toString();
        //System.out.println("Apellido_Paterno_Apoderado: " + data);
        //Ingresa Apellido_Paterno_Apoderado
        explicitWaitWithSendkeys(inputApellidoPaternoApoderado,Apellido_Paterno_Apoderado, driver);

        //Lectura de archivo Apellido_Materno_Apoderado
        readData(wbSheet, rowNum, "Apellido_Materno_Apoderado");
        String Apellido_Materno_Apoderado = data.toString();
        //System.out.println("Apellido_Materno_Apoderado: " + data);
        //Ingresa Apellido_Materno_Apoderado
        explicitWaitWithSendkeys(inputApellidoMaternoApoderado,Apellido_Materno_Apoderado, driver);

        //Lectura de archivo RFC_Apoderado
        readData(wbSheet, rowNum, "RFC_Apoderado");
        String RFC_Apoderado = data.toString();
        //System.out.println("RFC_Apoderado: " + data);
        //Ingresa RFC_Apoderado
        explicitWaitWithSendkeys(inputRFCApoderado,RFC_Apoderado, driver);

        //Lectura de archivo Pais_Residencia_Apoderado
        readData(wbSheet, rowNum, "Pais_Residencia_Apoderado");
        String Pais_Residencia_Apoderado = data.toString();
        //System.out.println("Pais_Residencia_Apoderado: " + data);
        //Ingresa Pais_Residencia_Apoderado
        explicitWaitWithClick(drowdownPaisApoderado, driver);
        selectItemByVisibleText(drowdownPaisApoderado, Pais_Residencia_Apoderado, driver);
        //String optionPaisApoderado = "//*[@id='singleselect-Apoderados_CV1:Datos_Apoderado1:cbPais']//option[text()='" + Pais_Residencia_Apoderado + "']";
        //System.out.println(optionPaisApoderado);
        //explicitWaitWithClick(optionPaisApoderado, driver);
        driver.getScreenshotAs(OutputType.BYTES);

        //Lectura de archivo Correo_Electronico_Apoderado
        readData(wbSheet, rowNum, "Correo_Electronico_Apoderado");
        String Correo_Electronico_Apoderado = data.toString();
        //System.out.println("Correo_Electronico_Apoderado: " + data);
        //Ingresa Correo_Electronico_Apoderado
        explicitWaitWithSendkeys(inputCorreoApoderado,Correo_Electronico_Apoderado, driver);

        //Lectura de archivo Lada_Apoderado
        readData(wbSheet, rowNum, "Lada_Apoderado");
        String Lada_Apoderado = data.toString();
        //System.out.println("Lada_Apoderado: " + data);
        //Ingresa Lada_Apoderado
        explicitWaitWithSendkeys(inputLadaApoderado,Lada_Apoderado, driver);

        //Lectura de archivo Telefono_Apoderado
        readData(wbSheet, rowNum, "Telefono_Apoderado");
        String Telefono_Apoderado = data.toString();
        //System.out.println("Telefono_Apoderado: " + data);
        //Ingresa Telefono_Apoderado
        explicitWaitWithSendkeys(inputTelefonoApoderado,Telefono_Apoderado, driver);

        //Lectura de archivo Ext_Apoderado
        readData(wbSheet, rowNum, "Ext_Apoderado");
        String Ext_Apoderado = data.toString();
        //System.out.println("Ext_Apoderado: " + data);
        //Ingresa Ext_Apoderado
        explicitWaitWithSendkeys(inputExtApoderado,Ext_Apoderado, driver);
        driver.getScreenshotAs(OutputType.BYTES);

    }

    private void registrarSegundoApoderado(RemoteWebDriver driver, int rowNum, Sheet wbSheet) throws IOException {
        //Lectura de archivo Nombre_SegundoApoderado
        readData(wbSheet, rowNum, "Nombre_SegundoApoderado");
        String Nombre_SegundoApoderado = data.toString();
        //System.out.println("Nombre_SegundoApoderado: " + data);
        //Ingresa Nombre_SegundoApoderado
        explicitWaitWithSendkeys(inputNombreSegundoApoderado,Nombre_SegundoApoderado, driver);

        //Lectura de archivo Apellido_Paterno_SegundoApoderado
        readData(wbSheet, rowNum, "Apellido_Paterno_SegundoApoderado");
        String Apellido_Paterno_SegundoApoderado = data.toString();
        //System.out.println("Apellido_Paterno_SegundoApoderado: " + data);
        //Ingresa Apellido_Paterno_SegundoApoderado
        explicitWaitWithSendkeys(inputApellidoPaternoSegundoApoderado,Apellido_Paterno_SegundoApoderado, driver);

        //Lectura de archivo Apellido_Materno_Apoderado
        readData(wbSheet, rowNum, "Apellido_Materno_SegundoApoderado");
        String Apellido_Materno_SegundoApoderado = data.toString();
        //System.out.println("Apellido_Materno_Apoderado: " + data);
        //Ingresa Apellido_Materno_SegundoApoderado
        explicitWaitWithSendkeys(inputApellidoMaternoSegundoApoderado,Apellido_Materno_SegundoApoderado, driver);

        //Lectura de archivo RFC_SegundoApoderado
        readData(wbSheet, rowNum, "RFC_SegundoApoderado");
        String RFC_SegundoApoderado= data.toString();
        //System.out.println("RFC_SegundoApoderado: " + data);
        //Ingresa RFC_SegundoApoderado
        explicitWaitWithSendkeys(inputRFCSegundoApoderado,RFC_SegundoApoderado, driver);

        //Lectura de archivo Pais_Residencia_SegundoApoderado
        readData(wbSheet, rowNum, "Pais_Residencia_SegundoApoderado");
        String Pais_Residencia_SegundoApoderado = data.toString();
        //System.out.println("Pais_Residencia_SegundoApoderado: " + data);
        //Ingresa Pais_Residencia_SegundoApoderado
        explicitWaitWithClick(drowdownPaisSegundoApoderado, driver);
        selectItemByVisibleText(drowdownPaisSegundoApoderado, Pais_Residencia_SegundoApoderado, driver);
        //String optionPaisSegundoApoderado = "//*[@id='singleselect-Apoderados_CV1:Datos_Apoderado1:cbPais']//option[text()='" + Pais_Residencia_SegundoApoderado + "']";
        //System.out.println(optionPaisSegundoApoderado);
        //explicitWaitWithClick(optionPaisSegundoApoderado, driver);
        driver.getScreenshotAs(OutputType.BYTES);

        //Lectura de archivo Correo_Electronico_SegundoApoderado
        readData(wbSheet, rowNum, "Correo_Electronico_SegundoApoderado");
        String Correo_Electronico_SegundoApoderado = data.toString();
        //System.out.println("Correo_Electronico_SegundoApoderado: " + data);
        //Ingresa Correo_Electronico_SegundoApoderado
        explicitWaitWithSendkeys(inputCorreoSegundoApoderado,Correo_Electronico_SegundoApoderado, driver);

        //Lectura de archivo Lada_SegundoApoderado
        readData(wbSheet, rowNum, "Lada_SegundoApoderado");
        String Lada_SegundoApoderado = data.toString();
        //System.out.println("Lada_SegundoApoderado: " + data);
        //Ingresa Lada_SegundoApoderado
        explicitWaitWithSendkeys(inputLadaSegundoApoderado,Lada_SegundoApoderado, driver);

        //Lectura de archivo Telefono_Apoderado
        readData(wbSheet, rowNum, "Telefono_SegundoApoderado");
        String Telefono_SegundoApoderado = data.toString();
        //System.out.println("Telefono_SegundoApoderadoo: " + data);
        //Ingresa Telefono_SegundoApoderado
        explicitWaitWithSendkeys(inputTelefonoSegundoApoderado,Telefono_SegundoApoderado, driver);

        //Lectura de archivo Ext_SegundoApoderado
        readData(wbSheet, rowNum, "Ext_SegundoApoderado");
        String Ext_SegundoApoderado = data.toString();
        //System.out.println("Ext_SegundoApoderado: " + data);
        //Ingresa Ext_SegundoApoderado
        explicitWaitWithSendkeys(inputExtSegundoApoderado,Ext_SegundoApoderado, driver);

        driver.getScreenshotAs(OutputType.BYTES);
    }

    private void botonesSolicitud(RemoteWebDriver driver) {
        //Boton Siguiente
        explicitWaitWithClick(buttonSiguiente, driver);
        //Boton Aceptar en modal
        explicitWaitWithClick(buttonAceptar, driver);
        //Boton GuardarPosponer en modal
        explicitWaitWithClick(buttonGuardarPosponer, driver);
        //Boton Cancelar
        explicitWaitWithClick(buttonCancelar, driver);
        //explicitWaitWithClick(buttonCancelar, driver);
        driver.getScreenshotAs(OutputType.BYTES);
    }
}

