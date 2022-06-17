package io.github.group.robot.weixin;

import cn.hutool.core.util.StrUtil;
import io.github.group.robot.weixin.exception.WeixiuRobotException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * request send service
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/17
 * @since 1.0.0
 */
@Slf4j
public class RobotSend {
    @Getter
    @Setter
    private String webhook;

    public RobotSend(String webhook) {
        if (StrUtil.isBlank(webhook)) {
            throw new WeixiuRobotException("webhook missing");
        }
        this.webhook = webhook;
    }

}
