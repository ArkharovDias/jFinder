package ru.itis.entries;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OpenExchangeApiRecord {

    @JsonProperty("CharCode")
    private String code;

    @JsonProperty("Value")
    private String value;
}
