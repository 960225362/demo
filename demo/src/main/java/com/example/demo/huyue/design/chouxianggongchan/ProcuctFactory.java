package com.example.demo.huyue.design.chouxianggongchan;

import com.example.demo.common.utils.SpringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

/**
 * @author huyue01@sinovatech.com 2019/11/9 14:35
 */
@Component
public class ProcuctFactory {
    @Value("${demo.productName}")
    private String productName;

    public IProduct getProduct(){
        return SpringUtil.getBean(this.productName);

    }
}
