package ru.titov.gifloader.feign;

import feign.Param;
import feign.RequestLine;
import ru.titov.gifloader.dto.gif.GifResponseDto;
import ru.titov.gifloader.enums.GifTagType;

public interface GifFeignClient {

    @RequestLine("GET ?api_key={apiKey}&tag={tag}")
    GifResponseDto getRandomGifByTag(@Param("apiKey") String apiKey, @Param("tag") GifTagType tag);
}
