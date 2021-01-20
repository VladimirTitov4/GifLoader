package ru.titov.gifloader.feign;

import feign.Param;
import feign.RequestLine;
import ru.titov.gifloader.dto.currency.CurrencyResponseDto;

import java.time.LocalDate;

public interface CurrencyFeignClient {

    @RequestLine("GET /latest.json?app_id={appId}&symbols={currency}")
    CurrencyResponseDto getLatestQuotes(@Param("appId") String appId, @Param("currency") String currency);

    @RequestLine("GET /historical/{date}.json?app_id={appId}&symbols={currency}")
    CurrencyResponseDto getHistoricalQuotes(
            @Param("date") LocalDate date,
            @Param("appId") String appId,
            @Param("currency") String currency);
}
