package ru.yandex.samokat.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// POM домашней страницы, селекторы вынесены в интерфейс
public class HomePageSamokat extends DriveredPage implements iHomePage {

    //Конструктор с параметром WebDriver
    public HomePageSamokat(WebDriver driver) {
        super(driver);
    }

    //Конструктор с параметром WebDriver, JavascriptExecutor
    public HomePageSamokat(WebDriver driver, JavascriptExecutor jse) {
        super(driver, jse);
    }

    // Принять Куки
    public void acceptCookies() {
        WebElement element = driver.findElement(selectorAcceptCookies);
        System.out.println(element.getText());
        scrollAndClick(element);
    }

    // количество элементов аккордеона
    public int getFAQuestionsCount() {
        List<WebElement> elements = driver.findElements(FAQuestions);
        return elements.size();
    }

    // получить лист FAQ accordion Buttons
    public List<WebElement> getFAQuestionButtons() {
        List<WebElement> elements = driver.findElements(FAQuestions);
        return elements;
    }

    // количество развернутых элементов аккордеона
    public int getFAQOpenedCount() {
        List<WebElement> elements = driver.findElements(FAQResponsesOpened);
        return elements.size();
    }

    // aria-controls кнопки FAQ аккордеона
    public String getButtonAriaControls(WebElement button) {
        return button.getAttribute("aria-controls");
    }

    // id ответа FAQ аккордеона
    public String getFAQResponseId() {
        WebElement element = driver.findElement(FAQResponsesOpened);
        return element.getAttribute("id");
    }

    // нажать кнопку Закать в Хэдере
    public void pushOrderInHeader() {
        driver.findElement(orderHeaderButton).click();
    }

    // нажать кнопку Заказать на странице
    public void pushOrderOnPage() {
        WebElement button = driver.findElement(orderFinishButton);
        scrollAndClick(button);
    }

    // перход по Лого Самокат
    public void followLogoScooter() {
        driver.findElement(selectorLogoScooter).click();
    }

    // переход по Лого Яндекс
    public void followLogoYandex() {
        driver.findElement(selectorLogoYandex).click();
    }

    // нажать кнопку статус заказа
    public void pushOrderStatus() {
        driver.findElement(selectorOrderStatusButton).click();
    }

    // ввести трек номер заказа
    public void setOrderNumber(String trackNumber) {
        WebElement trackInput = driver.findElement(selectorTrackNumberInput);
        new WebDriverWait(driver, 3).until(
                (ExpectedConditions.elementToBeClickable(selectorTrackNumberInput)));
        trackInput.sendKeys(trackNumber);
    }

    // нажать кнопку Go!
    public void pushGo() {
        driver.findElement(selectorGoButton).click();
    }

}
