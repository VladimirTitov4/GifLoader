package ru.titov.gifloader.dto.gif;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DataDto {
    @JsonProperty("embed_url")
    public String url;
}
