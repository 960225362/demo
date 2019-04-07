package com.huyue.service.impl;

import com.huyue.bean.User;
import com.huyue.dao.UserDao;
import com.huyue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyue01@sinovatech.com 2019/3/17 17:58
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public int insert(User user) {
        return 1;
//        return userDao.insert(user);
    }
}
