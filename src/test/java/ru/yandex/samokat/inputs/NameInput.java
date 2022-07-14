package ru.yandex.samokat.inputs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import  ru.yandex.samokat.pages.iForWhom;

public class NameInput extends StringInput {
    // селектор поля ввода Имя в интерфйсе iForWhom.selectorNameField
    // $x(".//input[contains(@placeholder, 'Имя')]")

    // селектор сообщения об ошибке валидации $x("./input[contains(@placeholder, 'Имя')]")
    static final By selectorErrorMessage = By.xpath("following-sibling::div[contains(@class, 'Input_ErrorMessage')]");

    public NameInput(WebDriver driver, JavascriptExecutor jse) {
        super(driver, jse, iForWhom.selectorNameField, selectorErrorMessage);
    }
}
