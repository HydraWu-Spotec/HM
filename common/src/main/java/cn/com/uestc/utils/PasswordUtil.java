package cn.com.uestc.utils;

import cn.com.uestc.constant.Key;
import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;

/**
 * 密码生成器
 */
public class PasswordUtil {

    private static final HMac HMAC = new HMac(HmacAlgorithm.HmacSHA256, Key.ADMIN_PWD_SALT);

    /**
     * 管理端密码生成
     * @param password 明文
     * @return 密文
     */
    public static String generateAdminPwd(String password) {
        return HMAC.digestHex(password);
    }

}
