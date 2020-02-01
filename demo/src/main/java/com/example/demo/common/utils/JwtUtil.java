package com.example.demo.common.utils;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author huyue01@sinovatech.com 2020/1/30 14:01
 */
@Slf4j
public class JwtUtil {
    /**
     * 默认head
     */
    public static final String DEFAULT_HEADER = "{\"alg\":\"HS256\",\"typ\":\"JWT\"}";
    /**
     * HmacSHA256 加密算法 秘钥
     */
    public static final String SECRET = "123456";
    /**
     * token有效时间
     */
    public static final long EXPIRE_TIME = 1000 * 60 * 60 * 24;
    /**
     * token中header的名字
     */
    public static final String HEADER_TOKEN_NAME = "Authorization";

    /**
     * Base64URL 编码
     */
    public static String encode(String input) {
        return Base64.getUrlEncoder().encodeToString(input.getBytes());
    }

    /**
     * Base64URL 解码
     */
    public static String decode(String input) {
        return new String(Base64.getUrlDecoder().decode(input.getBytes()));
    }


    /**
     * HmacSHA256 加密算法
     *
     * @param data
     * @param secret
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     * @throws InvalidKeyException
     */
    public static String HmacSHA256(String data, String secret) {
        try {
            Mac hmacSHA256 = Mac.getInstance("HmacSHA256");
            SecretKey secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            hmacSHA256.init(secretKey);
            byte[] array = hmacSHA256.doFinal(data.getBytes(StandardCharsets.UTF_8));
            StringBuilder builder = new StringBuilder();
            for (byte b : array) {
                builder.append(Integer.toHexString((b & 0x100) | 0x100), 1, 3);
            }
            return builder.toString().toUpperCase();
        } catch (Exception e) {
            log.info("HmacSHA256 加密算法异常");
        }
        return "";

    }

    /**
     * 获取签名
     *
     * @param payload
     * @return
     */
    public static String getSignature(String payload) {
        return HmacSHA256(encode(DEFAULT_HEADER) + "." + encode(payload), SECRET);

    }

    /**
     * 验证jwt，正确返回载体数据，错误返回null
     *
     * @param jwt
     * @return
     */
    public static String checkJwt(String jwt) {
        String[] jwts = jwt.split("\\.");
        //验证签名
        if (!HmacSHA256(jwts[0] + "." + jwts[1], SECRET).equals(jwts[2])) {
            return null;
        }
        //验证头部信息
        if (!jwts[0].equals(encode(DEFAULT_HEADER))) {
            return null;
        }
        return decode(jwts[1]);


    }
}
