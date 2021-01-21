package ru.titov.gifloader.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.titov.gifloader.components.CurrencyComparer;
import ru.titov.gifloader.components.GifDownloader;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyService {

    @Value("${apiKeys.currency}")
    private String appId;

    private final CurrencyComparer currencyComparer;
    private final GifDownloader gifDownloader;
    public final String RAW_URL = "<iframe src=\"%s\" width=\"480\" height=\"270\" frameBorder=\"0\" class=\"giphy-embed\" allowFullScreen></iframe>";

    private String getUrl() {
        log.info("Получен запрос на формирование ссылки на gif-изображение");
        int compare = currencyComparer.compareLatestAndHistoricalValues(appId);
        return gifDownloader.getUrlBasedOnComparedValue(compare);
    }

    public String getIframe() {
        String gifEmbedUrl = getUrl();
        log.info("Сформированный gifEmbedUrl: " + gifEmbedUrl);
        return String.format(RAW_URL, gifEmbedUrl);
    }
}
