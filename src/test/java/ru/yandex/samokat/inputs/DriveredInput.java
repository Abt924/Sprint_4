package ru.yandex.samokat.inputs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class DriveredInput {
    protected WebDriver driver;
    protected JavascriptExecutor jse;

    public DriveredInput(WebDriver driver, JavascriptExecutor jse) {
        this.driver = driver;
        this.jse = jse;
    }
}
