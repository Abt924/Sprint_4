package ru.yandex.samokat;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import ru.yandex.samokat.pages.*;
import ru.yandex.samokat.inputs.*;

//Тест валидации ввода в поле Имя
@RunWith(Parameterized.class)
public class NameInputValidationTest extends BaseUITest{

    private final String name;
    private final boolean expected;

    public NameInputValidationTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getNameData() {
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

    @Test
    public void nameInputValidationTest() {
        HomePageSamokat objHomePage = new HomePageSamokat(driver,jse);
        objHomePage.open();
        objHomePage.acceptCookies();
        objHomePage.pushOrderOnPage();

        NameInput objNameInput = new NameInput(driver, jse);
        objNameInput.sendKeys(name);
        objNameInput.pushTab();

        assertEquals(String.format("Валидны рус, пробел, от 2 до 15 символов. Введено: %s", name),
                expected, objNameInput.isValidate());
    }

}
