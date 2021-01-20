package ru.titov.gifloader.dto.currency;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rates {

    Map<String, String> values = new HashMap<>();

    @JsonAnySetter
    void setValues(String key, String value) {
        values.put(key, value);
    }
}
