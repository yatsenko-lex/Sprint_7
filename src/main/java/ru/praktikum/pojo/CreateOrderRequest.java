package ru.praktikum.pojo;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateOrderRequest {

    @JsonProperty("firstName")
    public String firstName;

    @JsonProperty("lastName")
    public String lastName;

    @JsonProperty("address")
    public String address;

    @JsonProperty("metroStation")
    public Integer metroStation;

    @JsonProperty("phone")
    public String phone;

    @JsonProperty("rentTime")
    public Integer rentTime;

    @JsonProperty("deliveryDate")
    public String deliveryDate;

    @JsonProperty("comment")
    public String comment;

    @JsonProperty("color")
    public String[] color;
}
