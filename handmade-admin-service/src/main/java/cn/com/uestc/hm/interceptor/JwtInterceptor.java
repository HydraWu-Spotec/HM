package cn.com.uestc.hm.interceptor;

import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.signers.HMacJWTSigner;
import cn.hutool.jwt.signers.JWTSigner;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 请求拦截器
 */
@Component
public class JwtInterceptor implements WebRequestInterceptor {

    @Override
    public void preHandle(WebRequest request) {
        System.out.println(request.getHeader("authorization"));
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) {

    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) {

    }
}
