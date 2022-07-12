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

public class FollowLogoTest {

    private WebDriver driver;
    private JavascriptExecutor jse;
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        jse = (JavascriptExecutor)driver;
    }

    @Test
    public void followScooterLogoTest(){
        driver.get(url);
        HomePageSamokat objHomePage = new HomePageSamokat(driver,jse);
        objHomePage.followLogoScooter();
        String newURL = driver.getCurrentUrl();
        assertEquals("Лого самокат должен вести на главную страницу" , url, newURL);
    }

    @Test
    public void followYandexLogoTest(){
        driver.get(url);
        HomePageSamokat objHomePage = new HomePageSamokat(driver,jse);
        objHomePage.followLogoYandex();
        //new  WebDriverWait(driver, 3);
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1) );
        String newURL = driver.getCurrentUrl();
        assertEquals("Лого yandex должен вести на главную страницу yandex" , "https://yandex.ru/", newURL);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
