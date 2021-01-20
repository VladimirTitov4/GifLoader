package ru.titov.gifloader.components;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.titov.gifloader.dto.gif.GifResponseDto;
import ru.titov.gifloader.enums.GifTagType;
import ru.titov.gifloader.feign.GifFeignClient;

import static ru.titov.gifloader.enums.GifTagType.BROKE;
import static ru.titov.gifloader.enums.GifTagType.RICH;

@Slf4j
@Component
@RequiredArgsConstructor
public class GifDownloader {

    @Value("${apiKeys.gif}")
    private String apiKey;

    private final GifFeignClient feignClient;

    public GifResponseDto getGifUrl(GifTagType tag) {
        log.info("Получаем ссылку по тегу " + tag);
        return feignClient.getRandomGifByTag(apiKey, tag);
    }

    public String getUrlBasedOnComparedValue(int compare) {
        return compare == 1 ? getGifUrl(RICH).getDataDto().getUrl() :
                              getGifUrl(BROKE).getDataDto().getUrl();
    }
}
