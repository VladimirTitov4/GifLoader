package ru.titov.gifloader.components;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.titov.gifloader.feign.CurrencyFeignClient;
import ru.titov.gifloader.util.CurrencyDateConverter;

import java.time.LocalDate;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class CurrencyDownloader {

    private final CurrencyFeignClient feignClient;

    public String getLatestValue(String appId, String currency) {
        Map<String, String> details = feignClient.getLatestQuotes(appId, currency).getRates().getValues();
        for (Map.Entry<String, String> entry : details.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(currency)) {
                log.info("Текущее значение курса выбранной валюты = " + entry.getValue());
                return entry.getValue();
            }
        }
        return null;
    }

    public String getHistoricalValue(String appId, String currency) {
        LocalDate latestValueDate = CurrencyDateConverter.getCurrentValueDate(feignClient.getLatestQuotes(appId, currency).getTimestamp());
        log.info("Текущая дата " + latestValueDate +  "timestamp = " + feignClient.getLatestQuotes(appId, currency).getTimestamp());
        LocalDate previousDate = latestValueDate.minusDays(1);
        Map<String, String> details = feignClient.getHistoricalQuotes(previousDate, appId, currency).getRates().getValues();
        for (Map.Entry<String, String> entry : details.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(currency)) {
                log.info("Историческое значение курса выбранной валюты = " + entry.getValue());
                return entry.getValue();
            }
        }
        return null;
    }
}

