package ru.praktikum.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetOrdersRequest {

    @JsonProperty("courierId")
    private Integer courierId;

    @JsonProperty("nearestStation")
    private String nearestStation;

    @JsonProperty("limit")
    private Integer limit;

    @JsonProperty("page")
    private Integer page;
}
