package com.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import java.io.*;
import org.apache.poi.hssf.usermodel.*;
// import org.apache.poi.hssf.usermodel.XSSFSheet;
//import org.apache.poi.hssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*public class SeleniumElements{
    public WebDriver driver;
    String baseurl = "https://www.thuisbezorgd.nl/en/";
    public ExtentReports = reports;
    public ExtentTest = test;

    @Parameters({"browser"})
    @BeforeTest

    public void openBrowser(String browser){
        reports = new ExtentReports("C:\\Users\\ThinkPad\\Downloads\\reports");

        if (browser.equalsIgnoreCase("firefox")){
            System.out.println("Firefox Browser - Testing is started");
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\ThinkPad\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
            System.out.println("Firefox browser is open");
        }
        if (browser.equalsIgnoreCase("chrome")){
            System.out.println("Google Chrome Browser - Testing is started");
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ThinkPad\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            System.out.println("Google Chrome browser is open");
        }
    }
}*/

public class Main {
    public static   WebDriver driver=null;

    public static void main(String[] args) {
        // System.out.println("hello");
        // System.setProperty("webdriver.gecko.driver", "C:\\Users\\ThinkPad\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        // WebDriver obj = new FirefoxDriver();
       /* System.setProperty("webdriver.chrome.driver", "C:\\Users\\ThinkPad\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.thuisbezorgd.nl/en/");
        //WebDriver obj = new ChromeDriver();
        //obj.get("https://www.thuisbezorgd.nl/en/");
        // WebElement addrInput = driver.findElement(By.cssSelector("#imysearchstring"));
        WebElement addrInput = driver.findElement(By.id("imysearchstring"));
        addrInput.sendKeys("8888");
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        driver.findElement(By.cssSelector("#iautoCompleteDropDownContent > a")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        driver.findElement(By.cssSelector("#reference > span")).click();
        // Select 8888-alpha - NOT OK
        WebElement addresTitle = driver.findElement(By.cssSelector("body > header > div.topbar-container > div > div.topbar__title-container"));
        String text = addresTitle.getText();
        System.out.println(text);
        // Verify that restaurants has been listed at this address on the restaurant page - NOT OK
        driver.findElement(By.cssSelector("#irestaurantQ0ONNOO > div.detailswrapper > h2 > a")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        driver.findElement(By.cssSelector("#popularQON30PNRN > div.meal.meal__top-button.js-meal-item > div.meal__wrapper > div.meal__description-texts.js-meal-description-text > span > span")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        driver.findElement(By.cssSelector("#ibasket > div.basket.basket-container__scroller > button")).click();
        driver.findElement(By.cssSelector("#iaddress")).sendKeys("main street 2415");
        driver.findElement(By.cssSelector("#ipostcode")).sendKeys("AA");
        driver.findElement(By.cssSelector("#itown")).sendKeys("Enschede");
        driver.findElement(By.cssSelector("#isurname")).sendKeys("TestUSer");
        driver.findElement(By.cssSelector("#iphonenumber")).sendKeys("1234567890");
        driver.findElement(By.cssSelector("#iemail")).sendKeys("testuser@test.test");
        driver.findElement(By.cssSelector("#ideliverytime > option:nth-child(1)")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        driver.findElement(By.cssSelector("#ipayswith > option:nth-child(2)")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        driver.findElement(By.cssSelector("#main > div > div > div > div.grid-24.checkout-orderbutton.checkoutorderbutton > div.checkout-orderbutton-btn > input")).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement refNumber = driver.findElement(By.cssSelector("body > div.needhelp-container > div > div > div > div.order-reference > span"));
        String refNum = refNumber.getText();
        System.out.println(refNum);
        driver.close();
*/
        File file = new File("C:\\Users\\ThinkPad\\Downloads\\reports\\datafile.properties");

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ThinkPad\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("URL"));
        driver.findElement(By.id("imysearchstring")).sendKeys(prop.getProperty("FirstAddress"));
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        driver.findElement(By.cssSelector("#iautoCompleteDropDownContent > a")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        driver.findElement(By.cssSelector("#reference > span")).click();
        driver.findElement(By.cssSelector("#irestaurantQ0ONNOO > div.detailswrapper > h2 > a")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        driver.findElement(By.cssSelector("#popularQON30PNRN > div.meal.meal__top-button.js-meal-item > div.meal__wrapper > div.meal__description-texts.js-meal-description-text > span > span")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        driver.findElement(By.cssSelector("#ibasket > div.basket.basket-container__scroller > button")).click();
        driver.findElement(By.cssSelector("#iaddress")).sendKeys(prop.getProperty("Address"));
        //driver.findElement(By.cssSelector("#ipostcode")).sendKeys(prop.getProperty("PostCode"));
        driver.findElement(By.cssSelector("#ipostcode")).sendKeys("AA");
        driver.findElement(By.cssSelector("#itown")).sendKeys(prop.getProperty("City"));
        driver.findElement(By.cssSelector("#isurname")).sendKeys(prop.getProperty("Name"));
        driver.findElement(By.cssSelector("#iphonenumber")).sendKeys(prop.getProperty("PhoneNum"));
        driver.findElement(By.cssSelector("#iemail")).sendKeys(prop.getProperty("e-mail"));
        driver.findElement(By.cssSelector("#ideliverytime > option:nth-child(1)")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        driver.findElement(By.cssSelector("#ipayswith > option:nth-child(2)")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        driver.findElement(By.cssSelector("#main > div > div > div > div.grid-24.checkout-orderbutton.checkoutorderbutton > div.checkout-orderbutton-btn > input")).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement refNumber = driver.findElement(By.cssSelector("body > div.needhelp-container > div > div > div > div.order-reference > span"));
        String refNum = refNumber.getText();
        System.out.println(refNum);
        driver.close();
    }
}
