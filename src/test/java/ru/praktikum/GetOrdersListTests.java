package ru.praktikum;

import org.junit.Test;
import ru.praktikum.pojo.GetOrdersRequest;

import static org.hamcrest.CoreMatchers.notNullValue;

public class GetOrdersListTests extends Specifications {

    @Test
    public void getOrderListTest() {
        baseRequest()
                .body(new GetOrdersRequest().setCourierId(null).setPage(0).setLimit(100).setNearestStation("1"))
                .when()
                .get("/api/v1/orders")
                .then().statusCode(200).body("orders", notNullValue());
    }
}
