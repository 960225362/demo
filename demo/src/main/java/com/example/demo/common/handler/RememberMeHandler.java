package com.example.demo.common.handler;

import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.jnlp.PersistenceService;
import java.util.Date;

/**
 * @author huyue01@sinovatech.com 2020/1/30 13:14
 */
public class RememberMeHandler implements PersistentTokenRepository {
    @Override
    public void createNewToken(PersistentRememberMeToken persistentRememberMeToken) {

    }

    @Override
    public void updateToken(String s, String s1, Date date) {

    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String s) {
        return null;
    }

    @Override
    public void removeUserTokens(String s) {

    }
}
