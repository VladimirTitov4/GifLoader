package ru.titov.gifloader.components;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.titov.gifloader.util.CurrencyValueConverter;

@Component
@RequiredArgsConstructor
public class CurrencyComparer {

    private final CurrencyDownloader currencyDownloader;

    public int compareCurrentAndHistoricalRubleValues(String appId) {
        String current = currencyDownloader.getLatestRubleValue(appId);
        String previous = currencyDownloader.getHistoricalRubleValue(appId);
        return Double.compare(CurrencyValueConverter.getParsedDouble(current), CurrencyValueConverter.getParsedDouble(previous));
    }
}
