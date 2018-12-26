package ru.aviaYandex;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SiteTest {

    public ChromeDriver driver;

    @Before
    public void initialDriver(){
        System.setProperty("webdriver.chrome.driver", "/home/maks/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void ticketsSearchTest() throws InterruptedException {
        driver.get("https://avia.yandex.ru");
        Thread.sleep(1000);

        WebElement inputFrom = driver.findElementById("from");
        WebElement inputTo = driver.findElementById("to");
        WebElement calendar = driver.findElementByClassName("datepicker-inputs_kb");
        WebElement peoples = driver.findElementByClassName("form-options-picker_kb__input");
        WebElement plus = driver.findElementByClassName("passengers_kb__increase");
        WebElement searchButton = driver.findElementByCssSelector("div.search-form_kb__button-find>button.y-button");

        inputFrom.clear();
        inputTo.clear();
        Thread.sleep(500);
        inputFrom.sendKeys("Минск");
        inputTo.sendKeys("Москва");
        Thread.sleep(1500);
        calendar.click();
        WebElement day = driver.findElementByCssSelector("div[data-date='27'][data-month='10']");
        Thread.sleep(1000);
        day.click();
        Thread.sleep(2000);
        peoples.click();
        Thread.sleep(500);
        for (int i = 0; i < 3; i++){
            plus.click();
            Thread.sleep(1000);
        }
        Thread.sleep(3000);
        searchButton.click();
        Thread.sleep(5000);
    }

    @After
    public void quitTest(){
        driver.quit();
    }
}