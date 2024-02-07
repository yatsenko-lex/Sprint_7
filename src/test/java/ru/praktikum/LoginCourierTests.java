package ru.praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import ru.praktikum.pojo.CourierCreateRequest;
import ru.praktikum.pojo.CourierLoginRequest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

public class LoginCourierTests extends Specifications{

    @Test
    public void loginCourierTest() {
        String login = RandomStringUtils.random(5);
        String password = RandomStringUtils.random(5);
        String firstName = RandomStringUtils.random(5);
        baseRequest()
                .body(new CourierCreateRequest().setFirstName(firstName).setLogin(login).setPassword(password))
                .when()
                .post("/api/v1/courier");
        baseRequest().body(new CourierLoginRequest().setLogin(login).setPassword(password))
                .when()
                .post("/api/v1/courier/login")
                .then().statusCode(200).body("id", notNullValue());
    }

    @Test
    public void loginWithoutLoginTest() {
        baseRequest().body(new CourierLoginRequest().setLogin("").setPassword("qwe"))
                .when()
                .post("/api/v1/courier/login")
                .then().statusCode(400).body("message", is("Недостаточно данных для входа"));
    }

    @Test
    public void loginWithoutPasswordTest() {
        baseRequest().body(new CourierLoginRequest().setLogin("").setPassword("qwe"))
                .when()
                .post("/api/v1/courier/login")
                .then().statusCode(400).body("message", is("Недостаточно данных для входа"));
    }

    @Test
    public void loginWithWrongLoginTest() {
        String login = RandomStringUtils.random(5);
        String password = RandomStringUtils.random(5);
        String firstName = RandomStringUtils.random(5);
        baseRequest()
                .body(new CourierCreateRequest().setFirstName(firstName).setLogin(login).setPassword(password))
                .when()
                .post("/api/v1/courier");
        baseRequest().body(new CourierLoginRequest().setLogin("1111qweqweqwe").setPassword(password))
                .when()
                .post("/api/v1/courier/login")
                .then().statusCode(404).body("message", is("Учетная запись не найдена"));
    }

    @Test
    public void loginWithWrongPasswordTest() {
        String login = RandomStringUtils.random(5);
        String password = RandomStringUtils.random(5);
        String firstName = RandomStringUtils.random(5);
        baseRequest()
                .body(new CourierCreateRequest().setFirstName(firstName).setLogin(login).setPassword(password))
                .when()
                .post("/api/v1/courier");
        baseRequest().body(new CourierLoginRequest().setLogin(login).setPassword("qweqweqwe"))
                .when()
                .post("/api/v1/courier/login")
                .then().statusCode(404).body("message", is("Учетная запись не найдена"));
    }
}
