package ru.yandex.samokat.pages;
import org.openqa.selenium.By;

public interface iAboutRent {
    // Когда привезти $x(".//input[contains(@placeholder, 'Когда')]")
     final By selectorWhenField = By.xpath(".//input[contains(@placeholder, 'Когда')]");
    // День сегодня
    final By selectorDateToday = By.xpath(".//div[contains(@class, 'react-datepicker__day--today')]");
    // Срок аренды  $x(".//div[contains(@class, 'Dropdown') and contains(text(), 'Срок')]")
     final By selectorPeriodField = By.xpath(".//div[contains(@class, 'Dropdown') and contains(text(), 'Срок')]");
    // Срок аренды варианты $x(".//div[contains(@class, 'Dropdown-option')]")
     final By selectorRentPeriod = By.xpath(".//div[contains(@class, 'Dropdown-option')]");
    // чекбокс цвет черный $x(".//input[@id, 'black')]")
     final By selectorBlackColor = By.xpath(".//input[@id='black']");
    // чекбокс цвет серый $x(".//input[@id, 'grey')]")
     final By selectorGreyColor = By.xpath(".//input[@id='grey']");
    // Комментарий $x(".//input[contains(@placeholder, 'Комментарий')]")
     final By selectorCommentField = By.xpath(".//input[contains(@placeholder, 'Комментарий')]");
    // Заказать $x(".//button[text()='Заказать']")
     final By selectorOrderButton = By.xpath(".//div[contains(@class, 'Order_Buttons')]//button[text()='Заказать']");
}
