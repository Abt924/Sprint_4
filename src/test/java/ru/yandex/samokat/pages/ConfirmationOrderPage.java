package ru.yandex.samokat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConfirmationOrderPage {
    // Да
    private final By selectorYes = By.xpath(".//button[text()='Да']");
    // Нет
    private final By selectorNo = By.xpath(".//button[text()='Нет']");
    // запрос подтверждения
    private final By selectorConfirmationPage = By.xpath(".//div[contains(text(),'Хотите оформить')]");

    private WebDriver driver;
    private JavascriptExecutor jse;

    //Конструктор с параметром webdriver
    public ConfirmationOrderPage(WebDriver driver){
        this.driver = driver;
    }

    public ConfirmationOrderPage(WebDriver driver, JavascriptExecutor jse){
        this.driver = driver;
        this.jse = jse;
    }

    private void scrollAndClick(WebElement element){
        jse.executeScript("arguments[0].scrollIntoView()", element);
        element.click();
    }

    public void waitPage(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(selectorYes));

    }

    public void pushYes(){
        WebElement buttonYes = driver.findElement(selectorYes);
        scrollAndClick(buttonYes);
    }

}
