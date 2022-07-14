package ru.yandex.samokat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.samokat.pages.*;
import ru.yandex.samokat.inputs.*;

@RunWith(Parameterized.class)
public class NameInputValidationTest {

    private WebDriver driver;
    private JavascriptExecutor jse;
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private final String name;
    private final boolean expected;

    public NameInputValidationTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object [][] getNameData(){
        return new Object[][]{
                {"Федор", true},
                {"федор", true},
                {"Си", true},
                {"Пятнадцать симв", true},
                {"СамуилАрхангел", true},
                {"Иван Иванович", true},
                {"", false},
                {"Ф", false},
                {"Шестнадцать симв", false},
                {"Восемьдесят                                                             символов", false},
                {"Евген 123", false},
                {"Супер-колесо", false},
                {"Adam", false},
                {"СэрQ", false},
        };
    }

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        jse = (JavascriptExecutor)driver;
    }

    @Test
    public void nameInputValidationTest(){
        driver.get(url);
        HomePageSamokat objHomePage = new HomePageSamokat(driver, jse);
        objHomePage.acceptCookies();
        objHomePage.pushOrderOnPage();
    
        NameInput objNameInput = new NameInput(driver, jse);
        objNameInput.sendKeys(name);
        objNameInput.pushTab();

        assertEquals(String.format("Валидны рус, пробел, от 2 до 15 символов. Введено: %s", name),
                expected, objNameInput.isValidate());

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
