package ru.praktikum.services;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.praktikum.Specifications;
import ru.praktikum.pojo.CreateOrderRequest;
import ru.praktikum.pojo.GetOrdersRequest;

public class OrderService extends Specifications {

    @Step("Получение списка заказов")
    public ValidatableResponse getOrdersList(Integer courierId, int page, int limit, String nearestStation) {
        GetOrdersRequest request = new GetOrdersRequest().setCourierId(courierId)
                .setPage(page).setLimit(limit).setNearestStation(nearestStation);
        return baseRequest().body(request).when().get(ORDERS).then();
    }

    @Step("Создание заказа")
    public ValidatableResponse createOrder(String firstName, String lastName, String address, int metroStation, String phone,
                                           int rentTime, String deliveryDate, String comment, String[] colour) {
        CreateOrderRequest request = new CreateOrderRequest().setFirstName(firstName).setLastName(lastName)
                .setAddress(address).setMetroStation(metroStation).setPhone(phone).setRentTime(rentTime)
                .setDeliveryDate(deliveryDate).setComment(comment).setColor(colour);
        return baseRequest().body(request).when().post(ORDERS).then();
    }
}
