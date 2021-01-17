package ru.titov.gifloader.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.titov.gifloader.components.CurrencyComponent;
import ru.titov.gifloader.components.GifComponent;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    @Value("${appId}")
    private String appId;

    private final CurrencyComponent currencyComponent;

    private final GifComponent gifComponent;

    public String getUrl() {
        int compare = currencyComponent.compareCurrentAndHistoricalRubleValues(appId);
        return gifComponent.getUrl(compare);
    }

    public String getIframe() {
        String url = getUrl();
        return String.format("<iframe src=\"%s\" width=\"480\" height=\"270\" frameBorder=\"0\" class=\"giphy-embed\" allowFullScreen></iframe>", url);
    }
}
