package com.example.demo.pojo;

import com.example.demo.common.utils.JwtUtil;

/**
 * @author huyue01@sinovatech.com 2020/1/30 15:42
 */
public class Jwt {
    /**
     * 头部
     */
    private String header;
    /**
     * 负载
     */
    private String payload;
    /**
     * 签名
     */
    private String signature;

    public Jwt(String payload) {
        this.header = JwtUtil.encode(JwtUtil.DEFAULT_HEADER);
        this.payload = JwtUtil.encode(payload);
        this.signature = JwtUtil.getSignature(payload);
    }

    @Override
    public String toString() {
        return header + "." + payload + "." + signature;
    }
}
