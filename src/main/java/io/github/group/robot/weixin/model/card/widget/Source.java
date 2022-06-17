package io.github.group.robot.weixin.model.card.widget;

import io.github.group.robot.weixin.commons.DescColor;
import io.github.group.robot.weixin.model.Message;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡片来源样式信息
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Source implements Message {
    /**
     * 来源图片的url
     */
    private String iconUrl;
    /**
     * 来源图片的描述，建议不超过13个字
     */
    private String desc;
    /**
     * 来源文字的颜色，目前支持：0(默认) 灰色，1 黑色，2 红色，3 绿色
     */
    private DescColor descColor;

    @Override
    public Map<String, Object> toMessageMap() {
        Map<String, Object> message = new HashMap<>(3);
        message.put("icon_url", this.iconUrl);
        message.put("desc", this.desc);
        message.put("desc_color", this.descColor == null ? 0 : this.descColor.getValue());
        return message;
    }
}
