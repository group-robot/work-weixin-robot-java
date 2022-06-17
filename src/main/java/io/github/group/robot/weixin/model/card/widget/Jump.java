package io.github.group.robot.weixin.model.card.widget;

import cn.hutool.core.util.StrUtil;
import io.github.group.robot.weixin.commons.JumpType;
import io.github.group.robot.weixin.exception.WeixiuRobotException;
import io.github.group.robot.weixin.model.Message;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 跳转指引样式的列表
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode
@Builder
public class Jump implements Message {
    /**
     * 跳转链接类型，0或不填代表不是链接，1 代表跳转url，2 代表跳转小程序
     */
    private JumpType type;
    /**
     * 跳转链接样式的文案内容，建议不超过13个字
     */
    private String title;
    /**
     * 跳转链接的url，jump_list.type是1时必填
     */
    private String url;
    /**
     * 跳转链接的小程序的appid，jump_list.type是2时必填
     */
    private String appid;
    /**
     * 跳转链接的小程序的pagepath，jump_list.type是2时选填
     */
    private String pagePath;

    @Override
    public Map<String, Object> toMessageMap() {
        if (StrUtil.isBlank(this.title)) {
            throw new WeixiuRobotException("title missing");
        }
        if (JumpType.URL.equals(this.type) && StrUtil.isBlank(this.url)) {
            throw new WeixiuRobotException("url missing");
        }
        if (JumpType.MINI_APP.equals(this.getType())) {
            if (StrUtil.isBlank(this.appid) || StrUtil.isBlank(this.pagePath)) {
                throw new WeixiuRobotException("appid, page path missing");
            }
        }
        Map<String, Object> message = new HashMap<>(5);
        message.put("type", this.type == null ? JumpType.NONE.getValue() : this.type.getValue());
        message.put("title", this.title);
        message.put("url", this.url);
        message.put("appid", this.appid);
        message.put("pagepath", this.pagePath);
        return message;
    }
}
