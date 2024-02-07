package ru.praktikum;

import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import ru.praktikum.pojo.CourierCreateRequest;

import static org.hamcrest.CoreMatchers.is;

public class CreateCourierTests extends Specifications{

    private String login = RandomStringUtils.random(5);
    private String password = RandomStringUtils.random(5);
    private String firstName = RandomStringUtils.random(5);

    @Test
    public void createCourierTest() {
        ValidatableResponse response = baseRequest()
                .body(new CourierCreateRequest().setFirstName(firstName).setLogin(login).setPassword(password))
                .when()
                .post("/api/v1/courier").then().statusCode(201).body("ok", is(true));
    }

    @Test
    public void createExistedNameCourierTest() {
        ValidatableResponse response = baseRequest()
                .body(new CourierCreateRequest().setFirstName(firstName).setLogin("ninja").setPassword(password))
                .when()
                .post("/api/v1/courier").then().statusCode(409)
                .body("message", is("Этот логин уже используется. Попробуйте другой."));
    }

    @Test
    public void createCourierBadRequestTest() {
        ValidatableResponse response = baseRequest()
                .body(new CourierCreateRequest().setPassword(password))
                .when()
                .post("/api/v1/courier").then().statusCode(400)
                .body("message", is("Недостаточно данных для создания учетной записи"));
    }
}
