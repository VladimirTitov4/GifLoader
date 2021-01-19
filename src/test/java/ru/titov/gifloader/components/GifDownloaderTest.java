package ru.titov.gifloader.components;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.titov.gifloader.dto.gif.ResponseDto;
import ru.titov.gifloader.enums.GifTagType;
import ru.titov.gifloader.feign.GifFeignClient;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class GifDownloaderTest {

    @MockBean
    private GifFeignClient feignClient;

    private final ClassPathResource resource = new ClassPathResource("gifResponse.json");

    @Test
    public void getGifUrlTest() throws IOException {
        ResponseDto responseDto = new ObjectMapper().readValue(resource.getFile(), ResponseDto.class);
        when(feignClient.getRandomGifByTag(anyString(),  any(GifTagType.class))).thenReturn(responseDto);
    }
}
