package ru.praktikum.pojo;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateOrderRequest {

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("address")
    private String address;

    @JsonProperty("metroStation")
    private Integer metroStation;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("rentTime")
    private Integer rentTime;

    @JsonProperty("deliveryDate")
    private String deliveryDate;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("color")
    private String[] color;
}
