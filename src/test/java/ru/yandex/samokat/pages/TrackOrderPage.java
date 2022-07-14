package ru.yandex.samokat.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


// POM окна отслеживания заказа
public class TrackOrderPage extends DriveredPage {
    //Селектор изображения с надписью Заказ не найден
    private final By selectorNotFoundMessage = By.xpath(".//div[contains(@class, 'Track_NotFound')]//img[contains(@src, 'not-found')]");

    // Конструктор
    public TrackOrderPage(WebDriver driver, JavascriptExecutor jse) {
        super(driver, jse);
    }

    // Проверка отображения "Заказ не найден"
    public boolean isDisplayedNotFound() {
        new WebDriverWait(driver, 3);
        List<WebElement> elements = driver.findElements(selectorNotFoundMessage);
        return !elements.isEmpty();
    }
}
