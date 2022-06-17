package io.github.group.robot.weixin.model.card.widget;

import io.github.group.robot.weixin.model.Message;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 模版卡片的主要内容
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class MainTitle implements Message {
    /**
     * 一级标题，建议不超过26个字
     */
    private String title;
    /**
     * 标题辅助信息，建议不超过30个字
     */
    private String desc;

    @Override
    public Map<String, Object> toMessageMap() {
        Map<String, Object> message = new HashMap<>(2);
        message.put("title", this.title);
        message.put("desc", this.desc);
        return message;
    }
}
