package com.perfecto.pageObjects;

import com.perfecto.reportium.client.ReportiumClient;

import com.perfecto.sampleproject.PerfectoLabUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseWeb extends BaseUtility {

    // Define las variables para el scroll
    int scrollHorizontal = 0; // Desplazamiento horizontal
    int scrollVertical = 500; // Desplazamiento vertical

    protected Workbook wb = null;
    protected static String data = null;

    String filePath = "src//main//resources";
    String fileName = "DataReader.xlsx";
    String sheetName = "Usuarios TPV";

    public void readExcel(String filePath, String fileName, String sheetName) throws IOException {
        // set the file path
        File eFile = new File(filePath + "\\" + fileName);
        //print the file path
        //System.out.println("File is at: "+eFile);

        FileInputStream inputstream = new FileInputStream(eFile);
        // Read and publish extension
        String extensionName = fileName.substring(fileName.indexOf("."));
        //System.out.println("File type is: "+extensionName);

        //Read the file
        if (extensionName.equalsIgnoreCase(".xlsx")) {
            wb = new XSSFWorkbook(inputstream);
        } else if (extensionName.equalsIgnoreCase(".xls")) {
            wb = new HSSFWorkbook(inputstream);
        }
        //Read the sheet name
        Sheet wbSheet = wb.getSheet(sheetName);
        System.out.println("Datos obtenidos del archivo excel de la pestaña : " + sheetName);

    }

    public static String readData(Sheet wbSheet, int rowNum, String headerName) throws IOException {
        // Sheet wbSheet = wb.getSheet(sheetName);
        Row row = wbSheet.getRow(rowNum);
        Row rowHeader = wbSheet.getRow(0);
        //System.out.println("Last cell num:"+row.getLastCellNum());
        // String headerName="username";
        // Get the row count
        int colIndex = 0;
        int colNum = wbSheet.getRow(0).getLastCellNum();
        for (int i = 0; i < colNum; i++) {
            // headerName1 = headerName;
            //System.out.println("headerName1:"+headerName);
            //System.out.println("i :"+i);
            Cell cell = rowHeader.getCell(i);
            if (cell.getStringCellValue().equals(headerName)) {
                colIndex = i;
                //System.out.println("colIndex:"+i);
                break;
            }

            //for (int j=0; j < wbSheet.getCol)

        }
        data = new DataFormatter().formatCellValue(row.getCell(colIndex));
        // data = row.getCell(colIndex).getStringCellValue().toString();
        System.out.println("Valor del dato " + headerName + ": " + data);
        return data;
    }

    public static void writeData(String filePath, String fileName, String sheetName, int rowNum, int colIndex, String value) throws IOException {
        File eFile = new File(filePath + "\\" + fileName);
        FileInputStream inputStream = new FileInputStream(eFile);

        Workbook wb;
        String extensionName = fileName.substring(fileName.indexOf("."));
        if (extensionName.equalsIgnoreCase(".xlsx")) {
            wb = new XSSFWorkbook(inputStream);
        } else if (extensionName.equalsIgnoreCase(".xls")) {
            wb = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("Formato de archivo Excel no soportado.");
        }

        Sheet wbSheet = wb.getSheet(sheetName);

        // Obtener la fila y celda en la hoja de trabajo
        Row row = wbSheet.getRow(rowNum);
        if (row == null) {
            row = wbSheet.createRow(rowNum);
        }

        // Escribir el valor en la celda identificada por colIndex en la fila rowNum
        Cell cell = row.createCell(colIndex);
        cell.setCellValue(value);

        // Guardar el libro en un archivo (ajusta la ruta según tus necesidades)
        try (FileOutputStream outputStream = new FileOutputStream(filePath + "\\" + fileName)) {
            wb.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("Valor actualizado en Excel: " + value);
    }


    public void openBrowser(RemoteWebDriver driver, Properties prop, ReportiumClient reportiumClient) throws Throwable {
        try {
            reportiumClient.stepStart("Ingresa a TPV");
            String url = prop.getProperty("url");
            openBrowser(url, driver, reportiumClient);
            PerfectoLabUtils.assertTitle("Web & Mobile App Testing | Continuous Testing | Perfecto", reportiumClient);
            driver.getScreenshotAs(OutputType.BYTES);

        } catch (Exception e) {
            driver.getScreenshotAs(OutputType.BYTES);
            e.printStackTrace();
            System.out.println("Error al abrir el navegador");
            throw new Exception("Error al abrir el navegador");
        }
        reportiumClient.stepEnd();
}
/*
    public static int scenario(RemoteWebDriver driver, ReportiumClient reportiumClient, String sheetName, int rowNum) throws IOException {
        Sheet wbSheet = wb.getSheet(sheetName);
        readData(wbSheet, rowNum, "Nombre_Prueba");
        System.out.println(rowNum);
        return rowNum;
    }


 */
    public void loginTPVwithexcel(RemoteWebDriver driver, Properties prop, ReportiumClient reportiumClient, String sheetName, int rowNum) throws Throwable {
        try {
            reportiumClient.stepStart("Ingresa credenciales");
            Sheet wbSheet = wb.getSheet(sheetName);
            readData(wbSheet, rowNum, "UserName");
            writeInElement("//*[@id='username']", data, driver);
            readData(wbSheet, rowNum, "Password");
            writeInElement("//*[@id='password']", data, driver);//enter password
            driver.getScreenshotAs(OutputType.BYTES);

            WebElement assertUserName = driver.findElement(By.xpath("//*[@class='button ok']"));
            PerfectoLabUtils.assertContainsText(assertUserName, reportiumClient, "Continue");

            clickElement("//*[@class='button ok']", driver);//click on Continue
            checkElement("//*[contains(text(),'Busqueda de Cliente CSHS')]", driver);

            writeData(filePath, fileName, sheetName, rowNum, 5,"Test Escritura");


        } catch (Exception e) {
            driver.getScreenshotAs(OutputType.BYTES);
            e.printStackTrace();
            System.out.println("Login Fallido");
            throw new Exception("Login Fallido");
        }
        reportiumClient.stepEnd();
    }

    public void ClickLogoutOption(RemoteWebDriver driver, ReportiumClient reportiumClient) throws Exception {
        // TODO Auto-generated method stub
        driver.switchTo().defaultContent();
        System.out.println("Redirected back to main frame");
        Thread.sleep(10000);
        //driver.findElement(By.xpath(".//div[@class='menu-button menu-button-left']/a")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div/div[1]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//div[@class='profile-actions']/div[2]/a")).click();
        //driver.findElement(By.xpath(".//a[contains(text(),'Finalizar')]")).click();
        System.out.println("logged out from the application");
        driver.getScreenshotAs(OutputType.BYTES);
        Thread.sleep(10000);
    }
}

