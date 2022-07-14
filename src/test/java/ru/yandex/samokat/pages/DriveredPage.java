package ru.yandex.samokat.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriveredPage {
    protected WebDriver driver;
    protected JavascriptExecutor jse;

    // Конструктор с параметром WebDriver
    public DriveredPage(WebDriver driver) {
        this.driver = driver;
    }

    // Конструктор с параметром WebDriver, JavascriptExecutor
    public DriveredPage(WebDriver driver, JavascriptExecutor jse) {
        this.driver = driver;
        this.jse = jse;
    }

    protected void scrollAndClick(WebElement element) {
        jse.executeScript("arguments[0].scrollIntoView()", element);
        element.click();
    }

}
