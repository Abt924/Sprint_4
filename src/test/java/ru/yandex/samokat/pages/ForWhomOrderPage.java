package ru.yandex.samokat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

// POM страницы вводе данных Для Кого, селекторы вынесены в интерфейс
public class ForWhomOrderPage extends DriveredPage implements iForWhom {

    // Конструктор с параметром WebDriver, JavascriptExecutor
    public ForWhomOrderPage(WebDriver driver, JavascriptExecutor jse) {
        super(driver, jse);
    }

    public void setName(String name) {
        driver.findElement(selectorNameField).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(selectorSurnameField).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(selectorAddressField).sendKeys(address);
    }

    public void setPhone(String phone) {
        driver.findElement(selectorPhoneField).sendKeys(phone);
    }

    public void setMetro(String metro) {
        driver.findElement(selectorMetroField).click();
        By selectorStationButton = By.xpath(String.format(selectorStationButtonStr, metro));
        WebElement stationButton = driver.findElement(selectorStationButton);
        scrollAndClick(stationButton);
    }

    public void pushNext() {
        WebElement button = driver.findElement(selectorNextButton);
        scrollAndClick(button);
    }
}
