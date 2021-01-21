package ru.titov.gifloader.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CurrencyValueConverter {

    public Double getParsedDouble(String currencyValue) {
        if (currencyValue.contains(",")) {
            String replacedRubleValue = currencyValue.replaceAll(",", ".");
            return Double.parseDouble(replacedRubleValue);
        } else {
            return Double.parseDouble(currencyValue);
        }
    }
}