package ru.praktikum;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Specifications {

    private static final String BASE_URI = "https://qa-scooter.praktikum-services.ru/";
    protected static final String COURIER_ACTIONS = "/api/v1/courier";
    protected static final String COURIER_LOGIN = "/api/v1/courier/login";
    protected static final String ORDERS = "/api/v1/orders";


    public RequestSpecification baseRequest(){
        return given().baseUri(BASE_URI).contentType(ContentType.JSON);
    }
}
