package ru.titov.gifloader.dto.gif;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class ResponseDto {
    
    @JsonProperty("data")
    public DataDto dataDto;
}
