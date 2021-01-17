package ru.titov.gifloader.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.titov.gifloader.service.CurrencyService;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final CurrencyService currencyService;

    @GetMapping("/")
    public String showIframe() {
        return currencyService.getIframe();
    }
}
