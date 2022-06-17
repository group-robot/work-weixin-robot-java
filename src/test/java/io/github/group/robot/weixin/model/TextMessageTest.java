package io.github.group.robot.weixin.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Map;

@Slf4j
class TextMessageTest {

    @Test
    void textBuild() {
        TextMessage message = TextMessage.TextMessageBuilder.builder()
            .setContent("广州今日天气：29度，大部分多云，降雨概率：60%")
            .setMentioned("wangqing")
            .mentionedAtAll()
            .setMobile("13800001111")
            .mobileAtAll()
            .build();
        Map<String, Object> messageMap = message.toMessageMap();

        log.info(messageMap.toString());
    }
}
