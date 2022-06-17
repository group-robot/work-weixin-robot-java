package io.github.group.robot.weixin.model.card;

import io.github.group.robot.weixin.commons.CardType;
import io.github.group.robot.weixin.model.Message;

/**
 * 模版卡片
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
public abstract class TemplateCard implements Message {
    protected CardType cardType;

    public TemplateCard() {

    }

    public TemplateCard(CardType cardType) {
        this.cardType = cardType;
    }
}
