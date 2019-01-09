package ru.aviaYandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {
    public WebDriver driver;
    @FindBy(id = "from")
    private WebElement inputFrom;

    @FindBy(id = "to")
    private WebElement inputTo;
    @FindBy(className = "datepicker-inputs_kb")
    private WebElement calendarButton;

    @FindBy(className = "form-options-picker_kb__input")
    private WebElement peoplesButton;

    @FindBy(css = ".form-options_kb__passengers-adults button.passengers_kb__increase")
    private WebElement adultPlusButton;

    @FindBy(css = "div.search-form_kb__button-find>button.y-button")
    private WebElement searchButton;

    private String DATE_PATH = "div[data-date=' %s'][data-month='%s'][data-year='%s']";

    public Search(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeInputFrom(String from){
        inputFrom.clear();
        inputFrom.sendKeys(from);
    }

    public void typeInputTo(String to){
        inputTo.clear();
        inputTo.sendKeys(to);
    }

    public void clickOnCalendar(){
        calendarButton.click();

    }

    public void selectDepartureDate(String departureDay, String departureMonth, String departureYear){
        WebElement departure = driver.findElement(By.cssSelector("div[data-date='" + departureDay + "'][data-month='" + departureMonth + "'][data-year='" + departureYear + "']"));
        departure.click();
    }

    public void selectArrivalDate(String arrivalDay, String arrivalMonth, String arrivalYear){
        WebElement arrival = driver.findElement(By.cssSelector(String.format(DATE_PATH, arrivalDay,  arrivalMonth, arrivalYear)));
        arrival.click();
    }
    public void clickOnPeople(){
        peoplesButton.click();
    }

    public void addAdults(Integer number){
        for(int i = 0; i < number; i++)
            adultPlusButton.click();
    }

    public void clickOnSearch(){
        searchButton.click();
    }
}