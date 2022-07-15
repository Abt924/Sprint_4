package ru.yandex.samokat.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// РОМ раскрвающегося списка Вопрос-Ответ, селекторы выненсены в интерфес
public class FAQAccordion extends DriveredPage {
    public static final By selectorPriceQuestion = By.xpath(
            ".//div[@class='accordion__button' and contains(text(), 'стоит') and contains(text(), 'оплатить')] ");
    public static final By selectorFollowingAnswer = By.xpath(
            "parent::div/following-sibling::div/p");
    public static final By selectorWantsMoreQuestion = By.xpath(
            ".//div[@class='accordion__button' and contains(text(), 'можно') and contains(text(), 'несколько')] ");
    public static final By selectorRentTimeQuestion = By.xpath(
            ".//div[@class='accordion__button' and contains(text(), 'время') and contains(text(), 'аренды')] ");
    public static final By selectorRentTodayQuestion = By.xpath(
            ".//div[@class='accordion__button' and contains(text(), 'прямо') and contains(text(), 'сегодня')] ");
    public static final By selectorExtendOrReturnQuestion = By.xpath(
            ".//div[@class='accordion__button' and contains(text(), 'продлить') and contains(text(), 'вернуть')] ");
    public static final By selectorChargerQuestion = By.xpath(
            ".//div[@class='accordion__button' and contains(text(), 'привозите') and contains(text(), 'зарядку')] ");
    public static final By selectorCancellationQuestion = By.xpath(
            ".//div[@class='accordion__button' and contains(text(), 'отменить') and contains(text(), 'заказ')] ");
    public static final By selectorBeyondMKADQuestion = By.xpath(
            ".//div[@class='accordion__button' and contains(text(), 'МКАД') and contains(text(), 'привез')] ");


    public FAQAccordion(WebDriver driver, JavascriptExecutor jse) {
        super(driver, jse);
    }

    WebElement question;
    WebElement answer;

    public void askQuestion(By selector) {
        question = driver.findElement(selector);
        jse.executeScript("arguments[0].scrollIntoView()", question);
        question.click();
    }

    public void getFollowingAnswer() {
        answer = question.findElement(selectorFollowingAnswer);
    }

    public boolean isAnswerNotHidden() {
        if (answer.getAttribute("hidden") == null) {
            return true;
        }
        return false;
    }

    public String getQuestionText() {
        return question.getText();
    }

    public String getAnswerText() {
        return answer.getText();
    }
}

