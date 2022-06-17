package io.github.group.robot.weixin.commons;

/**
 * 左图右文样式区域点击事件
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/17
 * @since 1.0.0
 */
public enum ImageTextAreaType {
    /**
     * 普通文本
     */
    NONE(0),
    /**
     * 跳转url
     */
    URL(1),
    /**
     * 下载附件
     */
    DOWNLOAD(2),
    ;
    private final int value;

    ImageTextAreaType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
