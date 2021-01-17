package ru.titov.gifloader.components;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.titov.gifloader.dto.gif.ResponseDto;
import ru.titov.gifloader.feign.GifFeignClient;

@Component
@RequiredArgsConstructor
public class GifComponent {

    @Value("${apiKey}")
    private String apiKey;

    private final GifFeignClient feignClient;

    public ResponseDto getRandomGif(String tag) {
        return feignClient.getRandomGif(apiKey, tag);
    }

    public String getUrl(int compare) {
        return compare == 1 ? getRandomGif("rich").getDataDto().getUrl() :
                              getRandomGif("broke").getDataDto().getUrl();
    }
}
