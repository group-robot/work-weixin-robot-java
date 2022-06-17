package io.github.group.robot.weixin.model;

import io.github.group.robot.weixin.commons.MsgType;

/**
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
public abstract class AbstractMessage implements Message {
    protected static  final String AT_ALL="@all";
    /**
     * 类型
     */
    protected MsgType type;

    public AbstractMessage() {
    }

    public AbstractMessage(MsgType type) {
        this.type = type;
    }
}
