package com.example.demo.common.configuration;

import com.example.demo.common.handler.AuthLimitHandler;
import com.example.demo.common.handler.LoginSuccessHandler;
import com.example.demo.dao.SysUserMapper;
import com.example.demo.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.security.util.Password;

/**
 * @author huyue01@sinovatech.com 2020/1/29 14:37
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired(required = false)
    private SysUserMapper sysUserMapper;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关闭csrf
        http.csrf().disable();

//        //配置登录界面
//        http.formLogin().loginPage("/login").permitAll();
//
//        //登录成功后的跳转页面
//        http.formLogin().successHandler(new LoginSuccessHandler());
//
//        //登出授权
//        http.logout().permitAll();
//
//        //授权配置
//        http.authorizeRequests()
//                //所有静态文件可以访问
//                .antMatchers("/css/**").permitAll()
//                .anyRequest().fullyAuthenticated();
//
//        //用户权限不足处理器
//        http.exceptionHandling().accessDeniedHandler(new AuthLimitHandler());
//
//        //rest 无状态 无session
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //开启授权认证
        http.authorizeRequests()
                .antMatchers("/oauth/**").permitAll()
                .anyRequest().authenticated();

        //登录配置
        http.formLogin().permitAll();

        //session设置成IF_REQUIRED 有需要才生成
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("user").password(new BCryptPasswordEncoder().encode("123456")).roles("USER")
                .and()
                .withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles("ADMIN")
                .and()
                .withUser("one").password(new BCryptPasswordEncoder().encode("123456")).roles("ONE")
                .and()
                .withUser("two").password(new BCryptPasswordEncoder().encode("123456")).roles("TWO")
                .and()
                .withUser("three").password(new BCryptPasswordEncoder().encode("123456")).roles("THREE");
//        auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return null;
    }

    /**
     * 授权服务需要用到这个Bean
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 配置密码为不加密
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}
