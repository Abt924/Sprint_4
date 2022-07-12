package ru.yandex.samokat.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TrackOrderPage extends DriveredPage {

    public TrackOrderPage(WebDriver driver, JavascriptExecutor jse) {
        super(driver, jse);
    }
    private final By selectorNotFoundMessage = By.xpath(
            ".//div[contains(@class, 'Track_NotFound')]//img[contains(@src, 'not-found')]");

    public boolean isDisplayedNotFound(){
        new WebDriverWait(driver, 3);
        List<WebElement> elements = driver.findElements(selectorNotFoundMessage);
        return !elements.isEmpty();
    }
}
