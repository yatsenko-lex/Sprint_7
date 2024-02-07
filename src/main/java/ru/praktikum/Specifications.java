package ru.praktikum;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Specifications {

    private static final String BASE_URI = "https://qa-scooter.praktikum-services.ru/";

    public RequestSpecification baseRequest(){
        return given().baseUri(BASE_URI).contentType(ContentType.JSON);
    }
}
