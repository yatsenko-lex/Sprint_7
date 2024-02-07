package ru.praktikum.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CourierDeleteRequest {

    @JsonProperty("id")
    private String id;
}
