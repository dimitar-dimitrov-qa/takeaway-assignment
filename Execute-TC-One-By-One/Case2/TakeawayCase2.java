package com.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TakeawayCase2 {

    /*
1. Open https://www.thuisbezorgd.nl/en/ with your favorite browser
2. Type 8888 as an address
3. Select 8888-alpha
4. Navigate to restaurants page
5. Select ……………………………………. test restaurant from restaurant list
6. Add one menu from menu list
7. Press the Order button and navigate to form page
8. Fill the form with ASAP option
9. Click on Order and Pay button to finish order your process
10. Get the order reference number from latest page

Address : main street 2415 PostCode : 8888AA City : Enschede Name :TestUSer
PhoneNum :1234567890 e-mail :testuser@test.test

     */

    public WebDriver driver;
    public WebElement addressTitle;
    public String text;
    public WebElement refNumber;
    public String refNum;

    @Test
    void testCase2() {

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

        // open the web page
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ThinkPad\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("URL"));

        // clear the field and enter the address code
        driver.findElement(By.id("imysearchstring")).sendKeys(prop.getProperty("FirstAddress"));

        //select 8888-alpha and navigate to restaurants page
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#iautoCompleteDropDownContent > a")).click();
        driver.findElement(By.cssSelector("#reference > span")).click();

        // select test restaurant
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#irestaurantQ0ONNOO > div.detailswrapper > h2 > a")).click();

        // add meal
        driver.findElement(By.cssSelector("#popularQON30PNRN > div.meal.meal__top-button.js-meal-item > div.meal__wrapper > div.meal__description-texts.js-meal-description-text > span > span")).click();

        // order and filling the address
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        driver.findElement(By.cssSelector("#ibasket > div.basket.basket-container__scroller > button")).click();
        driver.findElement(By.cssSelector("#iaddress")).sendKeys(prop.getProperty("Address"));
        driver.findElement(By.cssSelector("#ipostcode")).clear();
        driver.findElement(By.cssSelector("#ipostcode")).sendKeys(prop.getProperty("PostCode"));
        driver.findElement(By.cssSelector("#itown")).sendKeys(prop.getProperty("City"));
        driver.findElement(By.cssSelector("#isurname")).sendKeys(prop.getProperty("Name"));
        driver.findElement(By.cssSelector("#iphonenumber")).sendKeys(prop.getProperty("PhoneNum"));
        driver.findElement(By.cssSelector("#iemail")).sendKeys(prop.getProperty("e-mail"));

        // ASAP delivery
        driver.findElement(By.cssSelector("#ideliverytime > option:nth-child(1)")).click();

        //payment amount
        driver.findElement(By.cssSelector("#ipayswith > option:nth-child(1)")).click();

        // finish the order
        driver.findElement(By.cssSelector("#main > div > div > div > div.grid-24.checkout-orderbutton.checkoutorderbutton > div.checkout-orderbutton-btn > input")).click();

        // order reference number
        refNumber = driver.findElement(By.cssSelector("body > div.needhelp-container > div > div > div > div.order-reference > span"));
        refNum = refNumber.getText();
        System.out.println("The order reference number is: " + refNum);

        // close the browser
        driver.close();
    }
}
