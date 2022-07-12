package ru.yandex.samokat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForWhomOrderPage {
    // Кнопка Далее $x(".//button[text()='Далее']")
    private final By selectorNextButton = By.xpath(".//button[contains(text(),'Далее')]");
    // поле ввода Имя $x(".//input[contains(@placeholder, 'Имя')]")
    private final By selectorNameField = By.xpath(".//input[contains(@placeholder, 'Имя')]");
    // поле ввода Фамилия $x(".//input[contains(@placeholder, 'Фамилия')]")
    private final By selectorSurnameField = By.xpath(".//input[contains(@placeholder, 'Фамилия')]");
    // поле ввода Адрес $x(".//input[contains(@placeholder, 'Адрес')]")
    private final By selectorAddressField = By.xpath(".//input[contains(@placeholder, 'Адрес')]");
    // поле ввода Метро $x(".//input[contains(@placeholder, 'метро')]")
    private final By selectorMetroField = By.xpath(".//input[contains(@placeholder, 'метро')]");
    // список станций кнопка станции  $x(".//div[@class='Order_Text__2broi' and contains(text(), 'Сокольники')]")
    private final String selectorStationButtonStr = ".//div[@class='Order_Text__2broi' and contains(text(), '%s')]";
    //private  By selectorStationButton = By.xpath(".//div[@class='Order_Text__2broi' and contains(text(), 'Сокольники')]");
    // поле ввода Телефон $x(".//input[contains(@placeholder, 'Телефон')]")
    private final By selectorPhoneField = By.xpath(".//input[contains(@placeholder, 'Телефон')]");

    private WebDriver driver;
    private JavascriptExecutor jse;

    //Конструктор с параметром webdriver
    public ForWhomOrderPage(WebDriver driver, JavascriptExecutor jse){
        this.driver = driver;
        this.jse = jse;
    }

    private void scrollAndClick(WebElement element){
        jse.executeScript("arguments[0].scrollIntoView()", element);
        element.click();
    }

    public void setName(String name){
        driver.findElement(selectorNameField).sendKeys(name);
    }

    public void setSurname(String surname){
        driver.findElement(selectorSurnameField).sendKeys(surname);
    }

    public void setAddress(String address){
        driver.findElement(selectorAddressField).sendKeys(address);
    }

    public void setPhone(String phone){
        driver.findElement(selectorPhoneField).sendKeys(phone);
    }

    public void setMetro(String metro){
        driver.findElement(selectorMetroField).click();
        By selectorStationButton = By.xpath(String.format(selectorStationButtonStr, metro));
        WebElement stationButton = driver.findElement(selectorStationButton);
        scrollAndClick(stationButton);
    }

    public void pushNext(){
        WebElement button = driver.findElement(selectorNextButton);
        scrollAndClick(button);
    }

}
