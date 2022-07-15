package ru.yandex.samokat;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import ru.yandex.samokat.pages.HomePageSamokat;
import ru.yandex.samokat.inputs.NameInput;

// тесты логики поля ввода Имя
public class NameInputLogicTest extends BaseUITest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
        HomePageSamokat objHomePage = new HomePageSamokat(driver,jse);
        objHomePage.open();
        objHomePage.acceptCookies();
        objHomePage.pushOrderInHeader();
    }

    // Поле ввода присутствует на странице в единственном экземпляре
    @Test
    public void NameFieldExistAndSingle() {
        NameInput objNameInput = new NameInput(driver, jse);
        assertTrue("Поле ввода Имя должно быть на странице", objNameInput.isInputExist());
        assertTrue("Поле ввода Имя должно быть единственным", objNameInput.isInputSingleton());
        assertTrue("Err Mess к полю ввода Имя должно быть на странице", objNameInput.isErrorMessageExist());
        assertTrue("Err Mess к полю ввода Имя должно быть единственным", objNameInput.isErrorMessageSingleton());
    }

    // При открытии окна поле на заполнено, статус не заполнено
    @Test
    public void NameFieldAtFirstAppearance() {
        NameInput objNameInput = new NameInput(driver, jse);
        objNameInput.scrollTo();
        assertTrue("Поле ввода Имя должно быть видимо", objNameInput.isInputDisplayed());
        assertTrue("Поле ввода Имя должно быть доступно для ввода", objNameInput.isResponsible());
        assertFalse("Поле ввода Имя должно быть незаполнено", objNameInput.isFilled());
        assertEquals("Поле ввода Имя должно быть пустым", "", objNameInput.getValue());
        assertFalse("Поле ввода Имя должно быть без ошибки", objNameInput.isError());
        assertFalse("Err Mess к полю ввода Имя должно быть скрыто", objNameInput.isErrorMessageVisible());
    }

    // При Валидном вводе статус заполнено, Err message не отображается, введенные символы отображаются
    @Test
    public void NameFieldValidInput() {
        final String name = "Годное Имя";
        NameInput objNameInput = new NameInput(driver, jse);
        objNameInput.sendKeys(name);
        objNameInput.pushTab();
        assertFalse("Поле ввода Имя должно быть без ошибки", objNameInput.isError());
        assertFalse("Err Mess к полю ввода Имя должно быть скрыто", objNameInput.isErrorMessageVisible());

        assertTrue("Поле ввода Имя должно быть видимо", objNameInput.isInputDisplayed());
        assertTrue("Поле ввода Имя должно быть доступно для ввода", objNameInput.isResponsible());
        assertTrue("Поле ввода Имя должно быть заполнено", objNameInput.isFilled());
        assertEquals(String.format("Должно быть введено имя %s", name), name, objNameInput.getValue());
    }

    // при невалидном вводе статус ошибка, отображется сообщение об ошибке
    // проверка текста сообщения
    @Test
    public void NameFieldNotValidInput() {
        final String name = "Wrong name";
        final String errorMessage = "Введите корректное имя";

        NameInput objNameInput = new NameInput(driver, jse);
        objNameInput.sendKeys(name);
        objNameInput.pushTab();
        assertTrue("Поле ввода Имя должно быть с ошибкой ", objNameInput.isError());
        assertTrue("Err Mess к полю ввода Имя должно быть видимо", objNameInput.isErrorMessageVisible());
        assertEquals(String.format("Сообщение о некорректом вводе должно быть: %s", errorMessage), errorMessage, objNameInput.getErrorMessageText());

        assertTrue("Поле ввода Имя должно быть видимо", objNameInput.isInputDisplayed());
        assertTrue("Поле ввода Имя должно быть доступно для ввода", objNameInput.isResponsible());
        assertTrue("Поле ввода Имя должно быть заполнено", objNameInput.isFilled());
        assertEquals(String.format("Должно быть введено имя %s", name), name, objNameInput.getValue());
    }

}
