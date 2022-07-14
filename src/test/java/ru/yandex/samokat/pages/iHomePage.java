package ru.yandex.samokat.pages;
import org.openqa.selenium.By;

public interface iHomePage {
    // URL страницы https://qa-scooter.praktikum-services.ru/
     final String url = "https://qa-scooter.praktikum-services.ru/";
    // Logo скутер
     final By selectorLogoScooter = By.xpath(".//a[contains(@class,'Header_LogoScooter')]");
    // Logo Yandex
     final By selectorLogoYandex = By.xpath(".//a[contains(@class,'Header_LogoYandex')]");
    // кнопка статус заказа
     final By selectorOrderStatusButton = By.xpath(".//button[contains(@class, 'Header') and text()='Статус заказа']");
    // Поле ввода номер заказа в хэдере
     final By selectorTrackNumberInput = By.xpath(
            ".//input[contains(@class, 'Header_Input') and contains(@placeholder,'номер заказа')]");
    // Кнопка Go
     final By selectorGoButton = By.xpath(
            ".//button[contains(@class, 'Header_Button') and text()='Go!']");
    //кнопка Куки
     final By selectorAcceptCookies = By.xpath(
             ".//button[contains(@class, 'App_CookieButton') or contains(text(),'привыкли')]");
    // Заказать верняя кнопка
     final By orderHeaderButton = By.xpath(".//div[contains(@class,'Header_Nav')]//button[text()='Заказать']");
    // Заказать нижняя кнопка
     final By orderFinishButton = By.xpath(".//div[contains(@class, 'Home_FinishButton')]//button[text()='Заказать']");
    // FAQ Аккордеон
     final By FAQItems = By.className("accordion__item");
    // Вопросы  элемента аккордеона
     final By FAQuestions = By.className("accordion__button");
    // Ответы элементы аккордеона
     final By FAQResponses = By.cssSelector("div[data-accordion-component=AccordionItemPanel]");
    // Развернутые ответы FAQ аккордеона
     final By FAQResponsesOpened = By.xpath(".//div[@class='accordion__panel' and not(@hidden)]");
}
