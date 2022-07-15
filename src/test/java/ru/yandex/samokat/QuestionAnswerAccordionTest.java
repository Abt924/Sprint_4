package ru.yandex.samokat;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import ru.yandex.samokat.pages.FAQAccordion;
import ru.yandex.samokat.pages.HomePageSamokat;

// Тест выпадающего списка Вопрос-Ответ
// отдельные тесты каждому вопросу
public class QuestionAnswerAccordionTest extends BaseUITest {

    @Test
    public void priceQuestionTest() {
        final String expQuestion = "Сколько это стоит? И как оплатить?";
        final String expAnswer = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        HomePageSamokat objHomePage = new HomePageSamokat(driver, jse);
        objHomePage.open();
        FAQAccordion objAccordion = new FAQAccordion(driver, jse);
        objAccordion.askQuestion(FAQAccordion.selectorPriceQuestion);
        objAccordion.getFollowingAnswer();
        assertTrue("Ответ должен быть показан ", objAccordion.isAnswerNotHidden());
        assertEquals("Текст вопроса не совпадает с ожидаемым", expQuestion, objAccordion.getQuestionText());
        assertEquals("Текст ответа не совпадает с ожидаемым", expAnswer, objAccordion.getAnswerText());
    }

    @Test
    public void wantsMoreQuestionTest() {
        final String expQuestion = "Хочу сразу несколько самокатов! Так можно?";
        final String expAnswer = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        HomePageSamokat objHomePage = new HomePageSamokat(driver, jse);
        objHomePage.open();
        FAQAccordion objAccordion = new FAQAccordion(driver, jse);
        objAccordion.askQuestion(FAQAccordion.selectorWantsMoreQuestion);
        objAccordion.getFollowingAnswer();
        assertTrue("Ответ должен быть показан ", objAccordion.isAnswerNotHidden());
        assertEquals("Текст вопроса не совпадает с ожидаемым", expQuestion, objAccordion.getQuestionText());
        assertEquals("Текст ответа не совпадает с ожидаемым", expAnswer, objAccordion.getAnswerText());
    }

    @Test
    public void rentTimeQuestionTest() {
        final String expQuestion = "Как рассчитывается время аренды?";
        final String expAnswer = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        HomePageSamokat objHomePage = new HomePageSamokat(driver, jse);
        objHomePage.open();
        FAQAccordion objAccordion = new FAQAccordion(driver, jse);
        objAccordion.askQuestion(FAQAccordion.selectorRentTimeQuestion);
        objAccordion.getFollowingAnswer();
        assertTrue("Ответ должен быть показан ", objAccordion.isAnswerNotHidden());
        assertEquals("Текст вопроса не совпадает с ожидаемым", expQuestion, objAccordion.getQuestionText());
        assertEquals("Текст ответа не совпадает с ожидаемым", expAnswer, objAccordion.getAnswerText());
    }

    @Test
    public void rentTodayQuestionTest() {
        final String expQuestion = "Можно ли заказать самокат прямо на сегодня?";
        final String expAnswer = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        HomePageSamokat objHomePage = new HomePageSamokat(driver, jse);
        objHomePage.open();
        FAQAccordion objAccordion = new FAQAccordion(driver, jse);
        objAccordion.askQuestion(FAQAccordion.selectorRentTodayQuestion);
        objAccordion.getFollowingAnswer();
        assertTrue("Ответ должен быть показан ", objAccordion.isAnswerNotHidden());
        assertEquals("Текст вопроса не совпадает с ожидаемым", expQuestion, objAccordion.getQuestionText());
        assertEquals("Текст ответа не совпадает с ожидаемым", expAnswer, objAccordion.getAnswerText());
    }

    @Test
    public void extendOrReturnQuestionTest() {
        final String expQuestion = "Можно ли продлить заказ или вернуть самокат раньше?";
        final String expAnswer = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        HomePageSamokat objHomePage = new HomePageSamokat(driver, jse);
        objHomePage.open();
        FAQAccordion objAccordion = new FAQAccordion(driver, jse);
        objAccordion.askQuestion(FAQAccordion.selectorExtendOrReturnQuestion);
        objAccordion.getFollowingAnswer();
        assertTrue("Ответ должен быть показан ", objAccordion.isAnswerNotHidden());
        assertEquals("Текст вопроса не совпадает с ожидаемым", expQuestion, objAccordion.getQuestionText());
        assertEquals("Текст ответа не совпадает с ожидаемым", expAnswer, objAccordion.getAnswerText());
    }

    @Test
    public void chargerQuestionTest() {
        final String expQuestion = "Вы привозите зарядку вместе с самокатом?";
        final String expAnswer = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        HomePageSamokat objHomePage = new HomePageSamokat(driver, jse);
        objHomePage.open();
        FAQAccordion objAccordion = new FAQAccordion(driver, jse);
        objAccordion.askQuestion(FAQAccordion.selectorChargerQuestion);
        objAccordion.getFollowingAnswer();
        assertTrue("Ответ должен быть показан ", objAccordion.isAnswerNotHidden());
        assertEquals("Текст вопроса не совпадает с ожидаемым", expQuestion, objAccordion.getQuestionText());
        assertEquals("Текст ответа не совпадает с ожидаемым", expAnswer, objAccordion.getAnswerText());
    }

    @Test
    public void cancellationQuestionTest() {
        final String expQuestion = "Можно ли отменить заказ?";
        final String expAnswer = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        HomePageSamokat objHomePage = new HomePageSamokat(driver, jse);
        objHomePage.open();
        FAQAccordion objAccordion = new FAQAccordion(driver, jse);
        objAccordion.askQuestion(FAQAccordion.selectorCancellationQuestion);
        objAccordion.getFollowingAnswer();
        assertTrue("Ответ должен быть показан ", objAccordion.isAnswerNotHidden());
        assertEquals("Текст вопроса не совпадает с ожидаемым", expQuestion, objAccordion.getQuestionText());
        assertEquals("Текст ответа не совпадает с ожидаемым", expAnswer, objAccordion.getAnswerText());
    }

    @Test
    public void beyondMKADQuestionTest() {
        final String expQuestion = "Я живу за МКАДом, привезёте?";
        final String expAnswer = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        HomePageSamokat objHomePage = new HomePageSamokat(driver, jse);
        objHomePage.open();
        FAQAccordion objAccordion = new FAQAccordion(driver, jse);
        objAccordion.askQuestion(FAQAccordion.selectorBeyondMKADQuestion);
        objAccordion.getFollowingAnswer();
        assertTrue("Ответ должен быть показан ", objAccordion.isAnswerNotHidden());
        assertEquals("Текст вопроса не совпадает с ожидаемым", expQuestion, objAccordion.getQuestionText());
        assertEquals("Текст ответа не совпадает с ожидаемым", expAnswer, objAccordion.getAnswerText());
    }

}
