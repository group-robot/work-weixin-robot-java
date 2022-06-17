package io.github.group.robot.weixin.model.card.widget;

import io.github.group.robot.weixin.model.Message;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 关键数据样式
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode
@Builder
public class EmphasisContent implements Message {
    /**
     * 关键数据样式的数据内容，建议不超过10个字
     */
    private String title;
    /**
     * 关键数据样式的数据描述内容，建议不超过15个字
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
