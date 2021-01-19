package ru.titov.gifloader.components;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.titov.gifloader.dto.gif.ResponseDto;
import ru.titov.gifloader.enums.GifTagType;
import ru.titov.gifloader.feign.GifFeignClient;

import static ru.titov.gifloader.enums.GifTagType.BROKE;
import static ru.titov.gifloader.enums.GifTagType.RICH;

@Component
@RequiredArgsConstructor
public class GifDownloader {

    @Value("${apiKeys.gif}")
    private String apiKey;

    private final GifFeignClient feignClient;

    public ResponseDto getGifUrl(GifTagType tag) {
        return feignClient.getRandomGifByTag(apiKey, tag);
    }

    public String getUrlBasedOnComparedValue(int compare) {
        return compare == 1 ? getGifUrl(RICH).getDataDto().getUrl() :
                              getGifUrl(BROKE).getDataDto().getUrl();
    }
}
