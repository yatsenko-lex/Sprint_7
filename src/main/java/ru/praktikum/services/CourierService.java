package ru.praktikum.services;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.praktikum.Specifications;
import ru.praktikum.pojo.CourierCreateRequest;
import ru.praktikum.pojo.CourierDeleteRequest;
import ru.praktikum.pojo.CourierLoginRequest;

public class CourierService extends Specifications {

    @Step("Создание курьера")
    public ValidatableResponse createCourier(String login, String password, String firstName) {
        CourierCreateRequest request = new CourierCreateRequest().setLogin(login).setPassword(password).setFirstName(firstName);
        return baseRequest().body(request).when().post(COURIER_ACTIONS).then();
    }

    @Step("Логин курьера")
    public ValidatableResponse loginCourier(String login, String password) {
        CourierLoginRequest request = new CourierLoginRequest().setLogin(login).setPassword(password);
        return baseRequest().body(request).when().post(COURIER_LOGIN).then();
    }

    @Step("Удаление курьера")
    public ValidatableResponse deleteCourier(int id){
        CourierDeleteRequest request = new CourierDeleteRequest().setId(id);
        return baseRequest().body(request).when().delete(COURIER_ACTIONS).then();
    }
}
