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
 * markdown message
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MarkdownMessage extends AbstractMessage {
    public MarkdownMessage() {
        this.type = MsgType.MARKDOWN;
    }

    /**
     * at all,好像不起作用
     */
    @Deprecated
    private boolean atAll;
    /**
     * markdown内容，最长不超过4096个字节，必须是utf8编码
     */
    private String content;

    @Override
    public Map<String, Object> toMessageMap() {
        if (StrUtil.isBlank(this.content)) {
            throw new WeixiuRobotException("content missing");
        }
        Map<String, Object> markdownMessage = new HashMap<>(1);
        String content = this.content;
        if (isAtAll()) {
            content = content + "\n<" + AT_ALL + ">";
        }
        markdownMessage.put("content", content);
        Map<String, Object> message = new HashMap<>(2);
        message.put("markdown", markdownMessage);
        message.put("msgtype", type.getValue());
        return message;
    }

    /**
     * {@link  MarkdownMessage} builder
     */
    public static class MarkdownMessageBuilder implements Builder<MarkdownMessage> {
        private final MarkdownMessage message;

        /**
         * builder
         *
         * @return {@link  MarkdownMessageBuilder}
         */
        public static MarkdownMessageBuilder builder() {
            return new MarkdownMessageBuilder();
        }

        public MarkdownMessageBuilder() {
            this.message = new MarkdownMessage();
        }

        /**
         * set at_all
         *
         * @return builder
         */
        public MarkdownMessageBuilder setAtAll(boolean atAll) {
            message.setAtAll(atAll);
            return this;
        }

        /**
         * set at_all is true
         *
         * @return builder
         */
        public MarkdownMessageBuilder atAll() {
            message.setAtAll(true);
            return this;
        }

        /**
         * set markdown message content
         *
         * @param content content
         * @return this
         */
        public MarkdownMessageBuilder content(String content) {
            message.setContent(content);
            return this;
        }

        @Override
        public MarkdownMessage build() {
            return message;
        }
    }
}
