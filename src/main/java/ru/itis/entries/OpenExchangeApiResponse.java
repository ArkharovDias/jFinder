package ru.itis.entries;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class OpenExchangeApiResponse {
    @JsonProperty("rates")
    List<OpenExchangeApiRecord> data;
}
