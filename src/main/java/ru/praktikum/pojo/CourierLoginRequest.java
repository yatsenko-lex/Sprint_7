package ru.praktikum.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourierLoginRequest {

    @JsonProperty("login")
    private String login;

    @JsonProperty("password")
    private String password;
}
