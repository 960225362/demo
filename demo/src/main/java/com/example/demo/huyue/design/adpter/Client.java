package com.example.demo.huyue.design.adpter;

/**
 * @author huyue01@sinovatech.com 2019/11/23 11:24
 */
public class Client {
    public static void main(String[] args) {
        Company company1 = new PeopleCompany();
        company1.show();

        Company company2 = new AdaterCompany(new PeopleNotCompany());
        company2.show();
    }
}
