package io.github.group.robot.weixin.model.card;

import cn.hutool.core.builder.Builder;
import cn.hutool.core.collection.CollectionUtil;
import io.github.group.robot.weixin.commons.CardType;
import io.github.group.robot.weixin.exception.WeixiuRobotException;
import io.github.group.robot.weixin.model.card.widget.CardAction;
import io.github.group.robot.weixin.model.card.widget.EmphasisContent;
import io.github.group.robot.weixin.model.card.widget.HorizontalContent;
import io.github.group.robot.weixin.model.card.widget.Jump;
import io.github.group.robot.weixin.model.card.widget.MainTitle;
import io.github.group.robot.weixin.model.card.widget.QuoteArea;
import io.github.group.robot.weixin.model.card.widget.Source;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文本通知模版卡片
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TextNoticeCard extends TemplateCard {
    /**
     * 卡片来源样式信息，不需要来源样式可不填写
     */
    private Source source;
    /**
     * 模版卡片的主要内容，包括一级标题和标题辅助信息
     */
    private MainTitle mainTitle;
    /**
     * 关键数据样式
     */
    private EmphasisContent emphasisContent;
    /**
     * 引用文献样式，建议不与关键数据共用
     */
    private QuoteArea quoteArea;
    /**
     * 二级普通文本，建议不超过112个字。模版卡片主要内容的一级标题main_title.title和二级普通文本sub_title_text必须有一项填写
     */
    private String subTitleText;
    /**
     * 二级标题+文本列表，该字段可为空数组，但有数据的话需确认对应字段是否必填，列表长度不超过6
     */
    private List<HorizontalContent> horizontalContentList;
    /**
     * 跳转指引样式的列表，该字段可为空数组，但有数据的话需确认对应字段是否必填，列表长度不超过3
     */
    private List<Jump> jumpList;
    /**
     * 整体卡片的点击跳转事件
     */
    private CardAction action;

    public TextNoticeCard() {
        this.cardType = CardType.TEXT_NOTICE;
    }


    @Override
    public Map<String, Object> toMessageMap() {
        if (null == this.mainTitle || null == this.action) {
            throw new WeixiuRobotException("main_title,card_action missing");
        }
        Map<String, Object> message = new HashMap<>(4);
        message.put("card_type", this.cardType.getValue());
        if (null != this.source) {
            message.put("source", this.source.toMessageMap());
        }
        message.put("main_title", this.mainTitle.toMessageMap());
        if (null != this.quoteArea) {
            message.put("quote_area", this.quoteArea.toMessageMap());
        }
        message.put("sub_title_text", this.subTitleText);
        if (CollectionUtil.isNotEmpty(this.horizontalContentList)) {
            List<Map<String, Object>> horizontalContentListMap = new ArrayList<>(this.horizontalContentList.size());
            for (HorizontalContent content : this.horizontalContentList) {
                horizontalContentListMap.add(content.toMessageMap());
            }
            message.put("horizontal_content_list", horizontalContentListMap);
        }
        if (CollectionUtil.isNotEmpty(this.jumpList)) {
            List<Map<String, Object>> jumListMap = new ArrayList<>(this.jumpList.size());
            for (Jump jump : this.jumpList) {
                jumListMap.add(jump.toMessageMap());
            }
            message.put("jump_list", jumListMap);
        }
        message.put("card_action", this.action.toMessageMap());
        return message;
    }

    /**
     * {@link  TemplateCard} builder
     */
    public static class TextNoticeCardBuilder implements Builder<TextNoticeCard> {
        private final TextNoticeCard card;

        /**
         * builder
         *
         * @return {@link  TextNoticeCardBuilder}
         */
        public static TextNoticeCardBuilder builder() {
            return new TextNoticeCardBuilder();
        }

        public TextNoticeCardBuilder() {
            this.card = new TextNoticeCard();
        }

        /**
         * set {@link  #setSource(Source)}
         *
         * @param source 卡片来源样式信息
         * @return this
         */
        public TextNoticeCardBuilder source(Source source) {
            this.card.setSource(source);
            return this;
        }

        /**
         * set {@link  #setMainTitle(MainTitle)}
         *
         * @param title 主要内容
         * @return this
         */
        public TextNoticeCardBuilder mainTitle(MainTitle title) {
            this.card.setMainTitle(title);
            return this;
        }

        /**
         * set {@link  #setEmphasisContent(EmphasisContent)}
         *
         * @param emphasisContent 关键数据样式
         * @return this
         */
        public TextNoticeCardBuilder emphasisContent(EmphasisContent emphasisContent) {
            this.card.setEmphasisContent(emphasisContent);
            return this;
        }

        /**
         * set {@link  #setQuoteArea(QuoteArea)}
         *
         * @param quoteArea 文献样式
         * @return this
         */
        public TextNoticeCardBuilder quoteArea(QuoteArea quoteArea) {
            this.card.setQuoteArea(quoteArea);
            return this;
        }

        /**
         * set {@link #setSubTitleText(String)}
         *
         * @param subTitleText 二级普通文本
         * @return this
         */
        public TextNoticeCardBuilder subTitleText(String subTitleText) {
            this.card.setSubTitleText(subTitleText);
            return this;
        }

        /**
         * set {@link  #setHorizontalContentList(List)}
         *
         * @param contentList 二级标题+文本列表
         * @return this
         */
        public TextNoticeCardBuilder horizontalContentList(List<HorizontalContent> contentList) {
            this.card.setHorizontalContentList(contentList);
            return this;
        }

        /**
         * set {@link  #setHorizontalContentList(List)}
         *
         * @param content 二级标题+文本列表
         * @return this
         */
        public TextNoticeCardBuilder horizontalContentList(HorizontalContent content) {
            this.card.setHorizontalContentList(Arrays.asList(content));
            return this;
        }

        /**
         * add {@link  #setHorizontalContentList(List)}
         *
         * @param content 二级标题+文本列表
         * @return this
         */
        public TextNoticeCardBuilder addHorizontalContent(HorizontalContent content) {
            List<HorizontalContent> list = this.card.getHorizontalContentList();
            if (CollectionUtil.isEmpty(list)) {
                list = new ArrayList<>();
            }
            list.add(content);
            this.card.setHorizontalContentList(list);
            return this;
        }

        /**
         * add {@link  #setHorizontalContentList(List)}
         *
         * @param contents 二级标题+文本列表
         * @return this
         */
        public TextNoticeCardBuilder addHorizontalContent(HorizontalContent... contents) {
            List<HorizontalContent> list = this.card.getHorizontalContentList();
            if (CollectionUtil.isEmpty(list)) {
                list = new ArrayList<>();
            }
            list.addAll(Arrays.asList(contents));
            this.card.setHorizontalContentList(list);
            return this;
        }

        /**
         * add {@link  #setHorizontalContentList(List)}
         *
         * @param contents 二级标题+文本列表
         * @return this
         */
        public TextNoticeCardBuilder addHorizontalContent(List<HorizontalContent> contents) {
            List<HorizontalContent> list = this.card.getHorizontalContentList();
            if (CollectionUtil.isEmpty(list)) {
                list = new ArrayList<>();
            }
            list.addAll(contents);
            this.card.setHorizontalContentList(list);
            return this;
        }

        /**
         * set {@link  #setJumpList(List)}
         *
         * @param jumpList 跳转指引样式的列表
         * @return this
         */
        public TextNoticeCardBuilder jumpList(List<Jump> jumpList) {
            this.card.setJumpList(jumpList);
            return this;
        }

        /**
         * set {@link  #setJumpList(List)}
         *
         * @param jump 跳转指引样式的列表
         * @return this
         */
        public TextNoticeCardBuilder jumpList(Jump jump) {
            this.card.setJumpList(Arrays.asList(jump));
            return this;
        }

        /**
         * add {@link  #setJumpList(List)}
         *
         * @param jump 跳转指引样式的列表
         * @return this
         */
        public TextNoticeCardBuilder addJump(Jump jump) {
            List<Jump> list = this.card.getJumpList();
            if (CollectionUtil.isEmpty(list)) {
                list = new ArrayList<>();
            }
            list.add(jump);
            this.card.setJumpList(list);
            return this;
        }

        /**
         * add {@link  #setJumpList(List)}
         *
         * @param jumps 跳转指引样式的列表
         * @return this
         */
        public TextNoticeCardBuilder addJump(Jump... jumps) {
            List<Jump> list = this.card.getJumpList();
            if (CollectionUtil.isEmpty(list)) {
                list = new ArrayList<>();
            }
            list.addAll(Arrays.asList(jumps));
            this.card.setJumpList(list);
            return this;
        }

        /**
         * add {@link  #setJumpList(List)}
         *
         * @param jumps 跳转指引样式的列表
         * @return this
         */
        public TextNoticeCardBuilder addJump(List<Jump> jumps) {
            List<Jump> list = this.card.getJumpList();
            if (CollectionUtil.isEmpty(list)) {
                list = new ArrayList<>();
            }
            list.addAll(jumps);
            this.card.setJumpList(list);
            return this;
        }

        /**
         * set {@link  #setAction(CardAction)}
         *
         * @param action 整体卡片的点击跳转事件
         * @return this
         */
        public TextNoticeCardBuilder action(CardAction action) {
            this.card.setAction(action);
            return this;
        }


        @Override
        public TextNoticeCard build() {
            return this.card;
        }
    }
}
