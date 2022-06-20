package io.github.group.robot.weixin;

import com.hb0730.jsons.SimpleJsonProxy;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Map;

/**
 * result
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/17
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode
public class RobotResult implements Serializable {
    /**
     * error code
     */
    private Integer errorCode;
    /**
     * '
     * error msg
     */
    private String errorMsg;

    public boolean isSuccess() {
        return this.errorCode == 0;
    }

    public static RobotResult toObject(String json) {
        Map resultMap = SimpleJsonProxy.json.fromJson(json, Map.class);
        RobotResult result = new RobotResult();
        result.setErrorCode(Integer.valueOf(resultMap.get("errcode").toString()));
        result.setErrorMsg(resultMap.get("errmsg").toString());
        return result;
    }
}
