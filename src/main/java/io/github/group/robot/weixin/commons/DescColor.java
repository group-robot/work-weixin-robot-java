package io.github.group.robot.weixin.commons;

/**
 * 来源文字的颜色，
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
public enum DescColor {
    /**
     * 灰色
     */
    GREY(0),
    /**
     * 黑色
     */
    BLACK(1),
    /**
     * 红
     */
    RED(2),
    /**
     * 绿
     */
    GREEN(3),
    ;
    private final int value;

    DescColor(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
