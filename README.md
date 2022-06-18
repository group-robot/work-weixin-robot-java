<h1 align="center"><a href="https://github.com/group-robot/java-work-weixin-robot" target="_blank">java-work-weixin-robot</a></h1>
<p align="center">
<a href="https://search.maven.org/artifact/io.github.group-robot/java-work-weixin-robot">
<img alt="Maven Central" src="https://img.shields.io/maven-central/v/io.github.group-robot/java-work-weixin-robot?style=flat-square">
</a>
<a href="https://github.com/group-robot/java-work-weixin-robot/blob/master/LICENSE">
<img alt="GitHub" src="https://img.shields.io/github/license/group-robot/java-work-weixin-robot?style=flat-square">
</a>
<a href="https://github.com/group-robot/java-work-weixin-robot/actions">
<img alt="GitHub Workflow Status" src="https://img.shields.io/github/workflow/status/group-robot/java-work-weixin-robot/Tag%20Release?style=flat-square">
</a>
<a href="https://www.oracle.com/java/technologies/javase-downloads.html">
<img alt="jdk" src="https://img.shields.io/badge/jdk-8%2B-green?style=flat-square">
</a>
</p>

# java-work-weixin-robot
企业微信群机器人java版[docs](https://developer.work.weixin.qq.com/document/path/91770)

# maven
```xml
<dependency>
    <groupId>io.github.group-robot</groupId>
    <artifactId>wrok-weixin-robot-core</artifactId>
    <version>${version}</version>
</dependency>
```

# example
## Text
```java
TextMessage message = TextMessage.TextMessageBuilder.builder()
    .setContent("广州今日天气：29度，大部分多云，降雨概率：60%")
    .setMentioned("wangqing")
    .mentionedAtAll()
    .setMobile("13800001111")
    .mobileAtAll()
    .build();
```
## Markdown
```java
MarkdownMessage message = MarkdownMessage.MarkdownMessageBuilder.builder()
            .content("实时新增用户反馈<font color=\"warning\">132例</font>，请相关同事注意。\n"
                + ">类型:<font color=\"comment\">用户反馈</font>"
                + ">普通用户反馈:<font color=\"comment\">117例</font>"
                + ">VIP用户反馈:<font color=\"comment\">15例</font>")
            .build();
```
## Image
```java
ImageMessage message = ImageMessage.ImageMessageBuilder.builder()
            .base64("data")
            .md5("md5")
            .build();
```
## News
```java
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
```
## card
```java
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
```

```java
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
```

# TODO
* file message