package ru.titov.gifloader.util;

import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@UtilityClass
public class CurrencyDateConverter {

    public LocalDate getCurrentValueDate(Long timestamp) {
        return Instant.ofEpochMilli(timestamp * 1000).atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
