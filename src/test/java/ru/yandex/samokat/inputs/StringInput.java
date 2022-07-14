package ru.yandex.samokat.inputs;

import org.openqa.selenium.*;

import java.util.List;

public class StringInput extends DriveredInput{
    // Селекторы элементов ввода
    private final By selectorInput;
    private final By selectorErrorMessage;
    // элементы поля ввода
    protected WebElement input;
    protected WebElement errorMessage;

    // признаки в атрибуте @claas для определения статуса поля ввода
    private final String filledClass ="Input_Filled";
    protected final String errorClass ="Input_Error";
    private final String responsibleClass ="Input_Responsible";
    private final String visibleClass ="Input_Visible";
    // счетчики элементов
    private int countInput;
    private int countErrorMessage;

    public StringInput(WebDriver driver, JavascriptExecutor jse, By selectorInput, By selectorErrorMessage) {
        super(driver,jse);
        this.selectorInput = selectorInput;
        this.selectorErrorMessage = selectorErrorMessage;
        init();
    }

    // поиск элементов на странице, подсчет, инициализация первым найденным.
    private void init (){
        List<WebElement> inputs = driver.findElements(selectorInput);
        countInput = inputs.size();
        if (countInput == 1) input = inputs.get(0); else input=null;

        List<WebElement> errorMessages = input.findElements(selectorErrorMessage);
        countErrorMessage = errorMessages.size();
        if (countErrorMessage == 1) errorMessage = errorMessages.get(0); else errorMessage=null;
        // System.out.println(countInput);
        // System.out.println(countErrorMessage);
    }
    // наличие на странице и единственность
    public boolean isInputExist() {return countInput>0;}
    public boolean isInputSingleton() {return countInput==1;}
    public boolean isErrorMessageExist() {return countErrorMessage>0;}
    public boolean isErrorMessageSingleton() {return countErrorMessage==1;}
    // действия
    public void clear(){input.clear();}
    public void click(){input.click();}
    public void scrollTo(){    jse.executeScript("arguments[0].scrollIntoView()", input);}
    public void sendKeys(String s){ input.sendKeys(s);}
    public void submit(){input.submit();}
    public void pushTab(){input.sendKeys(Keys.TAB);}
    // получение атрибутов
    public String getPlaceholder(){return input.getAttribute("placeholder");}
    public String getValue(){return input.getAttribute("value");}
    public String getClasses(){ return input.getAttribute("class");}
    public String getErrorMessageText(){return errorMessage.getText();}
    //статусы поля ввода
    public boolean isFilled(){
        return input.getAttribute("class").contains(filledClass);
    }
    public boolean isResponsible(){ return input.getAttribute("class").contains(responsibleClass);}
    public boolean isError(){ return input.getAttribute("class").contains(errorClass); }
    public boolean isErrorMessageVisible(){ return errorMessage.getAttribute("class").contains(visibleClass);}
    public boolean isInputDisplayed(){return input.isDisplayed(); }
    // результат валидации
    public boolean isValidate(){
        return !isError();
    }
}
