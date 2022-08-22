package cn.com.uestc.constant;

import java.nio.charset.StandardCharsets;

public interface Key {

    /**
     * 管理端登录密码盐
     */
    byte[] ADMIN_PWD_SALT = "hm-Hydra".getBytes(StandardCharsets.UTF_8);
}
