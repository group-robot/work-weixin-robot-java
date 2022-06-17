package io.github.group.robot.weixin.model.card;

import io.github.group.robot.weixin.commons.CardActionType;
import io.github.group.robot.weixin.commons.DescColor;
import io.github.group.robot.weixin.commons.HorizontalContentType;
import io.github.group.robot.weixin.commons.ImageTextAreaType;
import io.github.group.robot.weixin.commons.JumpType;
import io.github.group.robot.weixin.commons.QuoteType;
import io.github.group.robot.weixin.model.card.widget.CardAction;
import io.github.group.robot.weixin.model.card.widget.CardImage;
import io.github.group.robot.weixin.model.card.widget.HorizontalContent;
import io.github.group.robot.weixin.model.card.widget.ImageTextArea;
import io.github.group.robot.weixin.model.card.widget.Jump;
import io.github.group.robot.weixin.model.card.widget.MainTitle;
import io.github.group.robot.weixin.model.card.widget.QuoteArea;
import io.github.group.robot.weixin.model.card.widget.Source;
import io.github.group.robot.weixin.model.card.widget.VerticalContent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class NewsNoticeCardTest {

    @Test
    void newsNoticeCardTest() {
        NewsNoticeCard card = NewsNoticeCard.NewsNoticeCardBuilder.builder()
            .source(
                Source.builder()
                    .iconUrl("https://wework.qpic.cn/wwpic/252813_jOfDHtcISzuodLa_1629280209/0")
                    .desc("企业微信")
                    .descColor(DescColor.GREY)
                    .build()
            )
            .mainTitle(
                MainTitle.builder()
                    .title("欢迎使用企业微信")
                    .desc("您的好友正在邀请您加入企业微信")
                    .build()
            )
            .cardImage(
                CardImage.builder()
                    .url("https://wework.qpic.cn/wwpic/354393_4zpkKXd7SrGMvfg_1629280616/0")
                    .aspectRatio(2.25)
                    .build()
            )
            .imageTextArea(
                ImageTextArea.builder()
                    .type(ImageTextAreaType.URL)
                    .url("https://work.weixin.qq.com")
                    .title("欢迎使用企业微信")
                    .desc("您的好友正在邀请您加入企业微信")
                    .imageUrl("https://wework.qpic.cn/wwpic/354393_4zpkKXd7SrGMvfg_1629280616/0")
                    .build()
            )
            .quoteArea(
                QuoteArea.builder()
                    .type(QuoteType.URL)
                    .url("https://work.weixin.qq.com/?from=openApi")
                    .appid("APPID")
                    .pagePath("PAGEPATH")
                    .title("引用文本标题")
                    .quoteText("Jack：企业微信真的很好用~\nBalian：超级好的一款软件！")
                    .build()
            )
            .addVerticalContent(
                VerticalContent.builder()
                    .title("惊喜红包等你来拿")
                    .desc("下载企业微信还能抢红包！")
                    .build()
            )
            .addHorizontalContent(
                HorizontalContent.builder()
                    .keyname("邀请人")
                    .value("张三")
                    .build(),
                HorizontalContent.builder()
                    .keyname("企微官网")
                    .value("点击访问")
                    .type(HorizontalContentType.URL)
                    .url("https://work.weixin.qq.com/?from=openApi")
                    .build(),
                HorizontalContent.builder()
                    .keyname("企微下载")
                    .value("企业微信.apk")
                    .type(HorizontalContentType.DOWNLOAD)
                    .mediaId("MEDIAID")
                    .build()
            )
            .addJump(
                Jump.builder()
                    .type(JumpType.URL)
                    .url("https://work.weixin.qq.com/?from=openApi")
                    .title("企业微信官网")
                    .build(),
                Jump.builder()
                    .type(JumpType.MINI_APP)
                    .appid("APPID")
                    .pagePath("PAGEPATH")
                    .title("跳转小程序")
                    .build()
            )
            .action(
                CardAction.builder()
                    .type(CardActionType.URL)
                    .url("https://work.weixin.qq.com/?from=openApi")
                    .appid("APPID")
                    .pagePath("PAGEPATH")
                    .build()
            )
            .build();
        log.info(card.toMessageMap().toString());
    }
}
