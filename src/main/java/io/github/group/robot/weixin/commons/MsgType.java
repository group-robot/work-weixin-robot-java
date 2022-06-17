package io.github.group.robot.weixin.commons;

/**
 * 消息类型
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
public enum MsgType {
    /**
     * 文本
     */
    TEXT("text"),
    /**
     * markdown
     */
    MARKDOWN("markdown"),
    /**
     * 图片类型
     */
    IMAGE("image"),
    /**
     * 图文类型
     */
    NEWS("news"),
    /**
     * 文件类型
     */
    FILE("file"),
    /**
     * 模版卡片类型
     */
    TEMPLATE_CARD("template_card"),

    ;
    private final String value;

    MsgType(String value) {
        this.value = value;
    }

    /**
     * 类型
     *
     * @return 类型
     */
    public String getValue() {
        return value;
    }
}
