package ru.yandex.samokat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

import ru.yandex.samokat.pages.HomePageSamokat;
import ru.yandex.samokat.pages.ForWhomOrderPage;
import ru.yandex.samokat.pages.AboutRentOrderPage;
import ru.yandex.samokat.pages.ConfirmationOrderPage;
import ru.yandex.samokat.pages.OrderApprovedPage;

@RunWith(Parameterized.class)
public class OrderSuccessFLowTest extends BaseUITest {


    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final int date;
    private final int period;
    private final boolean isBlack;
    private final boolean isGray;
    private final String comments;

    public OrderSuccessFLowTest(String name, String surname, String address, String metro, String phone,
                                int date, int period, boolean isBlack, boolean isGray, String comments) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.isBlack = isBlack;
        this.isGray = isGray;
        this.comments = comments;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"Сидор", "Васечкин", "Хорошовское шоссе 17", "Беговая", "+74952128506",
                        18, 6, true, false, "No comments"},
                {"Петр", "Баширов", "Льва Толстого д.6", "Парк культуры", "84952128506",
                        2, 1, true, true, "без комментариев"},
        };
    }


    // Позитивный флоу заказа самоката должен завершится окном Заказ оформлен с номером заказа
    // Заказ через кнопку на странице
    @Test
    public void successFlowTestPushOrderOnPage() {
        HomePageSamokat objHomePage = new HomePageSamokat(driver,jse);
        objHomePage.open();
        objHomePage.acceptCookies();
        objHomePage.pushOrderOnPage();

        ForWhomOrderPage objForWhom = new ForWhomOrderPage(driver, jse);
        objForWhom.setName(name);
        objForWhom.setSurname(surname);
        objForWhom.setAddress(address);
        objForWhom.setPhone(phone);
        objForWhom.setMetro(metro);
        objForWhom.pushNext();

        AboutRentOrderPage objAboutRent = new AboutRentOrderPage(driver, jse);
        //objAboutRent.setNextDay();
        objAboutRent.setDate(date);
        objAboutRent.setRentPeriod(period);
        objAboutRent.setBlackColor(isBlack);
        objAboutRent.setGreyColor(isGray);
        objAboutRent.setComment(comments);
        objAboutRent.pushOrder();

        ConfirmationOrderPage objConfirmationPage = new ConfirmationOrderPage(driver, jse);
        objConfirmationPage.waitPage();
        objConfirmationPage.pushYes();

        OrderApprovedPage objApproved = new OrderApprovedPage(driver, jse);
        assertTrue("НЕТ окна \"Заказ оформлен\" после подтверждения заказа.", objApproved.isUp());

    }

    // Позитивный флоу заказа самоката должен завершится окном Заказ оформлен с номером заказа
    // Заказ через кнопку в заголовке
    @Test
    public void successFlowTestPushOrderInHeader() {
        HomePageSamokat objHomePage = new HomePageSamokat(driver,jse);
        objHomePage.open();
        objHomePage.acceptCookies();
        objHomePage.pushOrderInHeader();

        ForWhomOrderPage objForWhom = new ForWhomOrderPage(driver, jse);
        objForWhom.setName(name);
        objForWhom.setSurname(surname);
        objForWhom.setAddress(address);
        objForWhom.setPhone(phone);
        objForWhom.setMetro(metro);
        objForWhom.pushNext();

        AboutRentOrderPage objAboutRent = new AboutRentOrderPage(driver, jse);
        //objAboutRent.setNextDay();
        objAboutRent.setDate(date);
        objAboutRent.setRentPeriod(period);
        objAboutRent.setBlackColor(isBlack);
        objAboutRent.setGreyColor(isGray);
        objAboutRent.setComment(comments);
        objAboutRent.pushOrder();

        ConfirmationOrderPage objConfirmationPage = new ConfirmationOrderPage(driver, jse);
        objConfirmationPage.waitPage();
        objConfirmationPage.pushYes();

        OrderApprovedPage objApproved = new OrderApprovedPage(driver, jse);
        assertTrue("НЕТ окна \"Заказ оформлен\" после подтверждения заказа.", objApproved.isUp());

    }


}
