package ru.yandex.samokat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import ru.yandex.samokat.pages.iAccordion;
import ru.yandex.samokat.pages.FAQAccordion;
import ru.yandex.samokat.pages.HomePageSamokat;

// Тест выпадающего списка Вопрос-Ответ
// отдельные тесты каждому вопросу
public class QuestionAnswerAccordionTest {
    private WebDriver driver;
    private JavascriptExecutor jse;
    private final String url = "https://qa-scooter.praktikum-services.ru/";


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        jse = (JavascriptExecutor) driver;

    }

    @Test
    public void priceQuestionTest() {
        final String expQuestion = "Сколько это стоит? И как оплатить?";
        final String expAnswer = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        driver.get(url);
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        FAQAccordion objAccordion = new FAQAccordion(driver, jse);
        objAccordion.askQuestion(iAccordion.selectorPriceQuestion);
        objAccordion.getFollowingAnswer();
        assertTrue("Ответ должен быть показан ", objAccordion.isAnswerNotHidden());
        assertEquals("Текст вопроса не совпадает с ожидаемым",
                expQuestion, objAccordion.getQuestionText());
        assertEquals("Текст ответа не совпадает с ожидаемым",
                expAnswer, objAccordion.getAnswerText());
    }

    @Test
    public void wantsMoreQuestionTest() {
        final String expQuestion = "Хочу сразу несколько самокатов! Так можно?";
        final String expAnswer = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        driver.get(url);
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        FAQAccordion objAccordion = new FAQAccordion(driver, jse);
        objAccordion.askQuestion(iAccordion.selectorWantsMoreQuestion);
        objAccordion.getFollowingAnswer();
        assertTrue("Ответ должен быть показан ", objAccordion.isAnswerNotHidden());
        assertEquals("Текст вопроса не совпадает с ожидаемым",
                expQuestion, objAccordion.getQuestionText());
        assertEquals("Текст ответа не совпадает с ожидаемым",
                expAnswer, objAccordion.getAnswerText());
    }

    @Test
    public void rentTimeQuestionTest() {
        final String expQuestion = "Как рассчитывается время аренды?";
        final String expAnswer = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        driver.get(url);
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        FAQAccordion objAccordion = new FAQAccordion(driver, jse);
        objAccordion.askQuestion(iAccordion.selectorRentTimeQuestion);
        objAccordion.getFollowingAnswer();
        assertTrue("Ответ должен быть показан ", objAccordion.isAnswerNotHidden());
        assertEquals("Текст вопроса не совпадает с ожидаемым",
                expQuestion, objAccordion.getQuestionText());
        assertEquals("Текст ответа не совпадает с ожидаемым",
                expAnswer, objAccordion.getAnswerText());
    }

    @Test
    public void rentTodayQuestionTest() {
        final String expQuestion = "Можно ли заказать самокат прямо на сегодня?";
        final String expAnswer = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        driver.get(url);
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        FAQAccordion objAccordion = new FAQAccordion(driver, jse);
        objAccordion.askQuestion(iAccordion.selectorRentTodayQuestion);
        objAccordion.getFollowingAnswer();
        assertTrue("Ответ должен быть показан ", objAccordion.isAnswerNotHidden());
        assertEquals("Текст вопроса не совпадает с ожидаемым",
                expQuestion, objAccordion.getQuestionText());
        assertEquals("Текст ответа не совпадает с ожидаемым",
                expAnswer, objAccordion.getAnswerText());
    }

    @Test
    public void extendOrReturnQuestionTest() {
        final String expQuestion = "Можно ли продлить заказ или вернуть самокат раньше?";
        final String expAnswer = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        driver.get(url);
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        FAQAccordion objAccordion = new FAQAccordion(driver, jse);
        objAccordion.askQuestion(iAccordion.selectorExtendOrReturnQuestion);
        objAccordion.getFollowingAnswer();
        assertTrue("Ответ должен быть показан ", objAccordion.isAnswerNotHidden());
        assertEquals("Текст вопроса не совпадает с ожидаемым",
                expQuestion, objAccordion.getQuestionText());
        assertEquals("Текст ответа не совпадает с ожидаемым",
                expAnswer, objAccordion.getAnswerText());
    }

    @Test
    public void chargerQuestionTest() {
        final String expQuestion = "Вы привозите зарядку вместе с самокатом?";
        final String expAnswer = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        driver.get(url);
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        FAQAccordion objAccordion = new FAQAccordion(driver, jse);
        objAccordion.askQuestion(iAccordion.selectorChargerQuestion);
        objAccordion.getFollowingAnswer();
        assertTrue("Ответ должен быть показан ", objAccordion.isAnswerNotHidden());
        assertEquals("Текст вопроса не совпадает с ожидаемым",
                expQuestion, objAccordion.getQuestionText());
        assertEquals("Текст ответа не совпадает с ожидаемым",
                expAnswer, objAccordion.getAnswerText());
    }

    @Test
    public void cancellationQuestionTest() {
        final String expQuestion = "Можно ли отменить заказ?";
        final String expAnswer = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        driver.get(url);
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        FAQAccordion objAccordion = new FAQAccordion(driver, jse);
        objAccordion.askQuestion(iAccordion.selectorCancellationQuestion);
        objAccordion.getFollowingAnswer();
        assertTrue("Ответ должен быть показан ", objAccordion.isAnswerNotHidden());
        assertEquals("Текст вопроса не совпадает с ожидаемым",
                expQuestion, objAccordion.getQuestionText());
        assertEquals("Текст ответа не совпадает с ожидаемым",
                expAnswer, objAccordion.getAnswerText());
    }

    @Test
    public void beyondMKADQuestionTest() {
        final String expQuestion = "Я живу за МКАДом, привезёте?";
        final String expAnswer = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        driver.get(url);
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        FAQAccordion objAccordion = new FAQAccordion(driver, jse);
        objAccordion.askQuestion(iAccordion.selectorBeyondMKADQuestion);
        objAccordion.getFollowingAnswer();
        assertTrue("Ответ должен быть показан ", objAccordion.isAnswerNotHidden());
        assertEquals("Текст вопроса не совпадает с ожидаемым",
                expQuestion, objAccordion.getQuestionText());
        assertEquals("Текст ответа не совпадает с ожидаемым",
                expAnswer, objAccordion.getAnswerText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
