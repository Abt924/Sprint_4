package ru.yandex.samokat.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.yandex.samokat.pages.iAccordion;

public class FAQAccordion extends DriveredPage implements iAccordion {

    public FAQAccordion(WebDriver driver, JavascriptExecutor jse) {
        super(driver, jse);
    }

    WebElement question;
    WebElement answer;

    public void askQuestion(By selector){
        question = driver.findElement(selector);
        jse.executeScript("arguments[0].scrollIntoView()", question);
        question.click();
    }
    public void getFollowingAnswer() {
        answer = question.findElement(iAccordion.selectorFollowingAnswer);
    }
    public boolean isAnswerNotHidden(){
        if (answer.getAttribute("hidden")==null ){ return true; }
        return false;
    }
    public String getQuestionText(){
        return question.getText();
    }
    public String getAnswerText(){
        return answer.getText();
    }


}

