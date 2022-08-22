package cn.com.uestc.constant;

/**
 * 返回码定义
 */
public interface ResponseCode {

    /**
     * 成功
     */
    int SUCCESS = 0;

    /**
     * 服务器异常
     */
    int FAIL = 1;

    /**
     * 无权限
     */
    int ACCESS_DENIED = 2;

    /**
     * 业务异常
     */
    int BUSINESS_FAIL = 4;

    /**
     * 参数错误
     */
    int PARAM_VALIDATION_ERROR = 4;
}
