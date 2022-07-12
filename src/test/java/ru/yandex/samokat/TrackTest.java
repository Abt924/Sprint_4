package ru.yandex.samokat;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.samokat.pages.HomePageSamokat;
import ru.yandex.samokat.pages.TrackPage;

public class TrackTest {
    private WebDriver driver;
    private JavascriptExecutor jse;
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        jse = (JavascriptExecutor)driver;
    }

    @Test
    public void wrongTrackShowNotFoundTest(){
        driver.get(url);
        HomePageSamokat objHomePage = new HomePageSamokat(driver,jse);
        objHomePage.pushOrderStatus();
        new WebDriverWait(driver, 3);
        objHomePage.setOrderNumber("12345");
        objHomePage.pushGo();

        TrackPage objTrackPage = new TrackPage(driver, jse);
        boolean isDisplayedNotFound = objTrackPage.isDisplayedNotFound();
        assertTrue("Ожидается вывод окна Такого заказа нет" , isDisplayedNotFound);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}

