package com.example.demo.pojo;

import lombok.Data;

/**
 * @author huyue01@sinovatech.com 2019/8/25 11:38
 */
@Data
public class Jobs {
    private Integer jobId;//自动增长id
    private String jobName; //岗位
    private String companyName;//公司名
    private String workAddr;//公司地址
    private String salary;//薪水
    private String pushDate;//发布日期
    private String jobKey;//对应城市的id
}
