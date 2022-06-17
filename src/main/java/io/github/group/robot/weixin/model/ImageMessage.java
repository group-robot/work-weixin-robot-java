package io.github.group.robot.weixin.model;

import cn.hutool.core.builder.Builder;
import cn.hutool.core.util.StrUtil;
import io.github.group.robot.weixin.commons.MsgType;
import io.github.group.robot.weixin.exception.WeixiuRobotException;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 图片类型
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ImageMessage extends AbstractMessage {
    /**
     * 图片内容的base64编码
     */
    private String base64;
    /**
     * 图片内容（base64编码前）的md5值
     */
    private String md5;

    public ImageMessage() {
        this.type = MsgType.IMAGE;
    }

    @Override
    public Map<String, Object> toMessageMap() {
        if (StrUtil.isBlank(this.base64) || StrUtil.isBlank(this.md5)) {
            throw new WeixiuRobotException("image message missing");
        }
        Map<String, String> imageMessage = new HashMap<>(2);
        imageMessage.put("base64", this.base64);
        imageMessage.put("md5", this.md5);
        Map<String, Object> message = new HashMap<>(2);
        message.put("msgtype", this.type.getValue());
        message.put("image", imageMessage);
        return message;
    }

    /**
     * {@link  ImageMessage} builder
     */
    public static class ImageMessageBuilder implements Builder<ImageMessage> {
        private final ImageMessage message;


        /**
         * builder
         *
         * @return {@link  ImageMessageBuilder}
         */
        public static ImageMessageBuilder builder() {
            return new ImageMessageBuilder();
        }

        public ImageMessageBuilder() {
            message = new ImageMessage();
        }

        /**
         * 图片内容的base64编码
         *
         * @param base64 base64
         * @return this
         */
        public ImageMessageBuilder base64(String base64) {
            this.message.setBase64(base64);
            return this;
        }

        /**
         * 图片内容（base64编码前）的md5值
         *
         * @param md5 md5
         * @return this
         */
        public ImageMessageBuilder md5(String md5) {
            this.message.setMd5(md5);
            return this;
        }

        @Override
        public ImageMessage build() {
            return this.message;
        }
    }
}
