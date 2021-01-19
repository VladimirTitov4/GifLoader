package ru.titov.gifloader.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.titov.gifloader.components.CurrencyDownloader;
import ru.titov.gifloader.components.GifDownloader;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CurrencyServiceTest {

    @Value("${appId}")
    private String appId;

    @MockBean
    private CurrencyDownloader currencyComponent;

    @MockBean
    private GifDownloader gifDownloader;

    @Test
    public void getUrlTest() {

    }
}
