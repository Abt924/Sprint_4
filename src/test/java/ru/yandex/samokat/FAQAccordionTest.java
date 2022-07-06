package ru.yandex.samokat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.samokat.pages.HomePageSamokat;

import java.util.List;

public class FAQAccordionTest {
    private WebDriver driver;
    private JavascriptExecutor jse;
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        jse = (JavascriptExecutor)driver;
    }

    @Test
    public void FAQButtonMoreThen0Test(){
        driver.get(url);
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        int buttonCount = objHomePage.getFAQuestionsCount();
        assertTrue("Buttons in FAQ accordion should be more than 0", buttonCount>0);
    }

    @Test
    public void noClickNoDroppedResponseTest(){
        driver.get(url);
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        int buttonCount = objHomePage.getFAQuestionsCount();
        List<WebElement> buttons = objHomePage.getFAQuestionButtons();
        for (WebElement button:buttons) {
            jse.executeScript("arguments[0].scrollIntoView()", button);
            //button.click(); нет кликов только скролл
            int droppedResponses = objHomePage.getFAQOpenedCount();
            assertEquals("Expected that no dropped element without click", 0, droppedResponses);
        }
    }

    @Test
    public void oneClickOneDroppedResponseTest(){
        driver.get(url);
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        int buttonCount = objHomePage.getFAQuestionsCount();
        List<WebElement> buttons = objHomePage.getFAQuestionButtons();
        for (WebElement button:buttons) {
            jse.executeScript("arguments[0].scrollIntoView()", button);
            button.click();
            int droppedResponses = objHomePage.getFAQOpenedCount();
            assertEquals("Expected only one element drop with button click", 1, droppedResponses);
        }
    }

    @Test
    public void dropResponseTest(){
        // Проверка соответствия нажатой кнопки аккордеона и выпадающего ответа
        driver.get(url);
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        int buttonCount = objHomePage.getFAQuestionsCount();
        List<WebElement> buttons = objHomePage.getFAQuestionButtons();
        for (WebElement button:buttons) {
            jse.executeScript("arguments[0].scrollIntoView()", button);
            button.click();
            new WebDriverWait(driver, 6);
            String buttonAttr = objHomePage.getButtonAriaControls(button);
            String droppedResponseId = objHomePage.getFAQResponseId();
            assertEquals("Expected that pressed button attr = dropped element id ", buttonAttr, droppedResponseId);
        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
