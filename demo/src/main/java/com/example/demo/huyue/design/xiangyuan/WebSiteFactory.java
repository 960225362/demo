package com.example.demo.huyue.design.xiangyuan;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huyue01@sinovatech.com 2019/12/22 16:51
 */
public class WebSiteFactory {
    private Map<String,WebSite> webSiteMap = new HashMap<>();

    public WebSite getWebSite(String key){
        if (!webSiteMap.containsKey(key)){
            webSiteMap.put(key,new ConcreteWebSite(key));
        }
        return webSiteMap.get(key);
    }

    public int getWebSiteCount(){
        return webSiteMap.size();
    }
}
