package io.github.group.robot.weixin.commons;

/**
 * 链接类型
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
public enum HorizontalContentType {
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
    /**
     * AT员工
     */
    USERID(3),
    ;

    private final int value;

    HorizontalContentType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
