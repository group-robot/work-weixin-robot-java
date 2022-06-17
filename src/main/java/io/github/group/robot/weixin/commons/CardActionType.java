package io.github.group.robot.weixin.commons;

/**
 * 卡片跳转类型
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
public enum CardActionType {
    /**
     * 跳转url
     */
    URL(1),
    /**
     * 打开小程序
     */
    MINI_APP(2),
    ;
    private final int value;

    CardActionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
