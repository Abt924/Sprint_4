package ru.yandex.samokat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.samokat.pages.*;
import ru.yandex.samokat.inputs.Order;


import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderSuccessParameterizedFLowTest extends BaseUITest {

    private final Order order;

    public OrderSuccessParameterizedFLowTest(Order order) {
        this.order = order;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                // клик по кнопке в хедере, валидные данные ввода
                {new Order("Сидор", "Васечкин", "Хорошовское шоссе 17", "Беговая", "+74952128506",
                        18, 6, true, false, "No comments", HomePageSamokat.upperButtonClass)},
                // клик по кнопке в середине страницы, валидные данные ввода
                {new Order("Петр", "Баширов", "Льва Толстого д.6", "Парк культуры", "84952128506",
                        2, 1, true, true, "без комментариев", HomePageSamokat.lowerButtonClass)},
        };
    }


    // Позитивный флоу заказа самоката должен завершится окном Заказ оформлен с номером заказа
    @Test
    public void successFlowTest() {
        HomePageSamokat objHomePage = new HomePageSamokat(driver, jse);
        objHomePage.open();
        objHomePage.acceptCookies();
        objHomePage.pushOrderUpperOrLowerButton(order);

        ForWhomOrderPage objForWhom = new ForWhomOrderPage(driver, jse);
        objForWhom.fillForm(order);
        objForWhom.pushNext();

        AboutRentOrderPage objAboutRent = new AboutRentOrderPage(driver, jse);
        objAboutRent.fillForm(order);
        objAboutRent.pushOrder();

        ConfirmationOrderPage objConfirmationPage = new ConfirmationOrderPage(driver, jse);
        objConfirmationPage.waitPage();
        objConfirmationPage.pushYes();

        OrderApprovedPage objApproved = new OrderApprovedPage(driver, jse);
        assertTrue("НЕТ окна \"Заказ оформлен\" после подтверждения заказа.", objApproved.isUp());
    }
}
