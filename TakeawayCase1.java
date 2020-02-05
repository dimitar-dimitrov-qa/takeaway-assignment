package com.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TakeawayCase1 {

    /*
1. Open https://www.thuisbezorgd.nl/en/ with your favorite browser
2. Type 8888 as a postcode into the address field
3. Select 8888-alpha
4. Navigate to restaurants page
5. Verify that restaurants has been listed at this address on the restaurant page
6. Select ……………………………………. test restaurant from restaurant list
7. Add any item from the restaurant menu into the basket
8. Press the Order button and navigate to filling the address page (for address info look at
below)
9. Fill the form with ASAP delivery option
10. Select the payment amount from the combobox at the bottom of the page(Please select
the closest amount to order price. Example: if the order price is 11 Euro and if there the
closest option on combobox 13 Euro then select 13 Euro)
11. Click on Order and Pay button to finish your order process
12. Get the order reference number from latest page

Address : main street 2415 PostCode : 8888AA City : Enschede Name :TestUSer
PhoneNum :1234567890 e-mail :testuser@test.test
     */

    public WebDriver driver;
    public File file = new File("C:\\Users\\ThinkPad\\Downloads\\reports\\datafile.properties");
    public WebElement addressTitle;
    public String text;
    public WebElement refNumber;
    public String refNum;

    @Test
    void testCase1(){

        // open the web page
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ThinkPad\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.thuisbezorgd.nl/en/");

        // clear the field and enter the address code
        driver.findElement(By.id("imysearchstring")).clear();
        driver.findElement(By.id("imysearchstring")).sendKeys("8888");

        //select 8888-alpha and navigate to restaurants page
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#iautoCompleteDropDownContent > a")).click();
        driver.findElement(By.cssSelector("#reference > span")).click();

        // verify address
        addressTitle = driver.findElement(By.cssSelector(".topbar__title"));
        text = addressTitle.getText();
        System.out.println(" The address is: " + text);
        Assert.assertEquals(text, "8888-alpha");

        // select test restaurant
        driver.findElement(By.cssSelector("#irestaurantQ0ONNOO > div.detailswrapper > h2 > a")).click();

        // add meal
        driver.findElement(By.cssSelector("#popularQON30PNRN > div.meal.meal__top-button.js-meal-item > div.meal__wrapper > div.meal__description-texts.js-meal-description-text > span > span")).click();

        // order and filling the address
        driver.findElement(By.cssSelector("#ibasket > div.basket.basket-container__scroller > button")).click();
        driver.findElement(By.cssSelector("#iaddress")).sendKeys("main street 2415");
        driver.findElement(By.cssSelector("#ipostcode")).clear();
        driver.findElement(By.cssSelector("#ipostcode")).sendKeys("8888AA");
        driver.findElement(By.cssSelector("#itown")).sendKeys("Enschede");
        driver.findElement(By.cssSelector("#isurname")).sendKeys("TestUSer");
        driver.findElement(By.cssSelector("#iphonenumber")).sendKeys("1234567890");
        driver.findElement(By.cssSelector("#iemail")).sendKeys("testuser@test.test");

        // ASAP delivery
        driver.findElement(By.cssSelector("#ideliverytime > option:nth-child(1)")).click();

        //payment amount
        driver.findElement(By.cssSelector("#ipayswith > option:nth-child(2)")).click();

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
