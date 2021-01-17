package ru.titov.gifloader.feign;

import feign.Param;
import feign.RequestLine;
import ru.titov.gifloader.dto.gif.ResponseDto;

public interface GifFeignClient {

    @RequestLine("GET ?api_key={apiKey}&tag={tag}")
    ResponseDto getRandomGif(@Param("apiKey") String apiKey, @Param("tag") String tag);
}
