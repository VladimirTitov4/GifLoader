package ru.titov.gifloader.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.titov.restservice.dto.CurrentRubleCurrencyDto;
import ru.titov.restservice.feign.CurrencyFeignClient;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CurrencyServiceTest {

    @Value("${appId}")
    private String appId;

    @MockBean
    private CurrencyFeignClient currencyFeignClient;

    private final CurrentRubleCurrencyDto rubleCurrencyDto = mock(CurrentRubleCurrencyDto.class);

    @Test
    public void getDtoTest() {
        when(currencyFeignClient.getLatestQuotes(appId)).thenReturn(rubleCurrencyDto);
        System.out.println("bbbb " + rubleCurrencyDto.getRubleValue());
    }
}
