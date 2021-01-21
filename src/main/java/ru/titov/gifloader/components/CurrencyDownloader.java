package ru.titov.gifloader.components;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.titov.gifloader.feign.CurrencyFeignClient;
import ru.titov.gifloader.util.CurrencyDateConverter;

import java.time.LocalDate;

@Slf4j
@Component
@RequiredArgsConstructor
public class CurrencyDownloader {

    private final CurrencyFeignClient feignClient;

    public String getLatestValue(String appId, String currency) {
        String currencyValue = feignClient.getLatestQuotes(appId, currency).getRates().getCurrencyValue(currency);
        log.info(String.format("Текущее значение валюты %s = %s", currency, currencyValue));
        return currencyValue;
    }

    public String getHistoricalValue(String appId, String currency) {
        LocalDate latestValueDate = CurrencyDateConverter.getCurrentValueDate(feignClient.getLatestQuotes(appId, currency).getTimestamp());
        LocalDate previousDate = latestValueDate.minusDays(1);
        String currencyValue = feignClient.getHistoricalQuotes(previousDate, appId, currency).getRates().getCurrencyValue(currency);
        log.info(String.format("Историческое значение валюты %s = %s", currency, currencyValue));
        return currencyValue;
    }
}

