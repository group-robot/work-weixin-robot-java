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
 * 图片样式
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode
@Builder
public class CardImage implements Message {
    /**
     * 图片的url
     */
    private String url;
    /**
     * 图片的宽高比，宽高比要小于2.25，大于1.3，不填该参数默认1.3
     */
    private String aspectRatio;

    @Override
    public Map<String, Object> toMessageMap() {
        if (StrUtil.isBlank(this.url)) {
            throw new WeixiuRobotException("url missing");
        }
        Map<String,Object> message=new HashMap<>(2);
        message.put("url",this.url);
        message.put("aspect_ratio",this.aspectRatio);
        return message;
    }
}
