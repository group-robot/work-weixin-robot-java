package io.github.group.robot.weixin.commons;

/**
 * 模版卡片的模版类型
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
public enum CardType {
    /**
     * 文本通知模版卡片
     */
    TEXT_NOTICE("text_notice"),
    /**
     * 图文展示模版卡片
     */
    NEWS_NOTICE("news_notice"),
    ;

    private final String value;

    CardType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
