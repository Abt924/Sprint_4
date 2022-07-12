package ru.yandex.samokat.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrackPage {
    //Заказ не найден
    private final By selectorNotFoundMessage = By.xpath(
            ".//div[contains(@class, 'Track_NotFound')]//img[contains(@src, 'not-found')]");
    private WebDriver driver;
    private JavascriptExecutor jse;

    //Конструктор с параметром webdriver
    public TrackPage(WebDriver driver){
        this.driver = driver;
    }
    public TrackPage(WebDriver driver, JavascriptExecutor jse){
        this.driver = driver;
        this.jse = jse;
    }

    private void scrollAndClick(WebElement element){
        jse.executeScript("arguments[0].scrollIntoView()", element);
        element.click();
    }

    public boolean isDisplayedNotFound(){
        new WebDriverWait(driver, 3);
        List<WebElement> elements = driver.findElements(selectorNotFoundMessage);
        if (elements.isEmpty()){ return false;}
        else return true;
    }
}
