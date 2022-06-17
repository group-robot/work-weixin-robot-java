package io.github.group.robot.weixin.model.card.widget;

import cn.hutool.core.util.StrUtil;
import io.github.group.robot.weixin.commons.ImageTextAreaType;
import io.github.group.robot.weixin.exception.WeixiuRobotException;
import io.github.group.robot.weixin.model.Message;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * 左图右文样式
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode
@ToString
@Builder
public class ImageTextArea implements Message {
    /**
     * 左图右文样式区域点击事件，0或不填代表没有点击事件，1 代表跳转url，2 代表跳转小程序
     */
    private ImageTextAreaType type;
    /**
     * 点击跳转的url，image_text_area.type是1时必填
     */
    private String url;
    /**
     * 点击跳转的小程序的appid，必须是与当前应用关联的小程序，image_text_area.type是2时必填
     */
    private String appid;
    /**
     * 点击跳转的小程序的pagepath，image_text_area.type是2时选填
     */
    private String pagePath;
    /**
     * 左图右文样式的标题
     */
    private String title;
    /**
     * 左图右文样式的描述
     */
    private String desc;
    /**
     * 左图右文样式的图片url
     */
    private String imageUrl;

    @Override
    public Map<String, Object> toMessageMap() {
        if (StrUtil.isBlank(this.imageUrl)) {
            throw new WeixiuRobotException("image_url missing");
        }
        if (ImageTextAreaType.URL.equals(this.type) && StrUtil.isBlank(this.url)) {
            throw new WeixiuRobotException("url missing");
        }
        if (ImageTextAreaType.DOWNLOAD.equals(this.type)) {
            if (StrUtil.isBlank(this.appid) || StrUtil.isBlank(this.pagePath)) {
                throw new WeixiuRobotException("appid,page_path missing");
            }
        }
        Map<String, Object> message = new HashMap<>(7);
        message.put("type", this.type == null ? ImageTextAreaType.NONE.getValue() : this.type.getValue());
        message.put("url", this.url);
        message.put("appid", this.appid);
        message.put("pagepath", this.pagePath);
        message.put("title", this.title);
        message.put("desc", this.desc);
        message.put("image_url", this.imageUrl);
        return message;
    }
}
