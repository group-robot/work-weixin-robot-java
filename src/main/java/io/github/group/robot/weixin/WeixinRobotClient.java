package io.github.group.robot.weixin;

import cn.hutool.core.util.StrUtil;
import com.hb0730.https.HttpHeader;
import com.hb0730.https.SimpleHttp;
import com.hb0730.https.constants.Constants;
import com.hb0730.https.support.SimpleHttpResponse;
import com.hb0730.jsons.SimpleJsonProxy;
import io.github.group.robot.weixin.exception.WeixiuRobotException;
import io.github.group.robot.weixin.model.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * request send service
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/17
 * @since 1.0.0
 */
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class WeixinRobotClient {
    /**
     * WeChat group robot webhook url
     */
    @Getter
    @Setter
    private String webhook;

    /**
     * send message
     *
     * @param message message
     * @return result
     */
    public RobotResult sendMessage(Message message) {
        return sendMessage(this.webhook, message);
    }

    /**
     * send message
     *
     * @param url     webhook
     * @param message message
     * @return result
     */
    public RobotResult sendMessage(String url, Message message) {
        if (null == message) {
            throw new WeixiuRobotException("message missing");
        }
        Map<String, Object> map = message.toMessageMap();
        return sendMessage(url, SimpleJsonProxy.json.toJson(map));
    }

    /**
     * send message
     *
     * @param json message json
     * @return result
     */
    public RobotResult sendMessage(String json) {
        return sendMessage(this.webhook, json);
    }

    /**
     * send message
     *
     * @param url  webhook
     * @param json message json
     * @return result
     */
    public RobotResult sendMessage(String url, String json) {
        if (StrUtil.isBlank(url)) {
            throw new WeixiuRobotException("url missing");
        }
        if (StrUtil.isBlank(json)) {
            throw new WeixiuRobotException("message missing");
        }
        SimpleHttpResponse response = SimpleHttp.HTTP.post(webhook, json,
            HttpHeader.builder().add(Constants.CONTENT_TYPE,
                Constants.CONTENT_TYPE_JSON_UTF_8));
        if (log.isDebugEnabled()) {
            log.info("request body:{}", json);
            log.info("response status: {},body:{}", response.isSuccess(), response.isSuccess() ? response.getBodyStr() :
                "");
        }
        return RobotResult.toObject(response.getBodyStr());
    }


}
