package io.github.group.robot.weixin.commons;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.group.robot.weixin.exception.WeixiuRobotException;
import lombok.experimental.UtilityClass;

/**
 * jackson util
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/17
 * @since 1.0.0
 */
@UtilityClass
public class JacksonUtil {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * to json string
     *
     * @param obj object
     * @return json string
     */
    public String toStr(Object obj) {
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new WeixiuRobotException("to string json error", e);
        }
    }
}
