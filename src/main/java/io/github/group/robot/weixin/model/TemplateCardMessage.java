package io.github.group.robot.weixin.model;

import io.github.group.robot.weixin.commons.MsgType;
import io.github.group.robot.weixin.exception.WeixiuRobotException;
import io.github.group.robot.weixin.model.card.TemplateCard;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 模版卡片类型
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TemplateCardMessage extends AbstractMessage {
    /**
     * 卡片类型
     */
    private TemplateCard templateCard;


    public TemplateCardMessage() {
        this.type = MsgType.TEMPLATE_CARD;
    }

    @Override
    public Map<String, Object> toMessageMap() {
        if (null == this.templateCard) {
            throw new WeixiuRobotException("template_card missing");
        }
        Map<String, Object> message = new HashMap<>(2);
        message.put("msgtype", this.type.getValue());
        message.put("template_card", this.templateCard.toMessageMap());
        return message;
    }
}
