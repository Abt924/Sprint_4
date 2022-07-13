package ru.yandex.samokat.inputs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class nameInput extends DriveredInput{
    // поле ввода Имя $x(".//input[contains(@placeholder, 'Имя')]")
    static final By selectorNameField = By.xpath(".//input[contains(@placeholder, 'Имя')]");
    // error Message $x("./input[contains(@placeholder, 'Имя')]")
    static final By selectorErrorMessage = By.xpath("/div[contains(@class, 'Input_Error')]");

    public nameInput(WebDriver driver, JavascriptExecutor jse) {
        super(driver, jse, selectorNameField, selectorErrorMessage);
    }
}
