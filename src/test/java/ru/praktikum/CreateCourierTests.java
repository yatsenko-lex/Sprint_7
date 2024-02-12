package ru.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import ru.praktikum.services.CourierService;

import static org.hamcrest.CoreMatchers.is;

public class CreateCourierTests {

    CourierService courierService = new CourierService();
    private String login = RandomStringUtils.random(5);
    private String password = RandomStringUtils.random(5);
    private String firstName = RandomStringUtils.random(5);

    @Test
    @DisplayName("Создание курьера")
    public void createCourierTest() {
        courierService.createCourier(login, password, firstName).statusCode(201).body("ok", is(true));
        Integer id = courierService.loginCourier(login, password).extract().body().path("id");
        courierService.deleteCourier(id);
    }

    @Test
    @DisplayName("Создание курьера с существующим логином")
    public void createExistedNameCourierTest() {
        courierService.createCourier(login, password, firstName);
        courierService.createCourier(login, password, firstName).statusCode(409)
                .body("message", is("Этот логин уже используется. Попробуйте другой."));
        Integer id = courierService.loginCourier(login, password).extract().body().path("id");
        courierService.deleteCourier(id);
    }

    @Test
    @DisplayName("Создание курьера. Запрос без логина")
    public void createCourierWithoutLoginTest() {
        courierService.createCourier(null, "qweqwe", firstName).statusCode(400)
                .body("message", is("Недостаточно данных для создания учетной записи"));
    }

    @Test
    @DisplayName("Создание курьера. Запрос без пароля   ")
    public void createCourierWithoutPasswordTest() {
        courierService.createCourier("qwe", null, firstName).statusCode(400)
                .body("message", is("Недостаточно данных для создания учетной записи"));
    }
}
