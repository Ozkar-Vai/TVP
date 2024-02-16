package com.perfecto.pageObjects;

import com.perfecto.reportium.client.ReportiumClient;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DatosDelDomicilioYMediosDeContacto extends BaseWeb {

    //Iframes Datos Del Comercio Y Del Producto
    public static final String frame_datos_domicilio_medios_contacto_hijo = "//*[contains(@id,'coach_frame')]";
    public static final String frame_datos_domicilio_medios_contacto_padre = "//iframe[@class='cshsTaskWindow fill-vertical']";

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

    public void captura_datos_del_domicilio_y_medios_de_contacto(RemoteWebDriver driver, ReportiumClient reportiumClient, String sheetName, int rowNum) throws Throwable {
        try {
            System.out.println("===========================================================");
            System.out.println("Pantalla Capturar Datos del Domicilio y Medios de Contacto");
            System.out.println("===========================================================");
            //Inicia reporte
            reportiumClient.stepStart("Captura Datos del Domicilio y Medios de Contacto");
            Sheet wbSheet = wb.getSheet(sheetName);

            //Ingresar a frames anidados
            esperaExplicitaIframesAnidados(driver, frame_datos_domicilio_medios_contacto_padre, frame_datos_domicilio_medios_contacto_hijo, datosClienteNumeroCliente);

            //Mover 500 pixeles
            scrollToBy(driver, 0, 500);
            driver.getScreenshotAs(OutputType.BYTES);

            System.out.println("=======================================================");
            System.out.println("Sección Domicilio de la Afiliación");
            System.out.println("=======================================================");

            scrollToBy(driver, 0, 500);
            driver.getScreenshotAs(OutputType.BYTES);

            scrollToBy(driver, 0, 500);
            driver.getScreenshotAs(OutputType.BYTES);


        } catch (Exception e) {
            driver.getScreenshotAs(OutputType.BYTES);
            e.printStackTrace();
            System.out.println("Captura Datos del Domicilio y Medios de Contacto incorrecta");
            throw new Exception("Captura Datos del Domicilio y Medios de Contacto incorrecta");
        }
        //Finaliza reporte
        driver.getScreenshotAs(OutputType.BYTES);
        reportiumClient.stepEnd();
        System.out.println("===========================================================");
        System.out.println("Fin de Pantalla Capturar Datos del Domicilio y Medios de Contacto");
        System.out.println("===========================================================");
    }

}

