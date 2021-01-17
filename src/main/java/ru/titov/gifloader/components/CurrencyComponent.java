package ru.titov.gifloader.components;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.titov.gifloader.feign.CurrencyFeignClient;
import ru.titov.gifloader.util.ConverterUtil;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Component
@RequiredArgsConstructor
public class CurrencyComponent {

    private final CurrencyFeignClient currencyFeignClient;

    public String getRawRubleValue(String appId) {
        return currencyFeignClient.getLatestQuotes(appId).getRubleValue();
    }

    public LocalDate getCurrentRubleValueDate(String appId) {
        return Instant.ofEpochMilli(currencyFeignClient.getLatestQuotes(appId).getTimestamp() * 1000).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public String getHistoricalRubleValue(String appId) {
        LocalDate currentRubleValueDate = getCurrentRubleValueDate(appId);
        LocalDate previousDate = currentRubleValueDate.minusDays(1);
        return currencyFeignClient.getHistoricalQuotes(previousDate, appId).rubleValue;
    }

    public int compareCurrentAndHistoricalRubleValues(String appId) {
        String current = getRawRubleValue(appId);
        String previous = getHistoricalRubleValue(appId);
        return Double.compare(ConverterUtil.getParsedDouble(current), (ConverterUtil.getParsedDouble(previous)));
    }
}

