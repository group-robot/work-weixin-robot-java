package io.github.group.robot.weixin.model;

import io.github.group.robot.weixin.model.news.Article;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class NewsMessageTest {

    @Test
    void newsMessageTest() {
        NewsMessage message = NewsMessage.NewsMessageBuilder.builder()
            .addArticle(
                Article
                    .builder()
                    .title("中秋节礼品领取")
                    .description("今年中秋节公司有豪礼相送")
                    .url("www.qq.com")
                    .picurl("http://res.mail.qq.com/node/ww/wwopenmng/images/independent/doc/test_pic_msg1.png")
                    .build()
            ).build();
        log.info(message.toMessageMap().toString());
    }
}
