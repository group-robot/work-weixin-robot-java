package io.github.group.robot.weixin.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Map;

@Slf4j
class ImageMessageTest {


    @Test
    void imageMessageTest() {
        ImageMessage message = ImageMessage.ImageMessageBuilder.builder()
            .base64("data")
            .md5("md5")
            .build();
        Map<String, Object> messageMap = message.toMessageMap();
        log.info(messageMap.toString());
    }
}
