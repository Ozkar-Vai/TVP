package com.perfecto.pageObjects;

import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.sampleproject.PerfectoLabUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BaseUtility {
    public RemoteWebDriver driver;
    public ReportiumClient reportiumClient;
    Properties prop = new Properties();
    String cloudName = "banorte";
    String securityToken = "";

    public RemoteWebDriver configDriver(RemoteWebDriver driver, String cloudName, String securityToken) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities("", "", Platform.ANY);
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "latest");
        capabilities.setCapability("location", "US East");
        capabilities.setCapability("resolution", "1366x768");
        capabilities.setAcceptInsecureCerts(true);
        // The below capability is mandatory. Please do not replace it.
        capabilities.setCapability("securityToken", PerfectoLabUtils.fetchSecurityToken(securityToken));

        driver = new RemoteWebDriver(new URL("https://" + PerfectoLabUtils.fetchCloudName(cloudName) + ".perfectomobile.com/nexperience/perfectomobile/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

        return driver;
    }

    public RemoteWebDriver webDriver(Properties prop) throws Exception {
        securityToken = prop.getProperty("securityToken");
        driver = configDriver(driver, cloudName, securityToken);
        return driver;
    }

    public ReportiumClient launchBrowser() throws Exception {
        FileReader file = new FileReader("src//main//resources//Config.properties");
        prop.load(file);
        driver = webDriver(prop);
        reportiumClient = PerfectoLabUtils.setReportiumClient(driver, reportiumClient); //Creates reportiumClient
        return reportiumClient;
    }

    public RemoteWebDriver getDriver() {
        return driver;
    }

    public ReportiumClient getReportiumClient() {
        return reportiumClient;
    }

    public Properties getProp() {
        return prop;
    }

    public WebElement validateElementWait(String xpath, RemoteWebDriver driver, Integer wait_time) {
        WebDriverWait wait = new WebDriverWait(driver, wait_time);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
//		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return element;
    }

    public void openBrowser(String url, RemoteWebDriver driver, ReportiumClient reportiumClient) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public WebElement moveToElement(String xpath, RemoteWebDriver driver) {
        WebElement element = driver.findElement(By.xpath(xpath));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        //driver.getScreenshotAs(OutputType.BYTES);
        return element;
    }

    public void clickElement(String xpath, RemoteWebDriver driver) {
        WebElement element = moveToElement(xpath, driver);
        element.click();
        //       driver.getScreenshotAs(OutputType.BYTES);
    }

    public void writeInElement(String xpath, String string, RemoteWebDriver driver) {
        WebElement element = moveToElement(xpath, driver);
        element.sendKeys(string);
        //       driver.getScreenshotAs(OutputType.BYTES);
    }

    public void checkElement(String xpath, RemoteWebDriver driver) {
        WebElement element = moveToElement(xpath, driver);
        element.isDisplayed();
        driver.getScreenshotAs(OutputType.BYTES);
    }

    public void selectItem(String xpath, String select, RemoteWebDriver driver) {
        Select select1 = new Select(driver.findElement(By.xpath(xpath)));
        select1.selectByValue(select);
    }

    public void CheckDiabledtextbox(RemoteWebDriver driver, String xpath) throws Exception {
        String simulationBtn = driver.findElement(By.xpath(xpath)).getText();
        String simulationBtnColor = Color.fromString(driver.findElement(By.xpath(xpath)).getCssValue("background-color")).asHex();
        System.out.println(simulationBtn);
        if (simulationBtnColor.equalsIgnoreCase("#ffa479")) {
            System.out.println("Component is disabled as per requirement");
        } else {
            System.out.println("Component is not disabled which is not as per requirement");
        }
    }

    /**
     * This function is to make the driver wait explicitly for a condition to be
     * satisfied
     *
     * @param locator - By object of the element whose visibility/presence/clickability
     *                has to be checked
     */
    public void addExplicitWait(By locator, String condition, int inttimeoutinseconds) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, inttimeoutinseconds, 250L);
        try {

            System.out.println("waiting for the element");
            if (condition.equalsIgnoreCase("visibility")) {

                System.out.println("waiting for the element to be Visible" + driver.findElement(locator));
                webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));

            } else if (condition.equalsIgnoreCase("clickable")) {

                System.out.println("waiting for the element to be clickable" + driver.findElement(locator));
                webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));

            } else if (condition.equalsIgnoreCase("presence")) {
                System.out.println("waiting for the element to be Present" + driver.findElement(locator));
                webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));

            } else {
                System.out.println("waiting for the element to be display");
            }

        } catch (NoSuchElementException e) {

            throw new NoSuchElementException(
                    "The element with" + locator.toString().replace("By.", " ") + " not found");
        } catch (UnsupportedCommandException e) {
            throw new NoSuchElementException("The condition given to check the elemnt with"
                    + locator.toString().replace("By.", " ") + " is invalid", e.fillInStackTrace());
        }
    }

    public WebElement switchToframe(String xpath, RemoteWebDriver driver) {
        WebElement iframe = driver.findElement(By.xpath(xpath));
        driver.switchTo().frame(iframe);
        return iframe;
    }

    public WebElement switchToframeChild(String xpathFather, String xpathChild, RemoteWebDriver driver) {
        WebElement iframe = driver.findElement(By.xpath(xpathFather));
        driver.switchTo().frame(iframe);
        WebElement child = driver.findElement(By.xpath(xpathChild));
        driver.switchTo().frame(child);
        return child;
    }

    // Método para espera explícita con iframes anidados
    public static void esperaExplicitaIframesAnidados(WebDriver driver, String xpathIframePrincipal, String xpathIframeAnidado, String xpathElementoEnIframeAnidado) throws Throwable {
        try {
            // Espera explícita para asegurarse de que el iframe principal esté presente
            WebDriverWait wait = new WebDriverWait(driver, 120);
            WebElement iframePrincipal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathIframePrincipal)));
            // Cambiar al contexto del iframe principal
            driver.switchTo().frame(iframePrincipal);
            // Espera explícita para asegurarse de que el iframe anidado esté presente en el iframe principal
            WebElement iframeAnidado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathIframeAnidado)));
            // Cambiar al contexto del iframe anidado
            driver.switchTo().frame(iframeAnidado);
            // Espera explícita para asegurarse de que el elemento en el iframe anidado esté presente
            //WebElement elementoEnIframeAnidado = (WebElement) wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(idElementoEnIframeAnidado)));

            System.out.println("=========================================");
            System.out.println("Datos del Cliente");
            System.out.println("=========================================");

            WebElement elementoEnIframeAnidado = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathElementoEnIframeAnidado)));
            System.out.println("Datos de Cliente: " + elementoEnIframeAnidado.getText());

            WebElement tipoPersona = driver.findElement(By.xpath("//p[@id='outputtext-text-CV_DatosCliente1:tipoPersona']"));
            System.out.println("Tipo Persona: " + tipoPersona.getText());

            WebElement razonSocial = driver.findElement(By.xpath("//p[@id='outputtext-text-CV_DatosCliente1:nombreCompleto']"));
            System.out.println("Razón Social: " + razonSocial.getText());

            WebElement rfc = driver.findElement(By.xpath("//p[@id='outputtext-text-CV_DatosCliente1:rfc']"));
            System.out.println("RFC: " + rfc.getText());

            WebElement fechaAltaSHCP = driver.findElement(By.xpath("//p[@id='outputtext-text-CV_DatosCliente1:fechaAltaSHCP']"));
            System.out.println("Fecha de Alta SHCP: " + fechaAltaSHCP.getText());
            /*
            WebElement antecedentesInternos = driver.findElement(By.xpath("//p[@id='outputtext-text-CV_DatosCliente1:buroInterno']"));
            System.out.println("Antecedentes Internos: " + antecedentesInternos.getText());

            WebElement antecedentesExternos = driver.findElement(By.xpath("//p[@id='outputtext-text-CV_DatosCliente1:buroExterno']"));
            System.out.println("Antecedentes Externos: " + antecedentesExternos.getText());
            */
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al ingresar a los frames");
            throw new Exception("Error al ingresar a los frames");
        }
    }

    // Método para espera explícita con iframes anidados
    public static void explicitWaitWithClick(String xpath, RemoteWebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 65);
        // Espera explícita para asegurarse esté presente
        WebElement elemento = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        elemento.click();
    }

    public static void explicitWaitElementToBeClickable(String xpath, RemoteWebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 65);
        // Espera explícita para asegurarse esté presente
        WebElement elemento = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        elemento.click();
    }


    // Método para espera explícita con iframes anidados
    public static void explicitWaitWithSendkeys(String xpath, String text, RemoteWebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        // Espera explícita para asegurarse esté presente
        WebElement elemento = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        elemento.sendKeys(text);
        //actions.sendKeys(elemento, Keys.TAB).perform();

    }

    public static void explicitWaitWithClearSendkeys(String xpath, String text, RemoteWebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement elemento = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        elemento.click();
        elemento.clear();
        elemento.sendKeys(text);
    }

    public static void explicitWaitWithSendkeysTAP(String xpath, String text, RemoteWebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        // Espera explícita para asegurarse esté presente
        WebElement elemento = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        elemento.sendKeys(text, Keys.TAB);
    }

    private static WebElement waitForElementToBeClickable(RemoteWebDriver driver, By xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.elementToBeClickable(xpath));
    }

	public static WebElement explicitWaitWithClick(RemoteWebDriver driver, String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement elemento = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		elemento.click();
		return elemento;
	}

    public static void selectByValue(RemoteWebDriver driver, String dropdownLocator, String value) {
        WebElement dropdownElement = driver.findElement(By.xpath(dropdownLocator));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }

    public WebElement validateElement(String xpath, RemoteWebDriver driver) {
        WebElement element = driver.findElement(By.xpath(xpath));
        return element;
    }

    public void selectItemByIndex(String xpath, int num_option, RemoteWebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Select select1 = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))));
        select1.selectByIndex(num_option);
    }

    // Utiliza JavascriptExecutor para esperar el elemento se clicleable y enviar texto al elemento
    public static void waitForElementAndType(String XpathType, String texto, RemoteWebDriver driver) {
        // Espera a que el elemento esté presente
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement elementToWait = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathType)));
        // Utiliza JavascriptExecutor para hacer clic en el elemento
        WebElement elementToClickElement = driver.findElement(By.xpath(XpathType));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementToClickElement);
        // Utiliza JavascriptExecutor para enviar texto al elemento
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", driver.findElement(By.xpath(XpathType)), texto);
    }

    public static void selectByVisibleTextHiddenJS(String dropdownLocator, String visibleText, RemoteWebDriver driver) {

        // Espera a que el elemento esté presente
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement elementToWait = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dropdownLocator)));

        // Utiliza JavascriptExecutor para hacer clic en el elemento
        WebElement elementToClickElement = driver.findElement(By.xpath(dropdownLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementToClickElement);

        WebElement dropdownElement = driver.findElement(By.xpath(dropdownLocator));

        // Abrir el dropdown utilizando JavaScript
        String scriptOpenDropdown = "arguments[0].style.display='block';";
        ((JavascriptExecutor) driver).executeScript(scriptOpenDropdown, dropdownElement);

        // Buscar y seleccionar el elemento por texto utilizando JavaScript
        String scriptSelectText = "for (const option of arguments[0].options) { if (option.text.trim() === arguments[1]) { option.selected = true; break; } }";
        ((JavascriptExecutor) driver).executeScript(scriptSelectText, dropdownElement, visibleText);

        // Cerrar el dropdown después de la selección
        String scriptCloseDropdown = "arguments[0].style.display='none';";
        ((JavascriptExecutor) driver).executeScript(scriptCloseDropdown, dropdownElement);
    }

    public void selectItemByVisibleText(String xpath, String select, RemoteWebDriver driver) {
        Select select1 = new Select(driver.findElement(By.xpath(xpath)));
        select1.selectByVisibleText(select);
    }

    public void uploadfile() throws Exception {
        //String repositoryKey1 ="PUBLIC:6906520/96d0f772d0f646a7a729f26cd1d0867e.js";

        //	PerfectoLabUtils.uploadMedia(cloudName, securityToken, localFilePath, repositoryKey1);
        Map param = new HashMap();
        param.put("fileLocation", "PUBLIC:6906520/96d0f772d0f646a7a729f26cd1d0867e.js");
        Object result = driver.executeScript("perfecto:file:upload", param);
        //       driver.getScreenshotAs(OutputType.BYTES);
    }


    public void scrollToElement(RemoteWebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Desplaza la ventana 500 píxeles hacia abajo
    public void scrollToBy(RemoteWebDriver driver, int scrollHorizontal, int scrollVertical) {
        // Utiliza JavascriptExecutor para hacer scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", scrollHorizontal, scrollVertical);
        // Define las variables para el scroll
    }

    public static void scrollUp(RemoteWebDriver driver) {
        // Utiliza JavascriptExecutor para realizar un scroll vertical hacia arriba
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
    }

    public static void scrollUpByPixels(RemoteWebDriver driver, int scrollVertical) {
        // Utiliza JavascriptExecutor para realizar un scroll vertical hacia arriba por la cantidad de píxeles especificada
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -arguments[0]);", scrollVertical);
    }

    public void readTable(String xpathTablaCol, String xpathTablaRow, String nameTable, RemoteWebDriver driver) {
        //No.of Columns
        List<WebElement> col = driver.findElements(By.xpath(xpathTablaCol));
        System.out.println("Total de columnas: " + col.size());
        //No.of rows
        List<WebElement> rows = driver.findElements(By.xpath(xpathTablaRow));
        System.out.println("Total de filas: " + rows.size());
        WebElement baseTable = driver.findElement(By.xpath(nameTable));
        System.out.println("Tabla localizada: " + baseTable);
    }

    void handleException(RemoteWebDriver driver, ReportiumClient reportiumClient, Exception e) throws Exception {
        driver.getScreenshotAs(OutputType.BYTES);
        e.printStackTrace();
        System.out.println("Captura de Datos Incorrecta");
        throw new Exception("Captura de Datos Incorrecta");
    }
    public void handleExcelError(String errorMessage) {
        System.out.println("Error Excel: " + errorMessage);
    }

    // Método para validar no vacío
    public boolean validateNonEmpty(String value, String fieldName) {
        if (value.isEmpty()) {
            handleExcelError("Celda vacía en " + fieldName);
            return false;
        }
        return true;
    }

    private void imprimirInformacionDelDriver(String mensaje, RemoteWebDriver driver) {
        System.out.println("URL Actual: " + driver.getCurrentUrl());
        System.out.println("Título de la Página: " + driver.getTitle());
        System.out.println("HTML del Cuerpo: " + driver.findElement(By.tagName("body")).getText());
        System.out.println("Cookies: " + driver.manage().getCookies());
        System.out.println("Todas las Pestañas/Ventanas Abiertas: " + driver.getWindowHandles());

    }

    public void cambioVentana(RemoteWebDriver driver, ReportiumClient reportiumClient) {
        // Verifica que el driver no sea null
        if (driver == null) {
            throw new IllegalStateException("WebDriver no ha sido inicializado.");
        }

        // Guarda el identificador de la primera pestaña
        String originalTab = driver.getWindowHandle();
        Set<String> allTabs = driver.getWindowHandles();

        // Cambia a la nueva pestaña
        for (String tab : allTabs) {
            if (!tab.equals(originalTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }
    }

}
