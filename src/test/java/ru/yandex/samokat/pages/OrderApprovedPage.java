package ru.yandex.samokat.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderApprovedPage {
    // окно подтверждения
    private final By selectorApprovalPage = By.xpath(".//div[contains(text(),'оформлен')]");
    // кнопка Посмотреть статус
    private final By selectorStatus = By.xpath(".//button[contains(text(),'статус')]");
    // Номер заказа
    private final By selectorOrderNumber = By.xpath(".//div[contains(text(),'Номер заказа')]");

    private WebDriver driver;
    private JavascriptExecutor jse;

    //Конструктор с параметром webdriver
    public OrderApprovedPage(WebDriver driver){
        this.driver = driver;
    }

    public OrderApprovedPage(WebDriver driver, JavascriptExecutor jse){
        this.driver = driver;
        this.jse = jse;
    }

    private void scrollAndClick(WebElement element){
        jse.executeScript("arguments[0].scrollIntoView()", element);
        element.click();
    }

    public void pushOrderStatus(){
        WebElement buttonYes = driver.findElement(selectorStatus);
        scrollAndClick(buttonYes);
    }

    public boolean isUp(){
        List<WebElement> elements = driver.findElements(selectorApprovalPage);
        if(elements.isEmpty()){ return false;}
        return true;
    }

}
