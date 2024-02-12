package ru.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Test;
import ru.praktikum.services.CourierService;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

public class LoginCourierTests {

    CourierService courierService = new CourierService();
    int id;

    @Test
    @DisplayName("Логин курьера")
    public void loginCourierTest() {
        String login = RandomStringUtils.random(5);
        String password = RandomStringUtils.random(5);
        String firstName = RandomStringUtils.random(5);
        courierService.createCourier(login, password, firstName);
        courierService.loginCourier(login, password).statusCode(200).body("id", notNullValue());
        id = courierService.loginCourier(login, password).extract().body().path("id");
    }

    @Test
    @DisplayName("Логин курьера без поля 'Login'")
    public void loginWithoutLoginTest() {
        courierService.loginCourier("", "qwe")
                .statusCode(400).body("message", is("Недостаточно данных для входа"));
    }

    @Test
    @DisplayName("Логин курьера без поля 'Password'")
    public void loginWithoutPasswordTest() {
        courierService.loginCourier("qwe", "")
                .statusCode(400).body("message", is("Недостаточно данных для входа"));
    }

    @Test
    @DisplayName("Логин курьера с неверным полем 'Login'")
    public void loginWithWrongLoginTest() {
        String login = RandomStringUtils.random(5);
        String password = RandomStringUtils.random(5);
        String firstName = RandomStringUtils.random(5);
        courierService.createCourier(login, password, firstName);
        courierService.loginCourier("1111qweqweqwe", password)
                .statusCode(404).body("message", is("Учетная запись не найдена"));
        id = courierService.loginCourier(login, password).extract().body().path("id");
    }

    @Test
    @DisplayName("Логин курьера с неверным полем 'Password'")
    public void loginWithWrongPasswordTest() {
        String login = RandomStringUtils.random(5);
        String password = RandomStringUtils.random(5);
        String firstName = RandomStringUtils.random(5);
        courierService.createCourier(login, password, firstName);
        courierService.loginCourier(login, "qweqweqweqew")
                .statusCode(404).body("message", is("Учетная запись не найдена"));
        id = courierService.loginCourier(login, password).extract().body().path("id");
    }

    @After
    public void deleteData() {
        courierService.deleteCourier(id);
    }
}
