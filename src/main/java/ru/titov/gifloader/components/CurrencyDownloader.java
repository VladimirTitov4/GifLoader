package ru.titov.gifloader.components;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.titov.gifloader.feign.CurrencyFeignClient;
import ru.titov.gifloader.util.CurrencyDateConverter;

import java.time.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class CurrencyDownloader {

    private final CurrencyFeignClient feignClient;

    public String getLatestRubleValue(String appId) {
        String latestRubleValue = feignClient.getLatestQuotes(appId).getRubleValue();
        log.info("Текущее значение курса рубля = " + latestRubleValue);
        return latestRubleValue;
    }

    public String getHistoricalRubleValue(String appId) {
        LocalDate currentRubleValueDate = CurrencyDateConverter.getCurrentRubleValueDate(feignClient.getLatestQuotes(appId).getTimestamp());
        LocalDate previousDate = currentRubleValueDate.minusDays(1);
        String historicalRubleValue = feignClient.getHistoricalQuotes(previousDate, appId).getRubleValue();
        log.info("Предыдущее значение курса рубля = " + historicalRubleValue);
        return historicalRubleValue;
    }
}

