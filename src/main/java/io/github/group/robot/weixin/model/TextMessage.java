package io.github.group.robot.weixin.model;

import cn.hutool.core.builder.Builder;
import cn.hutool.core.util.StrUtil;
import io.github.group.robot.weixin.commons.MsgType;
import io.github.group.robot.weixin.exception.WeixiuRobotException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文本类型
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
public class TextMessage extends AbstractMessage {
    /**
     * 文本内容，最长不超过2048个字节，必须是utf8编码
     */
    @Getter
    @Setter
    private String content;
    /**
     * userid的列表，提醒群中的指定成员(@某个成员)，@all表示提醒所有人，如果开发者获取不到userid，可以使用mentioned_mobile_list
     */
    @Getter
    private List<String> mentionedList;
    /**
     * 手机号列表，提醒手机号对应的群成员(@某个成员)，@all表示提醒所有人
     */
    @Getter
    private List<String> mentionedMobileList;

    public TextMessage() {
        this.type = MsgType.TEXT;
    }

    @Override
    public Map<String, Object> toMessageMap() {
        if (StrUtil.isBlank(this.content)) {
            throw new WeixiuRobotException("文本内容为空");
        }
        Map<String, Object> textMessage = new HashMap<>(3);
        textMessage.put("content", this.content);
        textMessage.put("mentioned_list", this.mentionedList);
        textMessage.put("mentioned_mobile_list", this.mentionedMobileList);

        Map<String, Object> message = new HashMap<>(2);
        message.put("msgtype", this.type.getValue());
        message.put("text", textMessage);
        return message;
    }

    /**
     * set mentioned
     *
     * @param userIds user id
     */
    public void setMentioned(List<String> userIds) {
        this.mentionedList = userIds;
    }

    /**
     * set mentioned
     *
     * @param userid user id
     */
    public void setMentioned(String... userid) {
        this.mentionedList = new ArrayList<>();
        this.mentionedList.addAll(Arrays.asList(userid));
    }

    /**
     * 设置 userid
     *
     * @param userid userid
     */
    public void setMentioned(String userid) {
        this.mentionedList = new ArrayList<>();
        this.mentionedList.add(userid);
    }

    /**
     * 新增 userid的列表
     *
     * @param userid userid
     */
    public void addMentioned(String userid) {
        if (null == mentionedList) {
            this.mentionedList = new ArrayList<>();
        }
        this.mentionedList.add(userid);
    }

    /**
     * add mentioned
     *
     * @param userid user id
     */
    public void addMentioned(String... userid) {
        if (null == mentionedList) {
            this.mentionedList = new ArrayList<>();
        }
        this.mentionedList.addAll(Arrays.asList(userid));
    }

    /**
     * add mentioned
     *
     * @param userIdList user id
     */
    public void addMentioned(List<String> userIdList) {
        if (null == mentionedList) {
            this.mentionedList = new ArrayList<>();
        }
        this.mentionedList.addAll(userIdList);
    }


    /**
     * mentioned_list 字段 提醒所有人
     */
    public void mentionedAtAll() {
        if (null == mentionedList) {
            this.mentionedList = new ArrayList<>();
        }
        this.mentionedList.add(AT_ALL);
    }

    /**
     * set mobile
     *
     * @param mobiles mobile list
     */
    public void setMobile(List<String> mobiles) {
        this.mentionedMobileList = mobiles;
    }

    /**
     * set mobile
     *
     * @param mobile mobile
     */
    public void setMobile(String mobile) {
        this.mentionedMobileList = new ArrayList<>();
        this.mentionedMobileList.add(mobile);
    }

    /**
     * add mobile
     *
     * @param mobile mobile
     */
    public void addMobile(String mobile) {
        if (null == this.mentionedMobileList) {
            this.mentionedMobileList = new ArrayList<>();
        }
        this.mentionedMobileList.add(mobile);
    }

    /**
     * add mobile
     *
     * @param mobiles mobile
     */
    public void addMobile(String... mobiles) {
        if (null == this.mentionedMobileList) {
            this.mentionedMobileList = new ArrayList<>();
        }
        this.mentionedMobileList.addAll(Arrays.asList(mobiles));
    }

    /**
     * add mobile
     *
     * @param mobiles mobile
     */
    public void addMobile(List<String> mobiles) {
        if (null == this.mentionedMobileList) {
            this.mentionedMobileList = new ArrayList<>();
        }
        this.mentionedMobileList.addAll(mobiles);
    }

    /**
     * mentioned_mobile_list 字段 提醒所有人
     */
    public void mobileAtAll() {
        if (null == mentionedMobileList) {
            this.mentionedMobileList = new ArrayList<>();
        }
        this.mentionedMobileList.add(AT_ALL);
    }

    /**
     * {@link  TextMessage} builder
     */
    public static class TextMessageBuilder implements Builder<TextMessage> {
        private final TextMessage message;

        /**
         * builder
         *
         * @return builder
         */
        public static TextMessageBuilder builder() {
            return new TextMessageBuilder();
        }

        public TextMessageBuilder() {
            message = new TextMessage();
        }

        /**
         * set content
         *
         * @param content content
         * @return message build
         */
        public TextMessageBuilder setContent(String content) {
            message.setContent(content);
            return this;
        }

        /**
         * set mentioned
         *
         * @param userid user id
         * @return message builder
         */
        public TextMessageBuilder setMentioned(List<String> userid) {
            message.setMentioned(userid);
            return this;
        }

        /**
         * set mentioned
         *
         * @param userid user id
         * @return message builder
         */
        public TextMessageBuilder setMentioned(String... userid) {
            message.setMentioned(userid);
            return this;
        }

        /**
         * set userid
         *
         * @param userid userid
         * @return message builder
         */
        public TextMessageBuilder setMentioned(String userid) {
            message.setMentioned(userid);
            return this;
        }

        /**
         * add user id
         *
         * @param userid userid
         * @return message builder
         */
        public TextMessageBuilder addMentioned(String userid) {
            message.addMentioned(userid);
            return this;
        }

        /**
         * add mentioned
         *
         * @param userid user id
         * @return message builder
         */
        public TextMessageBuilder addMentioned(String... userid) {
            message.addMentioned(userid);
            return this;
        }

        /**
         * add mentioned
         *
         * @param userIdList user id
         * @return message builder
         */
        public TextMessageBuilder addMentioned(List<String> userIdList) {
            message.addMentioned(userIdList);
            return this;
        }


        /**
         * mentioned_list 字段 提醒所有人
         *
         * @return message builder
         */
        public TextMessageBuilder mentionedAtAll() {
            message.mentionedAtAll();
            return this;
        }

        /**
         * set mobile
         *
         * @param mobiles mobile list
         * @return message builder
         */
        public TextMessageBuilder setMobile(List<String> mobiles) {
            message.setMobile(mobiles);
            return this;
        }

        /**
         * set mobile
         *
         * @param mobile mobile
         * @return message builder
         */
        public TextMessageBuilder setMobile(String mobile) {
            message.setMobile(mobile);
            return this;
        }

        /**
         * add mobile
         *
         * @param mobile mobile
         * @return message builder
         */
        public TextMessageBuilder addMobile(String mobile) {
            message.addMobile(mobile);
            return this;
        }

        /**
         * add mobile
         *
         * @param mobiles mobile
         * @return message builder
         */
        public TextMessageBuilder addMobile(String... mobiles) {
            message.addMobile(mobiles);
            return this;
        }

        /**
         * add mobile
         *
         * @param mobiles mobile
         * @return message builder
         */
        public TextMessageBuilder addMobile(List<String> mobiles) {
            message.addMobile(mobiles);
            return this;
        }

        /**
         * mentioned_mobile_list 字段 提醒所有人
         *
         * @return message builder
         */
        public TextMessageBuilder mobileAtAll() {
            message.mobileAtAll();
            ;
            return this;
        }

        @Override
        public TextMessage build() {
            return message;
        }
    }

}
