package io.github.group.robot.weixin.exception;

/**
 * 异常
 *
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/16
 * @since 1.0.0
 */
public class WeixiuRobotException extends RuntimeException {
    public WeixiuRobotException(String message) {
        super(message);
    }

    public WeixiuRobotException(String message, Throwable cause) {
        super(message, cause);
    }
}
