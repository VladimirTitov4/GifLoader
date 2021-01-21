package ru.titov.gifloader.components;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.titov.gifloader.dto.currency.CurrencyResponseDto;
import ru.titov.gifloader.feign.CurrencyFeignClient;

import java.io.IOException;
import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CurrencyDownloaderTest {

    @MockBean
    private CurrencyFeignClient feignClient;

    private final ClassPathResource resource = new ClassPathResource("currencyResponse.json");

    @Test
    public void getLatestRubleValueTest() throws IOException {
        CurrencyResponseDto latestRuble = new ObjectMapper().readValue(resource.getFile(), CurrencyResponseDto.class);
        when(feignClient.getLatestQuotes(anyString(), anyString())).thenReturn(latestRuble);
    }

    @Test
    public void getHistoricalRubleValue() throws IOException {
        CurrencyResponseDto historicalRuble = new ObjectMapper().readValue(resource.getFile(), CurrencyResponseDto.class);
        when(feignClient.getHistoricalQuotes(any(LocalDate.class), anyString(), anyString())).thenReturn(historicalRuble);
    }
}
