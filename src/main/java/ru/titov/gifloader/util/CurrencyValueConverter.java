package ru.titov.gifloader.util;

import lombok.experimental.UtilityClass;
import org.springframework.lang.Nullable;

@UtilityClass
public class CurrencyValueConverter {

    public Double getParsedDouble(@Nullable String currencyValue) {
        if (null != currencyValue) {
            if (currencyValue.contains(",")) {
                String replacedRubleValue = currencyValue.replaceAll(",", ".");
                return Double.parseDouble(replacedRubleValue);
            } else {
                return Double.parseDouble(currencyValue);
            }
        }
        return null;
    }
}
