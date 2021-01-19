package ru.titov.gifloader.config;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.titov.gifloader.feign.CurrencyFeignClient;
import ru.titov.gifloader.feign.GifFeignClient;

@Configuration
public class FeignConfig {

    @Value("${url.currency}")
    private String currencyUrl;

    @Value("${url.gif}")
    private String gifUrl;

    @Bean
    public CurrencyFeignClient currencyFeignClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger(CurrencyFeignClient.class))
                .logLevel(Logger.Level.FULL)
                .target(CurrencyFeignClient.class, currencyUrl);
    }

    @Bean
    public GifFeignClient gifFeignClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger(GifFeignClient.class))
                .logLevel(Logger.Level.FULL)
                .target(GifFeignClient.class, gifUrl);
    }
}
