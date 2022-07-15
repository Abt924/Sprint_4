package ru.yandex.samokat.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.samokat.inputs.Order;

// POM домашней страницы
public class HomePageSamokat extends DriveredPage {

    public static final String URL = "https://qa-scooter.praktikum-services.ru/";

    // Logo скутер
    private final By selectorLogoScooter = By.xpath(".//a[contains(@class,'Header_LogoScooter')]");
    // Logo Yandex
    private final By selectorLogoYandex = By.xpath(".//a[contains(@class,'Header_LogoYandex')]");
    // кнопка статус заказа
    private final By selectorOrderStatusButton = By.xpath(".//button[contains(@class, 'Header') and text()='Статус заказа']");
    // Поле ввода номер заказа в хэдере
    private final By selectorTrackNumberInput = By.xpath(".//input[contains(@class, 'Header_Input') and contains(@placeholder,'номер заказа')]");
    // Кнопка Go
    private final By selectorGoButton = By.xpath(".//button[contains(@class, 'Header_Button') and text()='Go!']");
    //кнопка Куки
    private final By selectorAcceptCookies = By.xpath(".//button[contains(@class, 'App_CookieButton') or contains(text(),'привыкли')]");
    // Заказать верняя кнопка
    private final By orderHeaderButton = By.xpath(".//div[contains(@class,'Header_Nav')]//button[text()='Заказать']");

    // Заказать нижняя кнопка
    private final By orderFinishButton = By.xpath(".//div[contains(@class, 'Home_FinishButton')]//button[text()='Заказать']");
    // шаблон и фичи для выбора верхней/нижей кнопки
    public static final String templateButtonSelector = ".//div[contains(@class, '%s')]//button[text()='Заказать']";
    public static final String upperButtonClass = "Header_Nav";
    public static final String lowerButtonClass = "Home_FinishButton";

    // FAQ Аккордеон
    private final By FAQItems = By.className("accordion__item");
    // Вопросы  элемента аккордеона
    private final By FAQuestions = By.className("accordion__button");
    // Ответы элементы аккордеона
    private final By FAQResponses = By.cssSelector("div[data-accordion-component=AccordionItemPanel]");
    // Развернутые ответы FAQ аккордеона
    private final By FAQResponsesOpened = By.xpath(".//div[@class='accordion__panel' and not(@hidden)]");

    //Конструктор с параметром WebDriver
    public HomePageSamokat(WebDriver driver) {
        super(driver);
    }

    //Конструктор с параметром WebDriver, JavascriptExecutor
    public HomePageSamokat(WebDriver driver, JavascriptExecutor jse) {
        super(driver, jse);
    }

    // Открыть главную страницу
    public void open() {
        driver.get(URL);
    }

    //  дождаться куки
    public void waitCookies() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(selectorAcceptCookies));
    }

    // Принять Куки
    public void acceptCookies() {
        WebElement element = driver.findElement(selectorAcceptCookies);
        // System.out.println(element.getText());
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

    //Нажать кнопку Заказать
    //по выбору из тестовых данных в Order
    // upperButtonClass or middleButtonClass
    public void pushOrderUpperOrLowerButton(Order order) {
        String selectorButton = String.format(templateButtonSelector, order.getOrderButtonClassFeature());
        WebElement button = driver.findElement(By.xpath(selectorButton));
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
        new WebDriverWait(driver, 3).until((ExpectedConditions.elementToBeClickable(selectorTrackNumberInput)));
        trackInput.sendKeys(trackNumber);
    }

    // нажать кнопку Go!
    public void pushGo() {
        driver.findElement(selectorGoButton).click();
    }

}
