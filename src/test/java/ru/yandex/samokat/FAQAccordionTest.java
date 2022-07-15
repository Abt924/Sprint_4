package ru.yandex.samokat;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.samokat.pages.HomePageSamokat;

import java.util.List;

// Тест логики работы выпадающего списка Вопрос-Ответ
public class FAQAccordionTest extends BaseUITest {

    // Есть хоть одна кнопка аккордеона
    @Test
    public void FAQButtonMoreThen0Test() {
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        objHomePage.open();
        objHomePage.waitCookies();
        int buttonCount = objHomePage.getFAQuestionsCount();
        assertTrue("Buttons in FAQ accordion should be more than 0", buttonCount > 0);
    }

    // Для ненажатых кнопок нет выпадающих ответов
    @Test
    public void noClickNoDroppedResponseTest() {
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        objHomePage.open();
        int buttonCount = objHomePage.getFAQuestionsCount();
        List<WebElement> buttons = objHomePage.getFAQuestionButtons();
        for (WebElement button : buttons) {
            jse.executeScript("arguments[0].scrollIntoView()", button);
            //button.click(); нет кликов только скролл
            int droppedResponses = objHomePage.getFAQOpenedCount();
            assertEquals("Expected that no dropped element without click", 0, droppedResponses);
        }
    }

    // Для нажатой кнопки только один выпадающий ответ
    @Test
    public void oneClickOneDroppedResponseTest() {
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        objHomePage.open();
        int buttonCount = objHomePage.getFAQuestionsCount();
        List<WebElement> buttons = objHomePage.getFAQuestionButtons();
        for (WebElement button : buttons) {
            jse.executeScript("arguments[0].scrollIntoView()", button);
            button.click();
            int droppedResponses = objHomePage.getFAQOpenedCount();
            assertEquals("Expected only one element drop with button click", 1, droppedResponses);
        }
    }

    // Проверка соответствия нажатой кнопки аккордеона и выпадающего ответа
    // aria-controls вопроса соответствует id ответа
    @Test
    public void dropResponseTest() {
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        objHomePage.open();
        int buttonCount = objHomePage.getFAQuestionsCount();
        List<WebElement> buttons = objHomePage.getFAQuestionButtons();
        for (WebElement button : buttons) {
            jse.executeScript("arguments[0].scrollIntoView()", button);
            button.click();
            new WebDriverWait(driver, 6);
            String buttonAttr = objHomePage.getButtonAriaControls(button);
            String droppedResponseId = objHomePage.getFAQResponseId();
            assertEquals("Expected that pressed button attr = dropped element id ", buttonAttr, droppedResponseId);
        }
    }


}
