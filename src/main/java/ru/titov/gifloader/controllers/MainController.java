package ru.titov.gifloader.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.titov.gifloader.service.CurrencyService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {

    private final CurrencyService currencyService;

    @GetMapping("/")
    public String showGifBasedOnComparedCurrencyValues() {
        log.info("Получен запрос на получение gif");
        return currencyService.getIframe();
    }
}
