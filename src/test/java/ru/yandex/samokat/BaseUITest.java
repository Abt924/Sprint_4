package ru.yandex.samokat;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseUITest {

    protected WebDriver driver;
    protected JavascriptExecutor jse;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        jse = (JavascriptExecutor) driver;
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
