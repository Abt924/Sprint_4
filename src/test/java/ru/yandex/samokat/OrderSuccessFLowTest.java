package ru.yandex.samokat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.samokat.pages.HomePageSamokat;
import ru.yandex.samokat.pages.ForWhomOrderPage;
import ru.yandex.samokat.pages.AboutRentOrderPage;
import ru.yandex.samokat.pages.ConfirmationOrderPage;
import ru.yandex.samokat.pages.OrderApprovedPage;


public class OrderSuccessFLowTest {

    private WebDriver driver;
    private JavascriptExecutor jse;
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        jse = (JavascriptExecutor)driver;
    }

    @Test
    public void successFlowTest(){
        driver.get(url);
        HomePageSamokat objHomePage = new HomePageSamokat(driver, jse);
        objHomePage.acceptCookies();
        objHomePage.pushOrderOnPage();

        ForWhomOrderPage objForWhom = new ForWhomOrderPage(driver, jse);
        objForWhom.setName("Василий");
        objForWhom.setSurname("Петров");
        objForWhom.setAddress("Фестивальная д.1 кв.99");
        objForWhom.setPhone("+79852128506");
        objForWhom.setMetro("Сокольники");
        objForWhom.pushNext();

        AboutRentOrderPage objAboutRent = new AboutRentOrderPage(driver, jse);
        objAboutRent.setNextDay();
        objAboutRent.setDate(7);
        objAboutRent.setRentPeriod(4);
        objAboutRent.setBlackColor();
        objAboutRent.setComment("Без комментариев");
        objAboutRent.pushOrder();

        ConfirmationOrderPage objConfirmationPage = new ConfirmationOrderPage(driver, jse);
        objConfirmationPage.waitPage();
        objConfirmationPage.pushYes();

        OrderApprovedPage objAprooved = new OrderApprovedPage(driver,jse);
        assertTrue("Ожидается появление окна Заказ оформлен...", objAprooved.isUp());

    }


    @After
    public void tearDown(){
        driver.quit();
    }

}
