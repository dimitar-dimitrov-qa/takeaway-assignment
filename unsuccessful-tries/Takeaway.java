package com.seleniumtest;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Takeaway {

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
     */

    public Properties prop = new Properties();
    public WebDriver driver;
    public File file = new File("C:\\Users\\ThinkPad\\Downloads\\reports\\datafile.properties");
    public WebElement addressTitle;
    public String text;
    public WebElement refNumber;
    public String refNum;
    public WebElement addrInput;
    public WebElement salami;
    public WebElement autocomplete;
    //public WebDriverWait wait=new WebDriverWait(driver, 15);
    public WebDriverWait wait;



    @Parameters({"browser"})

    @BeforeTest
    public void selectBrowser(String browser){
        if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\ThinkPad\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ThinkPad\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        if (browser.equalsIgnoreCase("IE")){
            System.setProperty("webdriver.ie.driver", "C:\\Users\\ThinkPad\\Downloads\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
    }

    @Test(priority = 1)
    void openTheSite(){
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        //load properties file
        try {
            prop.load(fileInput);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    //fileInput = new FileInputStream(file);
    //prop.load(fileInput);
        driver.get(prop.getProperty("URL"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test(priority = 2)
    void addressPostcode(){
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        //load properties file
        try {
            prop.load(fileInput);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        //driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        //wait = new WebDriverWait(driver, 15);
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("imysearchstring")));
        WebElement mySearch = driver.findElement(By.cssSelector("#imysearchstring"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        mySearch.clear();
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#imysearchstring")).sendKeys(prop.getProperty("FirstAddress"));
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(priority = 3)
    void selectAlpha(){
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        //load properties file
        try {
            prop.load(fileInput);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#iautoCompleteDropDownContent > a")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#reference > span")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test(priority = 4)
    void verifyAlpha() {
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        //load properties file
        try {
            prop.load(fileInput);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        //.topbar__title
        addressTitle = driver.findElement(By.cssSelector(".topbar__title"));
        text = addressTitle.getText();
        Assert.assertEquals(text, "8888-alpha");
    }

    @Test(priority = 5)
    void selectRestaurant(){
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        //load properties file
        try {
            prop.load(fileInput);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        //driver.findElement(By.cssSelector("#irestaurantQ0ONNOO > div:nth-child(2) > h2:nth-child(1) > a:nth-child(1)")).click();
        /*<a class="restaurantname" href="/en/qa-restaurant-selenium" itemprop="name">
                TEST Restaurant Selenium                    </a>  */
                driver.findElement(By.cssSelector("#irestaurantQ0ONNOO > div.detailswrapper > h2 > a")).click();
        //driver.findElement(By.cssSelector("#irestaurantQ0ONNOO > div.detailswrapper > h2 > a")).click();
    }

    @Test(priority = 6)
    void addMeal(){
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        //load properties file
        try {
            prop.load(fileInput);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        //driver.findElement(By.cssSelector("#popularQON30PNRN > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > span:nth-child(1) > span:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#popularQON30PNRN > div.meal.meal__top-button.js-meal-item > div.meal__wrapper > div.meal__description-texts.js-meal-description-text > span > span")).click();
        //driver.findElement(By.id("#popularQON30PNRN")).click();
        //salami = driver.findElement(By.cssSelector("#popularQON30PNRN > div:nth-child(1) > div:nth-child(2)"));
        //salami = driver.findElement(By.cssSelector(".icon-search"));
        //new Actions(driver).moveToElement(salami).perform();
        //salami.click();
        //driver.findElement(By.cssSelector(".menu-meal-search-input")).sendKeys("salami");
        //salami.sendKeys("salami");
        //WebElement addMeal = driver.findElement(By.cssSelector("#QNRR0O5N"));
        //new Actions(driver).moveToElement(addMeal).perform();
        //addMeal.click();
        //Actions actions = new Actions(driver);
        //WebElement menuHoverLink = driver.findElement(By.linkText("Salami"));
        //actions.moveToElement(menuHoverLink);
        //driver.findElement(By.cssSelector("#popularQON30PNRN > div:nth-child(1) > div:nth-child(2)")).sendKeys(Keys.ENTER);
        //menuHoverLink.sendKeys(Keys.ENTER);
        //menuHoverLink.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test(priority = 7)
    void orderAndForm(){
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        //load properties file
        try {
            prop.load(fileInput);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        //driver.findElement(By.cssSelector(".basket__order-button")).click();
        driver.findElement(By.cssSelector("body > nav > div > button > div")).click();
        //.basket__order-button
        driver.findElement(By.cssSelector("#ibasket > div.basket.basket-container__scroller > button")).click();
        driver.findElement(By.cssSelector("#iaddress")).sendKeys(prop.getProperty("Address"));
        driver.findElement(By.cssSelector("#ipostcode")).clear();
        driver.findElement(By.cssSelector("#ipostcode")).sendKeys(prop.getProperty("PostCode"));
        driver.findElement(By.cssSelector("#itown")).sendKeys(prop.getProperty("City"));
        driver.findElement(By.cssSelector("#isurname")).sendKeys(prop.getProperty("Name"));
        driver.findElement(By.cssSelector("#iphonenumber")).sendKeys(prop.getProperty("PhoneNum"));
        driver.findElement(By.cssSelector("#iemail")).sendKeys(prop.getProperty("e-mail"));
    }

    @Test(priority = 7)
    void orderASAP(){
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        //load properties file
        try {
            prop.load(fileInput);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("#ideliverytime > option:nth-child(1)")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
    }

    @Test(priority = 8)
    void paymentAmount(){
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        //load properties file
        try {
            prop.load(fileInput);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("#ipayswith > option:nth-child(2)")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
    }

    @Test(priority = 8)
    void executeOrder(){
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        //load properties file
        try {
            prop.load(fileInput);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("#main > div > div > div > div.grid-24.checkout-orderbutton.checkoutorderbutton > div.checkout-orderbutton-btn > input")).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @Test(priority = 9)
    /*void refNumber(){
        FileOutputStream fileOutput = null;
        try {
            fileOutput = new FileOutputStream(file);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        refNumber = driver.findElement(By.cssSelector("body > div.needhelp-container > div > div > div > div.order-reference > span"));
        refNum = refNumber.getText();
        fileOutput.;
        System.out.println(refNum);
        driver.close();
    } */
    void refNumber(String args[]){
        refNumber = driver.findElement(By.cssSelector("body > div.needhelp-container > div > div > div > div.order-reference > span"));
        refNum = refNumber.getText();
        String s = refNum.toString();
        try{
            FileOutputStream fout=new FileOutputStream("refNumber.txt");
           // String s="Welcome to javaTpoint.";
            byte b[]=s.getBytes();//converting string into byte array
            fout.write(b);
            fout.close();
            System.out.println("success...");
        }catch(Exception e){System.out.println(e);}
        driver.close();
    }

   /* @Test(priority = 9)
    void refNumber(String[] args) {

        String content = "This is the content to write into file\n";

        // If the file doesn't exists, create and write to it
        // If the file exists, truncate (remove all content) and write to it
        try (FileWriter writer = new FileWriter();  //("orderNumber.log");
             BufferedWriter bw = new BufferedWriter(writer)) {

            bw.write(content);

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

    } */



    /*@AfterMethod
    public void tearDown(){
        driver.close();
    }*/
}
