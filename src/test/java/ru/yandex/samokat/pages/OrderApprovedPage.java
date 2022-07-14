package ru.yandex.samokat.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

// Окно сообщения о принятии заказа с присвоенным номером заказа
public class OrderApprovedPage extends DriveredPage {
    // окно подтверждения
    private final By selectorApprovalPage = By.xpath(".//div[contains(text(),'оформлен')]");
    // кнопка Посмотреть статус
    private final By selectorStatus = By.xpath(".//button[contains(text(),'статус')]");
    // Номер заказа
    private final By selectorOrderNumber = By.xpath(".//div[contains(text(),'Номер заказа')]");

    //Конструктор с параметром WebDriver
    public OrderApprovedPage(WebDriver driver) {
        super(driver);
    }

    //Конструктор с параметром WebDriver, JavascriptExecutor
    public OrderApprovedPage(WebDriver driver, JavascriptExecutor jse) {
        super(driver, jse);
    }

    //кнопка проверить статус заказа
    public void pushOrderStatus() {
        WebElement buttonYes = driver.findElement(selectorStatus);
        scrollAndClick(buttonYes);
    }

    // Проверка появления окна (подвержения оформления заказа)
    public boolean isUp() {
        List<WebElement> elements = driver.findElements(selectorApprovalPage);
        if (elements.isEmpty()) {
            return false;
        }
        return true;
    }

}
