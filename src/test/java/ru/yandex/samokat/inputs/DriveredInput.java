package ru.yandex.samokat.inputs;

import org.openqa.selenium.*;
import ru.yandex.samokat.pages.DriveredPage;

import java.util.List;

public class DriveredInput {
    private final String filledClass ="Input_Filled";
    protected final String errorClass ="Input_Error";
    private final String responsibleClass ="Input_Responsible";
    private final String visibleClass ="Input_Visible";

    private WebDriver driver;
    private JavascriptExecutor jse;
    private final By selectorInput;
    private final By selectorErrorMessage;

    private int countInput;
    private int countErrorMessage;
    protected WebElement input;
    protected WebElement errorMessage;



    public DriveredInput(WebDriver driver, JavascriptExecutor jse, By selectorInput, By selectorErrorMessage) {
        this.driver = driver;
        this.jse = jse;
        this.selectorInput = selectorInput;
        this.selectorErrorMessage = selectorErrorMessage;
        init();
    }

    private void init (){
        List<WebElement> inputs = driver.findElements(selectorInput);
        countInput = inputs.size();
        if (countInput == 1) input = inputs.get(0); else input=null;

        List<WebElement> errorMessages = driver.findElements(selectorErrorMessage);
        countErrorMessage = errorMessages.size();
        if (countErrorMessage == 1) errorMessage = errorMessages.get(0); else errorMessage=null;
    }

    public boolean isInputExist() {return countInput>0;}
    public boolean isInputSingleton() {return countInput==1;}

    public boolean isErrorMessageExist() {return countInput>0;}
    public boolean isErrorMessageSingleton() {return countInput==1;}

    public void clear(){input.clear();}
    public void click(){input.click();}
    public void scrollTo(){    jse.executeScript("arguments[0].scrollIntoView()", input);}
    public void sendKeys(String s){ input.sendKeys(s);}
    public void submit(){input.submit();}
    public void pushTab(){input.sendKeys(Keys.TAB);}


    public String getPlaceholder(){return input.getAttribute("placeholder");}
    public String getValue(){return input.getAttribute("value");}
    public String getClasses(){ return input.getAttribute("class");}
    public String getErrorMessageText(){return errorMessage.getText();}

    public boolean isFilled(){
        return input.getAttribute("class").contains(filledClass);
    }
    public boolean isResponsible(){
        return input.getAttribute("class").contains(responsibleClass);
    }
    public boolean isError(){
        return input.getAttribute("class").contains(errorClass);
    }
    public boolean isErrorMessageVisible(){
        return errorMessage.getAttribute("class").contains(visibleClass);
    }

    public boolean isValidate(){
        return !isError();
    }
}
