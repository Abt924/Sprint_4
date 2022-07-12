package ru.yandex.samokat.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePageSamokat extends DriveredPage{
        // URL страницы https://qa-scooter.praktikum-services.ru/
        private final String url = "https://qa-scooter.praktikum-services.ru/";
        // Logo скутер
        private final By selectorLogoScooter = By.xpath(".//a[contains(@class,'Header_LogoScooter')]");
        // Logo Yandex
        private final By selectorLogoYandex = By.xpath(".//a[contains(@class,'Header_LogoYandex')]");
        // кнопка статус заказа
        private final By selectorOrderStatusButton = By.xpath(".//button[contains(@class, 'Header') and text()='Статус заказа']");
        // Поле ввода номер заказа в хэдере
        private final By selectorTrackNumberInput = By.xpath(
                ".//input[contains(@class, 'Header_Input') and contains(@placeholder,'номер заказа')]");
        // Кнопка Go
        private final By selectorGoButton = By.xpath(
                ".//button[contains(@class, 'Header_Button') and text()='Go!']");

        //кнопка Куки
        private final By selectorAcceptCookies = By.xpath(".//button[@class='App_CookieButton__3cvqF' or contains(text(),'привыкли')]");

        // Заказать верняя кнопка
        private final By orderHeaderButton = By.xpath(".//div[@class='Header_Nav__AGCXC'// button[text()='Заказать']");
        // Заказать нижняя кнопка
        private final By orderFinishButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']//button[text()='Заказать']");

        // FAQ Аккордеон
        private final By FAQItems = By.className("accordion__item");
        // Вопросы  элемента аккордеона
        private final By FAQuestions = By.className("accordion__button");
        // Ответы элементы аккордеона
        private final By FAQResponses = By.cssSelector("div[data-accordion-component=AccordionItemPanel]");
        // Развернутые ответы FAQ аккордеона
        private final By FAQResponsesOpened = By.xpath(".//div[@class='accordion__panel' and not(@hidden)]");

        //Конструктор с параметром webdriver
        public HomePageSamokat(WebDriver driver){
                super(driver);
        }
        public HomePageSamokat(WebDriver driver, JavascriptExecutor jse){ super(driver, jse);}

        // Принять Куки
        public void acceptCookies(){
                WebElement element = driver.findElement(selectorAcceptCookies);
                scrollAndClick(element);
        }

        // количество элементов аккордеона
        public int getFAQuestionsCount(){
                List<WebElement> elements = driver.findElements(FAQuestions);
                return elements.size();
        }

        // получить лист FAQ accordion Buttons
        public List<WebElement> getFAQuestionButtons(){
                List<WebElement> elements = driver.findElements(FAQuestions);
                return elements;
        }

        // количество развернутых элементов аккордеона
        public int getFAQOpenedCount(){
                List<WebElement> elements = driver.findElements(FAQResponsesOpened);
                return elements.size();
        }

        // aria-controls кнопки FAQ аккордеона
        public String getButtonAriaControls(WebElement button){
                return button.getAttribute("aria-controls");
        }

        // id ответа FAQ аккордеона
        public String getFAQResponseId(){
                WebElement element = driver.findElement(FAQResponsesOpened);
                return element.getAttribute("id");
        }

        public void pushOrderInHeader(){
                driver.findElement(orderHeaderButton).click();
        }

        public void pushOrderOnPage(){
                WebElement button = driver.findElement(orderFinishButton);
                scrollAndClick(button);
        }

        public void followLogoScooter(){
                driver.findElement(selectorLogoScooter).click();
        }

        public void followLogoYandex(){
                driver.findElement(selectorLogoYandex).click();
        }

        public void pushOrderStatus(){
                driver.findElement(selectorOrderStatusButton).click();
        }

        public void setOrderNumber(String trackNumber){
                WebElement trackInput =  driver.findElement(selectorTrackNumberInput);
                new WebDriverWait(driver, 3).until(
                        (ExpectedConditions.elementToBeClickable(selectorTrackNumberInput)));
                //scrollAndClick(trackInput);
                //System.out.println("TrackInput  " trackInput.isDisplayed() + trackInput.isEnabled() + trackInput.getAttribute("value") );
                trackInput.sendKeys(trackNumber);
                //System.out.println("TrackInput  " + trackInput.isDisplayed() + trackInput.isEnabled() + trackInput.getAttribute("value") );

        }

        public void pushGo(){
                driver.findElement(selectorGoButton).click();
        }

}
