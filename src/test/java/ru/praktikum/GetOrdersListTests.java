package ru.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.praktikum.services.OrderService;

import static org.hamcrest.CoreMatchers.notNullValue;

public class GetOrdersListTests {

    OrderService orderService = new OrderService();

    @Test
    @DisplayName("Получение списка заказов")
    public void getOrderListTest() {
        orderService.getOrdersList(null, 0, 100, "1")
                .statusCode(200).body("orders", notNullValue());
    }
}
