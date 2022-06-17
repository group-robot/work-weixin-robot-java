package io.github.group.robot.weixin.model.card.widget;

import cn.hutool.core.util.StrUtil;
import io.github.group.robot.weixin.commons.QuoteType;
import io.github.group.robot.weixin.exception.WeixiuRobotException;
import io.github.group.robot.weixin.model.Message;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 引用文献样式
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode
@Builder
public class QuoteArea implements Message {
    /**
     * 引用文献样式区域点击事件，0或不填代表没有点击事件，1 代表跳转url，2 代表跳转小程序
     */
    private QuoteType type;
    /**
     * 点击跳转的url，quote_area.type是1时必填
     */
    private String url;
    /**
     * 点击跳转的小程序的appid，quote_area.type是2时必填
     */
    private String appid;
    /**
     * 点击跳转的小程序的pagepath，quote_area.type是2时选填
     */
    private String pagePath;
    /**
     * 引用文献样式的标题
     */
    private String title;
    /**
     * 引用文献样式的引用文案
     */
    private String quoteText;

    @Override
    public Map<String, Object> toMessageMap() {
        if (QuoteType.URL.equals(this.getType()) && StrUtil.isBlank(this.url)) {
            throw new WeixiuRobotException("url missing");
        }
        if (QuoteType.MINI_APP.equals(this.getType())) {
            if (StrUtil.isBlank(this.appid) || StrUtil.isBlank(this.pagePath)) {
                throw new WeixiuRobotException("appid or page path missing");
            }
        }
        Map<String, Object> message = new HashMap<>(6);
        message.put("type", this.type == null ? QuoteType.NONE.getValue() : this.type.getValue());
        message.put("url", this.url);
        message.put("appid", this.appid);
        message.put("pagepath", this.pagePath);
        message.put("title", this.title);
        message.put("quote_text", this.quoteText);
        return message;
    }
}
