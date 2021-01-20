package ru.titov.gifloader.components;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.titov.gifloader.util.CurrencyValueConverter;

@Slf4j
@Component
@RequiredArgsConstructor
public class CurrencyComparer {

    @Value("${currency.type}")
    private String currency;

    private final CurrencyDownloader currencyDownloader;

    public int compareLatestAndHistoricalValues(String appId) {
        String current = currencyDownloader.getLatestValue(appId, currency);
        String previous = currencyDownloader.getHistoricalValue(appId, currency);
        return Double.compare(CurrencyValueConverter.getParsedDouble(current), CurrencyValueConverter.getParsedDouble(previous));
    }
}
