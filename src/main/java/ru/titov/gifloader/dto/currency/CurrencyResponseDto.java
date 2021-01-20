package ru.titov.gifloader.dto.currency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyResponseDto {

    @JsonProperty("timestamp")
    public Long timestamp;

    @JsonProperty("rates")
    public Rates rates;
}
