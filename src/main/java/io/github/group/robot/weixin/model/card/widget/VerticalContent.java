package io.github.group.robot.weixin.model.card.widget;

import cn.hutool.core.util.StrUtil;
import io.github.group.robot.weixin.exception.WeixiuRobotException;
import io.github.group.robot.weixin.model.Message;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡片二级垂直内容，该字段可为空数组，但有数据的话需确认对应字段是否必填，列表长度不超过4
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode
@Builder
public class VerticalContent implements Message {
    /**
     * 卡片二级标题，建议不超过26个字
     */
    private String title;
    /**
     * 二级普通文本，建议不超过112个字
     */
    private String desc;

    @Override
    public Map<String, Object> toMessageMap() {
        if (StrUtil.isBlank(this.title)) {
            throw new WeixiuRobotException("title missing");
        }
        Map<String, Object> message = new HashMap<>(2);
        message.put("title", this.title);
        message.put("desc", this.desc);
        return message;
    }
}
