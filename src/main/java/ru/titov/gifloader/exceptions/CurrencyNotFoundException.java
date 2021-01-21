package ru.titov.gifloader.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CurrencyNotFoundException extends RuntimeException {

    public CurrencyNotFoundException(String message) {
        super(message);
        log.error(message);
    }
}
