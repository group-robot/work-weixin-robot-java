package io.github.group.robot.weixin.model.card.widget;

import cn.hutool.core.util.StrUtil;
import io.github.group.robot.weixin.commons.CardActionType;
import io.github.group.robot.weixin.exception.WeixiuRobotException;
import io.github.group.robot.weixin.model.Message;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 整体卡片的点击跳转事件
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
@Data
@Builder
@EqualsAndHashCode
public class CardAction implements Message {
    /**
     * 卡片跳转类型，1 代表跳转url，2 代表打开小程序。news_notice模版卡片中该字段取值范围为[1,2]
     */
    private CardActionType type;
    /**
     * 跳转事件的url，card_action.type是1时必填
     */
    private String url;
    /**
     * 跳转事件的小程序的appid，card_action.type是2时必填
     */
    private String appid;
    /**
     * 跳转事件的小程序的pagepath，card_action.type是2时选填
     */
    private String pagePath;

    @Override
    public Map<String, Object> toMessageMap() {
        if (null == this.type) {
            throw new WeixiuRobotException("type missing");
        }
        if (CardActionType.URL.equals(this.type) && StrUtil.isBlank(url)) {
            throw new WeixiuRobotException("url missing");
        }
        if (CardActionType.MINI_APP.equals(this.type)) {
            if (StrUtil.isBlank(this.appid) || StrUtil.isBlank(this.pagePath)) {
                throw new WeixiuRobotException("appid,page path missing");
            }
        }
        Map<String, Object> message = new HashMap<>(4);
        message.put("type", this.getType().getValue());
        message.put("url", this.getUrl());
        message.put("appid", this.appid);
        message.put("pagepath", this.pagePath);
        return message;
    }
}
