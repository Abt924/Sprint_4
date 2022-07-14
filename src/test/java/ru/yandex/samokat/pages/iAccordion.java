package ru.yandex.samokat.pages;

import org.openqa.selenium.By;

public interface iAccordion {
    final By selectorPriceQuestion = By.xpath(
            ".//div[@class='accordion__button' and contains(text(), 'стоит') and contains(text(), 'оплатить')] ");
    final By selectorFollowingAnswer = By.xpath(
            "parent::div/following-sibling::div/p");
    final By selectorWantsMoreQuestion = By.xpath(
            ".//div[@class='accordion__button' and contains(text(), 'можно') and contains(text(), 'несколько')] ");
    final By selectorRentTimeQuestion = By.xpath(
            ".//div[@class='accordion__button' and contains(text(), 'время') and contains(text(), 'аренды')] ");
    final By selectorRentTodayQuestion = By.xpath(
            ".//div[@class='accordion__button' and contains(text(), 'прямо') and contains(text(), 'сегодня')] ");
    final By selectorExtendOrReturnQuestion = By.xpath(
            ".//div[@class='accordion__button' and contains(text(), 'продлить') and contains(text(), 'вернуть')] ");
    final By selectorChargerQuestion = By.xpath(
            ".//div[@class='accordion__button' and contains(text(), 'привозите') and contains(text(), 'зарядку')] ");
    final By selectorCancellationQuestion = By.xpath(
            ".//div[@class='accordion__button' and contains(text(), 'отменить') and contains(text(), 'заказ')] ");
    final By selectorBeyondMKADQuestion = By.xpath(
            ".//div[@class='accordion__button' and contains(text(), 'МКАД') and contains(text(), 'привез')] ");

}
