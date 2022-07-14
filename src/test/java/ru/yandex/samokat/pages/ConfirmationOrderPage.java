package ru.yandex.samokat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

// Окно подтверждения Заказа
public class ConfirmationOrderPage extends DriveredPage {
    // кнопка Да
    private final By selectorYes = By.xpath(".//button[text()='Да']");
    // кнопка Нет
    private final By selectorNo = By.xpath(".//button[text()='Нет']");
    // запрос подтверждения
    private final By selectorConfirmationPage = By.xpath(".//div[contains(text(),'Хотите оформить')]");

    //Конструктор с параметром WebDriver
    public ConfirmationOrderPage(WebDriver driver) {
        super(driver);
    }

    //Конструктор с параметром WebDriver, JavascriptExecutor
    public ConfirmationOrderPage(WebDriver driver, JavascriptExecutor jse) {
        super(driver, jse);
    }

    // Ожидание по кнопке Yes
    public void waitPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(selectorYes));
    }

    // Нажать кнопку Да
    public void pushYes() {
        WebElement buttonYes = driver.findElement(selectorYes);
        scrollAndClick(buttonYes);
    }
}
