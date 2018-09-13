package com.myuserid.Interceptor;

import com.myuserid.auth.SignRequired;
import com.myuserid.exception.BusinessException;
import com.myuserid.pojo.enums.StatusCode;
import com.myuserid.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

/**
 * 签名拦截器
 * Created by Administrator on 2018/8/1.
 */
public class SignInterceptor extends HandlerInterceptorAdapter {

    @Value("${app.secret}")
    private String AppSecret;
    private static final Logger logger = LoggerFactory.getLogger(SignInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        SignRequired signRequired = method.getAnnotation(SignRequired.class);
        if (signRequired == null) {
            return true;
        }

        System.out.println("need sign AppSecret:" + AppSecret);
        boolean right = verifySign(AppSecret, request);
        if (right) {
            return true;
        }

        throw new BusinessException(StatusCode.ClientError, "签名错误");
    }

    /**
     * md5签名
     * 按参数名称升序，将参数值进行连接 签名
     */
    private static String sign(String appSecret, TreeMap<String, String> params) {
        StringBuilder paramValues = new StringBuilder();
        params.put("appSecret", appSecret);

        for (Map.Entry<String, String> entry : params.entrySet()) {
            paramValues.append(entry.getValue());
        }
        System.out.println(MD5Util.md5(paramValues.toString()));
        return MD5Util.md5(paramValues.toString());
    }


    /**
     * sign verify
     *
     * @param appSecret input sign Str
     * @param request   input request
     * @return true false
     * @throws Exception no Sign Paramter
     */
    private static boolean verifySign(String appSecret, HttpServletRequest request) throws Exception {

        TreeMap<String, String> params = new TreeMap<>();
        String signStr = request.getParameter("sign");
        if (StringUtils.isEmpty(signStr)) {
            throw new RuntimeException("There is no signature field in the request parameter!");
        }

        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paramName = enu.nextElement().trim();
            if (!paramName.equals("sign")) {
                params.put(paramName, URLDecoder.decode(request.getParameter(paramName), "UTF-8"));
            }
        }

        return sign(appSecret, params).equals(signStr);
    }
}
