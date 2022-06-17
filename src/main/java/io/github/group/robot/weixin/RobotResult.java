package io.github.group.robot.weixin;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
    @JsonAlias("errcode")
    private Integer errorCode;
    /**
     * '
     * error msg
     */
    @JsonAlias("errmsg")
    private String errorMsg;

    public boolean isSuccess() {
        return this.errorCode == 0;
    }
}
