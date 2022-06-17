package io.github.group.robot.weixin.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class MarkdownMessageTest {

    @Test
    void markdownMessageTest() {
        MarkdownMessage message = MarkdownMessage.MarkdownMessageBuilder.builder()
            .content("实时新增用户反馈<font color=\"warning\">132例</font>，请相关同事注意。\n"
                + ">类型:<font color=\"comment\">用户反馈</font>"
                + ">普通用户反馈:<font color=\"comment\">117例</font>"
                + ">VIP用户反馈:<font color=\"comment\">15例</font>")
            .atAll()
            .build();

        log.info(message.toMessageMap().toString());
    }
}
