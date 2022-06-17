package io.github.group.robot.weixin.model.card;

import cn.hutool.core.builder.Builder;
import cn.hutool.core.collection.CollectionUtil;
import io.github.group.robot.weixin.commons.CardType;
import io.github.group.robot.weixin.exception.WeixiuRobotException;
import io.github.group.robot.weixin.model.card.widget.CardAction;
import io.github.group.robot.weixin.model.card.widget.CardImage;
import io.github.group.robot.weixin.model.card.widget.HorizontalContent;
import io.github.group.robot.weixin.model.card.widget.ImageTextArea;
import io.github.group.robot.weixin.model.card.widget.Jump;
import io.github.group.robot.weixin.model.card.widget.MainTitle;
import io.github.group.robot.weixin.model.card.widget.QuoteArea;
import io.github.group.robot.weixin.model.card.widget.Source;
import io.github.group.robot.weixin.model.card.widget.VerticalContent;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 图文展示模版卡片
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/17
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NewsNoticeCard extends TemplateCard {
    /**
     * 卡片来源样式信息，不需要来源样式可不填写
     */
    private Source source;
    /**
     * 模版卡片的主要内容，包括一级标题和标题辅助信息
     */
    private MainTitle mainTitle;
    /**
     * 图片样式
     */
    private CardImage cardImage;
    /**
     * 图片样式
     */
    private ImageTextArea imageTextArea;
    /**
     * 引用文献样式，建议不与关键数据共用
     */
    private QuoteArea quoteArea;
    /**
     * 卡片二级垂直内容，该字段可为空数组，但有数据的话需确认对应字段是否必填，列表长度不超过4
     */
    private List<VerticalContent> verticalContentList;
    /**
     * 二级标题+文本列表，该字段可为空数组，但有数据的话需确认对应字段是否必填，列表长度不超过6
     */
    private List<HorizontalContent> horizontalContentList;
    /**
     * 跳转指引样式的列表，该字段可为空数组，但有数据的话需确认对应字段是否必填，列表长度不超过3
     */
    private List<Jump> jumpList;
    /**
     * 整体卡片的点击跳转事件，news_notice模版卡片中该字段为必填项
     */
    private CardAction action;


    public NewsNoticeCard() {
        this.cardType = CardType.NEWS_NOTICE;
    }

    @Override
    public Map<String, Object> toMessageMap() {
        if (null == this.mainTitle || null == this.cardImage || null == this.action) {
            throw new WeixiuRobotException("main_title,card_image,card_action missing");
        }
        Map<String, Object> message = new HashMap<>(4);
        message.put("card_type", this.cardType.getValue());
        if (null != this.source) {
            message.put("source", this.source.toMessageMap());
        }
        message.put("main_title", this.mainTitle.toMessageMap());
        message.put("card_image", this.cardImage.toMessageMap());
        if (null != this.imageTextArea) {
            message.put("image_text_area", this.imageTextArea.toMessageMap());
        }
        if (null != this.quoteArea) {
            message.put("quote_area", this.quoteArea.toMessageMap());
        }
        if (CollectionUtil.isNotEmpty(this.verticalContentList)) {
            List<Map<String, Object>> verticalContentListMap = new ArrayList<>(this.verticalContentList.size());
            for (VerticalContent content : this.verticalContentList) {
                verticalContentListMap.add(content.toMessageMap());
            }
            message.put("vertical_content_list", verticalContentListMap);
        }
        if (CollectionUtil.isNotEmpty(this.horizontalContentList)) {
            List<Map<String, Object>> horizontalContentListMap = new ArrayList<>(this.horizontalContentList.size());
            for (HorizontalContent content : this.horizontalContentList) {
                horizontalContentListMap.add(content.toMessageMap());
            }
            message.put("horizontal_content_list", horizontalContentListMap);
        }
        if (CollectionUtil.isNotEmpty(this.jumpList)) {
            List<Map<String, Object>> jumpListMap = new ArrayList<>(this.jumpList.size());
            for (Jump jump : this.jumpList) {
                jumpListMap.add(jump.toMessageMap());
            }
            message.put("jump_list", jumpListMap);
        }
        message.put("card_action", this.action.toMessageMap());
        return message;
    }

    /**
     * {@link  NewsNoticeCard} builder
     */
    public static class NewsNoticeCardBuilder implements Builder<NewsNoticeCard> {
        private final NewsNoticeCard card;

        /**
         * builder
         *
         * @return {@link  NewsNoticeCardBuilder}
         */
        public static NewsNoticeCardBuilder builder() {
            return new NewsNoticeCardBuilder();
        }

        public NewsNoticeCardBuilder() {
            this.card = new NewsNoticeCard();

        }

        /**
         * set {@link  #setSource(Source)}
         *
         * @param source {@link Source}
         * @return this
         */
        public NewsNoticeCardBuilder source(Source source) {
            this.card.setSource(source);
            return this;
        }

        /**
         * set {@link  #setMainTitle(MainTitle)}
         *
         * @param mainTitle {@link  MainTitle}
         * @return this
         */
        public NewsNoticeCardBuilder mainTitle(MainTitle mainTitle) {
            this.card.setMainTitle(mainTitle);
            return this;
        }

        /**
         * set {@link  #setCardImage(CardImage)}
         *
         * @param cardImage {@link  CardImage}
         * @return this
         */
        public NewsNoticeCardBuilder cardImage(CardImage cardImage) {
            this.card.setCardImage(cardImage);
            return this;
        }

        /**
         * set {@link  #setImageTextArea(ImageTextArea)}
         *
         * @param imageTextArea {@link  ImageTextArea}
         * @return this
         */
        public NewsNoticeCardBuilder imageTextArea(ImageTextArea imageTextArea) {
            this.card.setImageTextArea(imageTextArea);
            return this;
        }

        /**
         * set {@link  #setQuoteArea(QuoteArea)}
         *
         * @param quoteArea {@link  QuoteArea}
         * @return this
         */
        public NewsNoticeCardBuilder quoteArea(QuoteArea quoteArea) {
            this.card.setQuoteArea(quoteArea);
            return this;
        }

        /**
         * set {@link  #setVerticalContentList(List)}
         *
         * @param contents {@link  VerticalContent} list
         * @return this
         */
        public NewsNoticeCardBuilder verticalContentList(List<VerticalContent> contents) {
            this.card.setVerticalContentList(contents);
            return this;
        }

        /**
         * set {@link  #setVerticalContentList(List)}
         *
         * @param content {@link  VerticalContent}
         * @return this
         */
        public NewsNoticeCardBuilder verticalContentList(VerticalContent content) {
            this.card.setVerticalContentList(Arrays.asList(content));
            return this;
        }


        /**
         * add {@link  #setVerticalContentList(List)}
         *
         * @param content {@link  VerticalContent}
         * @return this
         */
        public NewsNoticeCardBuilder addVerticalContent(VerticalContent content) {
            return addVerticalContent(Arrays.asList(content));
        }

        /**
         * add {@link  #setVerticalContentList(List)}
         *
         * @param content {@link  VerticalContent}
         * @return this
         */
        public NewsNoticeCardBuilder addVerticalContent(VerticalContent... content) {
            return addVerticalContent(Arrays.asList(content));
        }

        /**
         * add {@link  #setVerticalContentList(List)}
         *
         * @param contents {@link  VerticalContent} list
         * @return this
         */
        public NewsNoticeCardBuilder addVerticalContent(List<VerticalContent> contents) {
            List<VerticalContent> list = this.card.getVerticalContentList();
            if (null == list) {
                list = new ArrayList<>();
            }
            list.addAll(contents);
            this.card.setVerticalContentList(list);
            return this;
        }

        /**
         * set {@link  #setHorizontalContentList(List)}
         *
         * @param contents {@link  HorizontalContent} list
         * @return this
         */
        public NewsNoticeCardBuilder horizontalContentList(List<HorizontalContent> contents) {
            this.card.setHorizontalContentList(contents);
            return this;
        }

        /**
         * set {@link  #setHorizontalContentList(List)}
         *
         * @param content {@link  HorizontalContent}
         * @return this
         */
        public NewsNoticeCardBuilder horizontalContentList(HorizontalContent content) {
            this.card.setHorizontalContentList(Arrays.asList(content));
            return this;
        }


        /**
         * add {@link  #setHorizontalContentList(List)}
         *
         * @param content {@link  HorizontalContent}
         * @return this
         */
        public NewsNoticeCardBuilder addHorizontalContent(HorizontalContent content) {
            return addHorizontalContent(Arrays.asList(content));
        }

        /**
         * add {@link  #setHorizontalContentList(List)}
         *
         * @param content {@link  HorizontalContent}
         * @return this
         */
        public NewsNoticeCardBuilder addHorizontalContent(HorizontalContent... content) {
            return addHorizontalContent(Arrays.asList(content));
        }

        /**
         * add {@link  #setHorizontalContentList(List)}
         *
         * @param contents {@link  HorizontalContent} list
         * @return this
         */
        public NewsNoticeCardBuilder addHorizontalContent(List<HorizontalContent> contents) {
            List<HorizontalContent> list = this.card.getHorizontalContentList();
            if (null == list) {
                list = new ArrayList<>();
            }
            list.addAll(contents);
            this.card.setHorizontalContentList(list);
            return this;
        }


        /**
         * set {@link  #setJumpList(List)}
         *
         * @param jumps {@link  Jump} list
         * @return this
         */
        public NewsNoticeCardBuilder jumpList(List<Jump> jumps) {
            this.card.setJumpList(jumps);
            return this;
        }

        /**
         * set {@link  #setJumpList(List)}
         *
         * @param jump {@link  Jump}
         * @return this
         */
        public NewsNoticeCardBuilder jumpList(Jump jump) {
            this.card.setJumpList(Arrays.asList(jump));
            return this;
        }


        /**
         * add {@link  #setJumpList(List)}
         *
         * @param jump {@link  Jump}
         * @return this
         */
        public NewsNoticeCardBuilder addJump(Jump jump) {
            return addJump(Arrays.asList(jump));
        }

        /**
         * add {@link  #setJumpList(List)}
         *
         * @param jump {@link  Jump}
         * @return this
         */
        public NewsNoticeCardBuilder addJump(Jump... jump) {
            return addJump(Arrays.asList(jump));
        }

        /**
         * add {@link  #setJumpList(List)}
         *
         * @param jumps {@link  Jump} list
         * @return this
         */
        public NewsNoticeCardBuilder addJump(List<Jump> jumps) {
            List<Jump> list = this.card.getJumpList();
            if (null == list) {
                list = new ArrayList<>();
            }
            list.addAll(jumps);
            this.card.setJumpList(list);
            return this;
        }

        /**
         * set {@link  #setAction(CardAction)}
         *
         * @param action {@link  CardAction}
         * @return this
         */
        public NewsNoticeCardBuilder action(CardAction action) {
            this.card.setAction(action);
            return this;
        }


        @Override
        public NewsNoticeCard build() {
            return this.card;
        }
    }
}
