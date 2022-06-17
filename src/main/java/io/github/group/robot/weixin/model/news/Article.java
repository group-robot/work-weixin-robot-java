package io.github.group.robot.weixin.model.news;

import cn.hutool.core.util.StrUtil;
import io.github.group.robot.weixin.exception.WeixiuRobotException;
import io.github.group.robot.weixin.model.Message;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 图文消息，
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Article implements Message {
    /**
     * 标题，不超过128个字节，超过会自动截断,<strong>必填</strong>
     */
    private String title;
    /**
     * 描述，不超过512个字节，超过会自动截断
     */
    private String description;
    /**
     * 点击后跳转的链接。<strong>必填</strong>
     */
    private String url;
    /**
     * 图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图 1068*455，小图150*150。
     */
    private String picurl;

    @Override
    public Map<String, Object> toMessageMap() {
        if (StrUtil.isBlank(this.title) || StrUtil.isBlank(this.url)) {
            throw new WeixiuRobotException("news article missing");
        }
        Map<String, Object> message = new HashMap<>(4);
        message.put("title", this.title);
        message.put("description", this.description);
        message.put("url", this.url);
        message.put("picurl", this.picurl);
        return message;
    }
}
