package io.github.group.robot.weixin.model.card.widget;

import cn.hutool.core.util.StrUtil;
import io.github.group.robot.weixin.commons.HorizontalContentType;
import io.github.group.robot.weixin.exception.WeixiuRobotException;
import io.github.group.robot.weixin.model.Message;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 二级标题+文本列表，该字段可为空数组，但有数据的话需确认对应字段是否必填，列表长度不超过6
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode
@Builder
public class HorizontalContent implements Message {
    /**
     * 模版卡片的二级标题信息内容支持的类型，1是url，2是文件附件
     */
    private HorizontalContentType type;
    /**
     * 二级标题，建议不超过5个字
     */
    private String keyname;
    /**
     * 二级文本，如果horizontal_content_list.type是2，该字段代表文件名称（要包含文件类型），建议不超过26个字
     */
    private String value;
    /**
     * 链接跳转的url，horizontal_content_list.type是1时必填
     */
    private String url;
    /**
     * 附件的media_id，horizontal_content_list.type是2时必填
     */
    private String mediaId;
    /**
     * 被@的成员的userid，horizontal_content_list.type是3时必填
     */
    private String userid;

    @Override
    public Map<String, Object> toMessageMap() {
        if (StrUtil.isBlank(this.keyname)) {
            throw new WeixiuRobotException("keyname missing");
        }
        if (HorizontalContentType.URL.equals(this.getType()) && StrUtil.isBlank(this.url)) {
            throw new WeixiuRobotException("url missing");
        }
        if (HorizontalContentType.DOWNLOAD.equals(this.type) && StrUtil.isBlank(this.value)) {
            throw new WeixiuRobotException("value missing");
        }
        if (HorizontalContentType.DOWNLOAD.equals(this.type) && StrUtil.isBlank(this.mediaId)) {
            throw new WeixiuRobotException("media id missing");
        }
        if (HorizontalContentType.USERID.equals(this.type) && StrUtil.isBlank(this.userid)) {
            throw new WeixiuRobotException("userid missing");
        }
        Map<String, Object> message = new HashMap<>(6);
        message.put("type", this.type == null ? HorizontalContentType.NONE.getValue() : this.type.getValue());
        message.put("keyname", this.keyname);
        message.put("value", this.value);
        message.put("url", this.url);
        message.put("media_id", this.mediaId);
        message.put("userid", this.userid);
        return message;
    }
}
