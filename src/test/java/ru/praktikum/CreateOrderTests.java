package ru.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.pojo.CreateOrderRequest;

import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)
public class CreateOrderTests extends Specifications{

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
    public void createOrderWIthDifferentColorsTest() {baseRequest()
            .body(new CreateOrderRequest().setFirstName("Name").setLastName("LastName").setAddress("Address")
                    .setMetroStation(1).setPhone("89209999999").setRentTime(3).setDeliveryDate("2024-10-10")
                    .setComment("Comment").setColor(color))
            .when()
            .post("/api/v1/orders")
            .then().statusCode(201).body("track", notNullValue());

    }


}
