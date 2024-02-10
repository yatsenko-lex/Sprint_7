package ru.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.services.OrderService;

import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)
public class CreateOrderTests extends OrderService {

    private final String[] color;

    public CreateOrderTests(String[] color) {
        this.color = color;
    }

    @Parameterized.Parameters
    public static Object[][]colours() {
        return new Object[][] {
                new String[][]{{"GREY"}},
                new String[][]{{"BLACK"}},
                new String[][]{{"BLACK", "GREY"}},
                new String[][]{{}},
        };
    }

    @Test
    @DisplayName("Создание заказа")
    public void createOrderWIthDifferentColorsTest() {
        createOrder("Name", "LastName", "Address", 1,
                "89209999999", 3, "2024-10-10", "Comment", color)
                .statusCode(201).body("track", notNullValue());

    }


}
