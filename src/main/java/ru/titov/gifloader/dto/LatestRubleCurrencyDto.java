
package ru.titov.gifloader.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LatestRubleCurrencyDto {
    @JsonProperty("timestamp")
    public Long timestamp;
    public String rubleValue;

    @JsonProperty("rates")
    private void unpackNested(Map<String, String> rate) {
        this.rubleValue = rate.get("RUB");
    }
}
