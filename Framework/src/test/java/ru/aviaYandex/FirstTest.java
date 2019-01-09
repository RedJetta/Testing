package ru.aviaYandex;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;


import static org.junit.Assert.*;

public class FirstTest extends BaseTest {

    public static Search search;

    @BeforeClass
    public static void initial() {
        search = new Search(driver);
    }

    @Test
    public void ticketsSearchWithValidData() throws InterruptedException {
        driver.get("https://avia.yandex.ru");
        search.typeInputFrom("Москва");
        search.typeInputTo("Санкт-Питербург");
        search.clickOnCalendar();
        search.selectDepartureDate("13", "08", "2019");
        search.selectArrivalDate("14", "08", "2019");
        search.clickOnPeople();
        search.addAdults(2);
        search.clickOnSearch();
    }

    @Test
    public void invalidFromAndToFields(){
        driver.get("https://avia.yandex.ru");
        search.typeInputTo("Менск");
        search.typeInputFrom("На Берлин!");
        search.clickOnSearch();
        String title = driver.getTitle();
        assertEquals(title, "Неверно введены данные");
    }


    @Test(expected = NoSuchElementException.class)
    public void pastDate(){
        driver.get("https://avia.yandex.ru");
        search.clickOnCalendar();
        search.selectDepartureDate("10", "12", "1945");

    }
    @Test(expected = NoSuchElementException.class)
    public void futureDate(){
        driver.get("https://avia.yandex.ru");
        search.clickOnCalendar();
        search.selectDepartureDate("31", "10", "2100");
    }

}

