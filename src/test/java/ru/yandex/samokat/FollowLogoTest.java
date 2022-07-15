package ru.yandex.samokat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import ru.yandex.samokat.pages.HomePageSamokat;

// Тест перехода Лого
public class FollowLogoTest extends BaseUITest {

    //Тест перехода по Лого Самокат на главную старницу Самокат
    @Test
    public void followScooterLogoTest() {
        HomePageSamokat objHomePage = new HomePageSamokat(driver, jse);
        objHomePage.open();
        objHomePage.followLogoScooter();
        String newURL = driver.getCurrentUrl();
        assertEquals("Лого самокат должен вести на главную страницу", HomePageSamokat.URL, newURL);
    }

    // Тест перехода по Лого Яндекс на главную страницу Яндекс в новой вкладке
    @Test
    public void followYandexLogoTest() {
        HomePageSamokat objHomePage = new HomePageSamokat(driver, jse);
        objHomePage.open();
        objHomePage.followLogoYandex();
        //new  WebDriverWait(driver, 3);
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        String newURL = driver.getCurrentUrl();
        assertEquals("Лого yandex должен вести на главную страницу yandex", "https://yandex.ru/", newURL);
    }

}
