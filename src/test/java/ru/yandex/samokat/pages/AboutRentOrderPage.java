package ru.yandex.samokat.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
public class AboutRentOrderPage {
    // Когда привезти $x(".//input[contains(@placeholder, 'Когда')]")
    private final By selectorWhenField = By.xpath(".//input[contains(@placeholder, 'Когда')]");
    // День сегодня
    final By selectorDateToday = By.xpath(".//div[contains(@class, 'react-datepicker__day--today')]");
    // Срок аренды  $x(".//div[contains(@class, 'Dropdown') and contains(text(), 'Срок')]")
    private final By selectorPeriodField = By.xpath(".//div[contains(@class, 'Dropdown') and contains(text(), 'Срок')]");
    // Срок аренды варианты $x(".//div[contains(@class, 'Dropdown-option')]")
    private final By selectorRentPeriod = By.xpath(".//div[contains(@class, 'Dropdown-option')]");
    // чекбокс цвет черный $x(".//input[@id, 'black')]")
    private final By selectorBlackColor = By.xpath(".//input[@id='black']");
    // чекбокс цвет серый $x(".//input[@id, 'grey')]")
    private final By selectorGreyColor = By.xpath(".//input[@id='grey']");
    // Комментарий $x(".//input[contains(@placeholder, 'Комментарий')]")
    private final By selectorCommentField = By.xpath(".//input[contains(@placeholder, 'Комментарий')]");
    // Заказать $x(".//button[text()='Заказать']")
    private final By selectorOrderButton = By.xpath(".//div[contains(@class, 'Order_Buttons')]//button[text()='Заказать']");


    private WebDriver driver;
    private JavascriptExecutor jse;

    //Конструктор с параметром webdriver
    public AboutRentOrderPage(WebDriver driver){
        this.driver = driver;
    }

    public AboutRentOrderPage(WebDriver driver, JavascriptExecutor jse){
        this.driver = driver;
        this.jse = jse;
    }

    private void scrollAndClick(WebElement element){
        jse.executeScript("arguments[0].scrollIntoView()", element);
        element.click();
    }

    public  void setDate(int date){
        driver.findElement(selectorWhenField).click();
        // Дата из календаря ".//div[contains(@class, 'react-datepicker__day') and text()={date}]"
        String xpath = String.format(".//div[contains(@class, 'react-datepicker__day') and text()='%s']", date);
        final By selectorDate = By.xpath(xpath);
        WebElement selectedDate = driver.findElement(selectorDate);
        selectedDate.click();
    }
    public void setNextDay(){
        // Следующий день By.xpath("following-sibling::div")
        final By selectorDateNext = By.xpath("following-sibling::div");
        // Неделя сегодня от день сегодня
        final By selectorWeekToday = By.xpath("parent::div[contains(@class, 'react-datepicker__week')]");
        // Недели поСледующие
        final By selectorWeekNext = By.xpath("following-sibling::div");
        // все Дни недели
        final By selectorWeeksDays = By.xpath("div[contains(@class, 'react-datepicker__day')]");
        // 17 число
        final By selectorDate17 = By.xpath(".//div[contains(@class, 'react-datepicker__day') and text()='17']");

        driver.findElement(selectorWhenField).click();
        WebElement nextDay = null;
        WebElement today = driver.findElement(selectorDateToday);
        //WebElement today = driver.findElement(selectorDate17);
        List<WebElement> nextDays = today.findElements(selectorDateNext);
        if (nextDays.isEmpty()){
            WebElement week = today.findElement(selectorWeekToday);
            List<WebElement> nextWeeks = week.findElements(selectorWeekNext);
            if (nextWeeks.isEmpty()){
                //System.out.println("Конец месяца, перелистни календарь");
            }
            //System.out.println("Осталось недель" + nextWeeks.size());
            List<WebElement> weeksDays = nextWeeks.get(0).findElements(selectorWeeksDays);
            //System.out.println("дней на неделе" + weeksDays.size());
            nextDay = weeksDays.get(0);
        } else {
            nextDay = nextDays.get(0);
        }
        System.out.println("Выбрана дата " + nextDay.getText());
        nextDay.click();
    }

    public void setRentPeriod(int choice){
        driver.findElement(selectorPeriodField).click();
        driver.findElements(selectorRentPeriod).get(choice).click();
    }

    public void setBlackColor(boolean isBlack){
        if (isBlack) driver.findElement(selectorBlackColor).click();
    }

    public void setGreyColor(boolean isGray){
        if (isGray) driver.findElement(selectorGreyColor).click();
    }

    public void setComment(String comment){
        driver.findElement(selectorCommentField).sendKeys(comment);
    }

    public void pushOrder(){
        WebElement button = driver.findElement(selectorOrderButton);
        scrollAndClick(button);
    }
}
