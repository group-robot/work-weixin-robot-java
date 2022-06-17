package io.github.group.robot.weixin.model;

import cn.hutool.core.builder.Builder;
import cn.hutool.core.collection.CollectionUtil;
import io.github.group.robot.weixin.commons.MsgType;
import io.github.group.robot.weixin.exception.WeixiuRobotException;
import io.github.group.robot.weixin.model.news.Article;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 图文类型
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NewsMessage extends AbstractMessage {
    /**
     * 图文消息，<strong>必填</strong>
     */
    private List<Article> articles;

    public NewsMessage() {
        this.type = MsgType.NEWS;
    }

    /**
     * set article
     *
     * @param articles article
     */
    public void setArticle(List<Article> articles) {
        this.articles = articles;
    }

    /**
     * set article
     *
     * @param article article
     */
    public void setArticle(Article article) {
        if (null == this.articles) {
            this.articles = new ArrayList<>();
        }
        this.articles.add(article);
    }


    /**
     * add article
     *
     * @param article article
     */
    public void addArticle(Article article) {
        if (null == this.articles) {
            this.articles = new ArrayList<>();
        }
        this.articles.add(article);
    }

    /**
     * add article
     *
     * @param articles article
     */
    public void addArticle(Article... articles) {
        if (null == this.articles) {
            this.articles = new ArrayList<>();
        }
        this.articles.addAll(Arrays.asList(articles));
    }

    /**
     * add article
     *
     * @param articles article
     */
    public void addArticle(List<Article> articles) {
        if (null == this.articles) {
            this.articles = new ArrayList<>();
        }
        this.articles.addAll(articles);
    }

    @Override
    public Map<String, Object> toMessageMap() {
        if (CollectionUtil.isEmpty(this.articles)) {
            throw new WeixiuRobotException("news message missing");
        }
        List<Map<String, Object>> articles = new ArrayList<>(this.articles.size());
        for (Article article : this.articles) {
            articles.add(article.toMessageMap());
        }
        Map<String, Object> articleMap = new HashMap<>(1);
        articleMap.put("articles", articles);

        Map<String, Object> message = new HashMap<>(2);
        message.put("msgtype", this.type.getValue());
        message.put("news", articleMap);
        return message;
    }

    /**
     * {@link  NewsMessage} builder
     */
    public static class NewsMessageBuilder implements Builder<NewsMessage> {
        private final NewsMessage message;

        /**
         * builder
         *
         * @return {@link  NewsMessageBuilder}
         */
        public static NewsMessageBuilder builder() {
            return new NewsMessageBuilder();
        }

        public NewsMessageBuilder() {
            message = new NewsMessage();
        }


        /**
         * set article
         *
         * @param articles article
         * @return this
         */
        public NewsMessageBuilder setArticle(List<Article> articles) {
            message.setArticle(articles);
            return this;
        }

        /**
         * set article
         *
         * @param article article
         * @return this
         */
        public NewsMessageBuilder setArticle(Article article) {
            message.setArticle(article);
            return this;
        }


        /**
         * add article
         *
         * @param article article
         * @return this
         */
        public NewsMessageBuilder addArticle(Article article) {
            message.addArticle(article);
            return this;
        }

        /**
         * add article
         *
         * @param articles article
         * @return this
         */
        public NewsMessageBuilder addArticle(Article... articles) {
            this.message.addArticle(articles);
            return this;
        }

        /**
         * add article
         *
         * @param articles article
         * @return this
         */
        public NewsMessageBuilder addArticle(List<Article> articles) {
            this.message.addArticle(articles);
            return this;
        }

        @Override
        public NewsMessage build() {
            return this.message;
        }
    }
}
