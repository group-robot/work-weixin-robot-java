package io.github.group.robot.weixin;

import io.github.group.robot.weixin.commons.CardActionType;
import io.github.group.robot.weixin.commons.DescColor;
import io.github.group.robot.weixin.commons.HorizontalContentType;
import io.github.group.robot.weixin.commons.ImageTextAreaType;
import io.github.group.robot.weixin.commons.JumpType;
import io.github.group.robot.weixin.commons.QuoteType;
import io.github.group.robot.weixin.model.ImageMessage;
import io.github.group.robot.weixin.model.MarkdownMessage;
import io.github.group.robot.weixin.model.NewsMessage;
import io.github.group.robot.weixin.model.TemplateCardMessage;
import io.github.group.robot.weixin.model.TextMessage;
import io.github.group.robot.weixin.model.card.NewsNoticeCard;
import io.github.group.robot.weixin.model.card.TextNoticeCard;
import io.github.group.robot.weixin.model.card.widget.CardAction;
import io.github.group.robot.weixin.model.card.widget.CardImage;
import io.github.group.robot.weixin.model.card.widget.EmphasisContent;
import io.github.group.robot.weixin.model.card.widget.HorizontalContent;
import io.github.group.robot.weixin.model.card.widget.ImageTextArea;
import io.github.group.robot.weixin.model.card.widget.Jump;
import io.github.group.robot.weixin.model.card.widget.MainTitle;
import io.github.group.robot.weixin.model.card.widget.QuoteArea;
import io.github.group.robot.weixin.model.card.widget.Source;
import io.github.group.robot.weixin.model.card.widget.VerticalContent;
import io.github.group.robot.weixin.model.news.Article;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class RobotSendTest {
    WeixinRobotClient send = new WeixinRobotClient();

    @Test
    void send() {
        String webhook = System.getenv("webhook");
        send.setWebhook(webhook);
        RobotResult result = send.sendMessage(TextMessage.TextMessageBuilder.builder().setContent("Hi，我是机器人测试\n" +
            "由XX于06月17日添加到群").build());
        log.info(result.toString());
    }

    @Test
    void sendTextMessageTest() {
        String webhook = System.getenv("webhook");
        send.setWebhook(webhook);
        RobotResult result = send.sendMessage(TextMessage.TextMessageBuilder.builder().setContent("Hi，我是机器人测试\n" +
            "由XX于06月17日添加到群").build());
        log.info(result.toString());
    }

    @Test
    void sendTextMessageATAllTest() {
        String webhook = System.getenv("webhook");
        send.setWebhook(webhook);
        RobotResult result = send.sendMessage(TextMessage.TextMessageBuilder.builder().setContent("Hi，我是机器人测试\n" +
            "由XX于06月17日添加到群").mobileAtAll().build());
        log.info(result.toString());
    }

    @Test
    void sendMarkdownMessageTest() {
        String webhook = System.getenv("webhook");
        send.setWebhook(webhook);
        RobotResult result = send.sendMessage(
            MarkdownMessage.MarkdownMessageBuilder
                .builder()
                .content("实时新增用户反馈<font color=\"warning\">132例</font>，请相关同事注意。\n"
                    + ">类型:<font color=\"comment\">用户反馈</font>\n"
                    + ">普通用户反馈:<font color=\"comment\">117例</font>\n"
                    + ">VIP用户反馈:<font color=\"comment\">15例</font>")
                .build()
        );
        log.info(result.toString());
    }

    @Test
    void sendMarkdownMessageAtAllTest() {
        String webhook = System.getenv("webhook");
        send.setWebhook(webhook);
        RobotResult result = send.sendMessage(
            MarkdownMessage.MarkdownMessageBuilder
                .builder()
                .content("实时新增用户反馈<font color=\"warning\">132例</font>，请相关同事注意。\n"
                    + ">类型:<font color=\"comment\">用户反馈</font>\n"
                    + ">普通用户反馈:<font color=\"comment\">117例</font>\n"
                    + ">VIP用户反馈:<font color=\"comment\">15例</font>")
                .atAll()
                .build()
        );
        log.info(result.toString());
    }

    @Test
    void imageMessageTest() {
        String webhook = System.getenv("webhook");
        send.setWebhook(webhook);
        RobotResult result = send.sendMessage(
            ImageMessage.ImageMessageBuilder.builder()
                .md5("")
                .base64("")
                .build()
        );
        log.info(result.toString());
    }

    @Test
    void newsMessageTest() {
        String webhook = System.getenv("webhook");
        send.setWebhook(webhook);
        RobotResult result = send.sendMessage(
            NewsMessage.NewsMessageBuilder.builder()
                .addArticle(
                    Article
                        .builder()
                        .title("中秋节礼品领取")
                        .description("今年中秋节公司有豪礼相送")
                        .url("www.qq.com")
                        .picurl("http://res.mail.qq.com/node/ww/wwopenmng/images/independent/doc/test_pic_msg1.png")
                        .build()
                ).build()
        );
        log.info(result.toString());
    }

    @Test
    void textNoticeCardMessageTest() {
        String webhook = System.getenv("webhook");
        send.setWebhook(webhook);
        RobotResult result = send.sendMessage(
            TemplateCardMessage.TemplateCardMessageBuilder.builder()
                .templateCard(
                    TextNoticeCard.TextNoticeCardBuilder.builder()
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
                        .emphasisContent(
                            EmphasisContent.builder()
                                .title("100")
                                .desc("数据含义")
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
                        .subTitleText("下载企业微信还能抢红包！")
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
                                .build()
//                            ,
//                            HorizontalContent.builder()
//                                .keyname("企微下载")
//                                .value("企业微信.apk")
//                                .type(HorizontalContentType.DOWNLOAD)
//                                .mediaId("MEDIAID")
//                                .build()
                        )
                        .addJump(
                            Jump.builder()
                                .type(JumpType.URL)
                                .url("https://work.weixin.qq.com/?from=openApi")
                                .title("企业微信官网")
                                .build()
//                            ,
//                            Jump.builder()
//                                .type(JumpType.MINI_APP)
//                                .appid("APPID")
//                                .pagePath("PAGEPATH")
//                                .title("跳转小程序")
//                                .build()
                        )
                        .action(CardAction.builder()
                            .type(CardActionType.URL)
                            .url("https://work.weixin.qq.com/?from=openApi")
                            .appid("APPID")
                            .pagePath("PAGEPATH")
                            .build())

                        .build()
                )
                .build()
        );
        log.info(result.toString());
    }

    @Test
    void NewsNoticeCardMessageTest() {
        String webhook = System.getenv("webhook");
        send.setWebhook(webhook);
        RobotResult result = send.sendMessage(
            TemplateCardMessage.TemplateCardMessageBuilder.builder()
                .templateCard(
                    NewsNoticeCard.NewsNoticeCardBuilder.builder()
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
                                .build()
//                            ,
//                            HorizontalContent.builder()
//                                .keyname("企微下载")
//                                .value("企业微信.apk")
//                                .type(HorizontalContentType.DOWNLOAD)
//                                .mediaId("MEDIAID")
//                                .build()
                        )
                        .addJump(
                            Jump.builder()
                                .type(JumpType.URL)
                                .url("https://work.weixin.qq.com/?from=openApi")
                                .title("企业微信官网")
                                .build()
//                            ,
//                            Jump.builder()
//                                .type(JumpType.MINI_APP)
//                                .appid("APPID")
//                                .pagePath("PAGEPATH")
//                                .title("跳转小程序")
//                                .build()
                        )
                        .action(
                            CardAction.builder()
                                .type(CardActionType.URL)
                                .url("https://work.weixin.qq.com/?from=openApi")
                                .appid("APPID")
                                .pagePath("PAGEPATH")
                                .build()
                        )
                        .build()
                )
                .build()
        );
        log.info(result.toString());
    }
}
