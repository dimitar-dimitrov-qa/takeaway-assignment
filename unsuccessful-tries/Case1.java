package com.seleniumtest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.seleniumtest.Main.driver;

public class Case1 {

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
    public void openBrowser(String browser){
        if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\ThinkPad\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ThinkPad\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }
    }

    @Test
    void testCase1() {
       // File file = new File("C:\\Users\\ThinkPad\\Downloads\\reports\\datafile.properties");

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\ThinkPad\\Downloads\\chromedriver_win32\\chromedriver.exe");
        //driver = new ChromeDriver();
        driver.get(prop.getProperty("URL"));
        driver.findElement(By.id("imysearchstring")).sendKeys(prop.getProperty("FirstAddress"));
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        wait = new WebDriverWait(driver, 15);
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#iautoCompleteDropDownContent > a")));
        //driver.findElement(By.cssSelector("#iautoCompleteDropDownContent > a"));
        driver.findElement(By.cssSelector("#iautoCompleteDropDownContent > a")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        driver.findElement(By.cssSelector("#reference > span")).click();
        driver.findElement(By.cssSelector("#irestaurantQ0ONNOO > div.detailswrapper > h2 > a")).click();
        //driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#popularQON30PNRN > div.meal.meal__top-button.js-meal-item > div.meal__wrapper > div.meal__description-texts.js-meal-description-text > span > span")));
        driver.findElement(By.cssSelector("#popularQON30PNRN > div.meal.meal__top-button.js-meal-item > div.meal__wrapper > div.meal__description-texts.js-meal-description-text > span > span")).click();
        //driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#ibasket > div.basket.basket-container__scroller > button")));
        driver.findElement(By.cssSelector("#ibasket > div.basket.basket-container__scroller > button")).click();
        driver.findElement(By.cssSelector("#iaddress")).sendKeys(prop.getProperty("Address"));
        driver.findElement(By.cssSelector("#ipostcode")).clear();
        driver.findElement(By.cssSelector("#ipostcode")).sendKeys(prop.getProperty("PostCode"));
        //driver.findElement(By.cssSelector("#ipostcode")).sendKeys("AA");
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
        refNumber = driver.findElement(By.cssSelector("body > div.needhelp-container > div > div > div > div.order-reference > span"));
        refNum = refNumber.getText();
        System.out.println(refNum);
        driver.close();
    }

    @Test
    void testCase2(){
        // System.out.println("hello");
        // System.setProperty("webdriver.gecko.driver", "C:\\Users\\ThinkPad\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        // WebDriver obj = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\ThinkPad\\Downloads\\chromedriver_win32\\chromedriver.exe");
        //driver = new ChromeDriver();
        driver.navigate().to("https://www.thuisbezorgd.nl/en/");
        //WebDriver obj = new ChromeDriver();
        //obj.get("https://www.thuisbezorgd.nl/en/");
        // WebElement addrInput = driver.findElement(By.cssSelector("#imysearchstring"));
        //WebElement addrInput = driver.findElement(By.id("imysearchstring"));
        //addrInput.sendKeys("8888");
        addrInput= driver.findElement(By.id("imysearchstring"));
        //driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        addrInput.sendKeys("88");
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        addrInput.sendKeys("88");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //driver.findElement(By.cssSelector("#iautoCompleteDropDownContent > a")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#iautoCompleteDropDownContent > a")));
        driver.findElement(By.cssSelector("#iautoCompleteDropDownContent > a")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        driver.findElement(By.cssSelector("#reference > span")).click();
        // Select 8888-alpha - NOT OK
        //WebElement addresTitle = driver.findElement(By.cssSelector("body > header > div.topbar-container > div > div.topbar__title-container"));
        //String text = addresTitle.getText();
        addressTitle = driver.findElement(By.cssSelector("body > header > div.topbar-container > div > div.topbar__title-container"));
        text = addressTitle.getText();
        System.out.println(text);
        // Verify that restaurants has been listed at this address on the restaurant page - NOT OK
        driver.findElement(By.cssSelector("#irestaurantQ0ONNOO > div.detailswrapper > h2 > a")).click();
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        wait=new WebDriverWait(driver, 15);
        salami = driver.findElement(By.cssSelector("#popularQON30PNRN > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2)"));
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#popularQON30PNRN > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2)")));
        salami.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
       // #popularQON30PNRN > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > span:nth-child(1) > span:nth-child(1)
        //driver.findElement(By.cssSelector("#popularQON30PNRN > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > span:nth-child(1) > span:nth-child(1)")).click();
        //driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
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
        refNumber = driver.findElement(By.cssSelector("body > div.needhelp-container > div > div > div > div.order-reference > span"));
        refNum = refNumber.getText();
        System.out.println(refNum);
        driver.close();
    }

}
