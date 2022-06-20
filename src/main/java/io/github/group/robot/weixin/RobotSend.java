package io.github.group.robot.weixin;

import cn.hutool.core.util.StrUtil;
import com.hb0730.https.HttpHeader;
import com.hb0730.https.SimpleHttp;
import com.hb0730.https.constants.Constants;
import com.hb0730.https.support.SimpleHttpResponse;
import com.hb0730.jsons.SimpleJsonProxy;
import io.github.group.robot.weixin.exception.WeixiuRobotException;
import io.github.group.robot.weixin.model.Message;
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
    /**
     * WeChat group robot webhook url
     */
    @Getter
    @Setter
    private String webhook;

    public RobotSend() {
    }

    public RobotSend(String webhook) {
        if (StrUtil.isBlank(webhook)) {
            throw new WeixiuRobotException("webhook missing");
        }
        this.webhook = webhook;
    }

    /**
     * send request
     *
     * @param message robot  message
     * @return send response
     */
    public RobotResult send(Message message) {
        if (null == message) {
            throw new WeixiuRobotException("message missing");
        }
        if (StrUtil.isBlank(this.webhook)) {
            throw new WeixiuRobotException("url missing");
        }
        String jsonStr = SimpleJsonProxy.json.toJson(message.toMessageMap());
        SimpleHttpResponse response = SimpleHttp.HTTP.post(webhook, jsonStr,
            HttpHeader.builder().add(Constants.CONTENT_TYPE,
                Constants.CONTENT_TYPE_JSON_UTF_8));
        if (log.isDebugEnabled()) {
            log.info("request body:{}", jsonStr);
            log.info("response status: {},body:{}", response.isSuccess(), response.isSuccess() ? response.getBodyStr() :
                "");
        }
        return RobotResult.toObject(response.getBodyStr());
    }

}
