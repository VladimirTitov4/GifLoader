package ru.titov.gifloader.feign;

import feign.Param;
import feign.RequestLine;
import ru.titov.gifloader.dto.LatestRubleCurrencyDto;
import ru.titov.gifloader.dto.HistoricalRubleCurrencyDto;

import java.time.LocalDate;

public interface CurrencyFeignClient {

    @RequestLine("GET /latest.json?app_id={appId}")
    LatestRubleCurrencyDto getLatestQuotes(@Param("appId") String appId);

    @RequestLine("GET /historical/{date}.json?app_id={appId}")
    HistoricalRubleCurrencyDto getHistoricalQuotes(
            @Param("date") LocalDate date,
            @Param("appId") String appId);
}
