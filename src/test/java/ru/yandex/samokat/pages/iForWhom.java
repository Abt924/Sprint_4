package ru.yandex.samokat.pages;
import org.openqa.selenium.By;

public interface iForWhom {
    // Кнопка Далее $x(".//button[text()='Далее']")
     final By selectorNextButton = By.xpath(".//button[contains(text(),'Далее')]");
    // поле ввода Имя $x(".//input[contains(@placeholder, 'Имя')]")
     final By selectorNameField = By.xpath(".//input[contains(@placeholder, 'Имя')]");
    // поле ввода Фамилия $x(".//input[contains(@placeholder, 'Фамилия')]")
     final By selectorSurnameField = By.xpath(".//input[contains(@placeholder, 'Фамилия')]");
    // поле ввода Адрес $x(".//input[contains(@placeholder, 'Адрес')]")
     final By selectorAddressField = By.xpath(".//input[contains(@placeholder, 'Адрес')]");
    // поле ввода Метро $x(".//input[contains(@placeholder, 'метро')]")
     final By selectorMetroField = By.xpath(".//input[contains(@placeholder, 'метро')]");
    // список станций кнопка станции  $x(".//div[@class='Order_Text__2broi' and contains(text(), 'Сокольники')]")
     final String selectorStationButtonStr = ".//div[@class='Order_Text__2broi' and contains(text(), '%s')]";
    //  By selectorStationButton = By.xpath(".//div[@class='Order_Text__2broi' and contains(text(), 'Сокольники')]");
    // поле ввода Телефон $x(".//input[contains(@placeholder, 'Телефон')]")
     final By selectorPhoneField = By.xpath(".//input[contains(@placeholder, 'Телефон')]");

}
