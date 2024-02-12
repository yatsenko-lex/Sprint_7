package ru.praktikum.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CourierDeleteRequest {

    @JsonProperty("id")
    private Integer id;
}
