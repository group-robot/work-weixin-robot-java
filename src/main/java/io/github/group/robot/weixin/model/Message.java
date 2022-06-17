package io.github.group.robot.weixin.model;

import java.util.Map;

/**
 * 消息
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
public interface Message {
    /**
     * 将message转换成Map，用于Json序列化
     *
     * @return message Map
     */
    Map<String, Object> toMessageMap();
}
