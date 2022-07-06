package ru.yandex.samokat.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePageSamokat {
        // Заголовок страницы

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
        private WebDriver driver;



        //Конструктор с параметром
        public HomePageSamokat(WebDriver driver){
                this.driver = driver;
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

        }
