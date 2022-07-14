package ru.yandex.samokat;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.samokat.pages.HomePageSamokat;
import ru.yandex.samokat.inputs.NameInput;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NameInputLogicTest {
    private WebDriver driver;
    private JavascriptExecutor jse;
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void setUp(){
            driver = new ChromeDriver();
            jse = (JavascriptExecutor)driver;
            driver.get(url);
            HomePageSamokat objHomePage = new HomePageSamokat(driver,jse);
            objHomePage.acceptCookies();
            objHomePage.pushOrderInHeader();
    }

    @Test
    public void NameFieldExistAndSingle(){
            NameInput objNameInput = new NameInput(driver,jse);
            assertTrue("Поле ввода Имя должно быть на странице" , objNameInput.isInputExist());
            assertTrue("Поле ввода Имя должно быть единственным" , objNameInput.isInputSingleton());
            assertTrue("Err Mess к полю ввода Имя должно быть на странице" , objNameInput.isErrorMessageExist());
            assertTrue("Err Mess к полю ввода Имя должно быть единственным" , objNameInput.isErrorMessageSingleton());
    }

    @Test
    public void NameFieldAtFirstAppearance(){
        NameInput objNameInput = new NameInput(driver,jse);
        objNameInput.scrollTo();
        assertTrue("Поле ввода Имя должно быть видимо" , objNameInput.isInputDisplayed());
        assertTrue("Поле ввода Имя должно быть доступно для ввода" , objNameInput.isResponsible());
        assertFalse("Поле ввода Имя должно быть незаполнено" , objNameInput.isFilled());
        assertEquals("Поле ввода Имя должно быть пустым", "", objNameInput.getValue() );
        assertFalse("Поле ввода Имя должно быть без ошибки" , objNameInput.isError());
        assertFalse("Err Mess к полю ввода Имя должно быть скрыто" , objNameInput.isErrorMessageVisible());
    }

    @Test
    public void NameFieldValidInput(){
        final String  name = "Годное Имя";
        NameInput objNameInput = new NameInput(driver,jse);
        objNameInput.sendKeys(name);
        objNameInput.pushTab();
        assertFalse("Поле ввода Имя должно быть без ошибки" , objNameInput.isError());
        assertFalse("Err Mess к полю ввода Имя должно быть скрыто" , objNameInput.isErrorMessageVisible());

        assertTrue("Поле ввода Имя должно быть видимо" , objNameInput.isInputDisplayed());
        assertTrue("Поле ввода Имя должно быть доступно для ввода" , objNameInput.isResponsible());
        assertTrue("Поле ввода Имя должно быть заполнено" , objNameInput.isFilled());
        assertEquals(String.format("Должно быть введено имя %s",name),
                name, objNameInput.getValue() );
    }

    @Test
    public void NameFieldNotValidInput(){
        final String  name = "Wrong name";
        final String  errorMessage = "Введите корректное имя";

        NameInput objNameInput = new NameInput(driver,jse);
        objNameInput.sendKeys(name);
        objNameInput.pushTab();
        assertTrue("Поле ввода Имя должно быть с ошибкой " , objNameInput.isError());
        assertTrue("Err Mess к полю ввода Имя должно быть видимо" , objNameInput.isErrorMessageVisible());
        assertEquals(String.format("Сообщение о некорректом вводе должно быть: %s", errorMessage),
                errorMessage, objNameInput.getErrorMessageText() );


        assertTrue("Поле ввода Имя должно быть видимо" , objNameInput.isInputDisplayed());
        assertTrue("Поле ввода Имя должно быть доступно для ввода" , objNameInput.isResponsible());
        assertTrue("Поле ввода Имя должно быть заполнено" , objNameInput.isFilled());
        assertEquals(String.format("Должно быть введено имя %s",name),
                name, objNameInput.getValue() );
    }

    @After
        public void tearDown(){
            driver.quit();
        }
}
