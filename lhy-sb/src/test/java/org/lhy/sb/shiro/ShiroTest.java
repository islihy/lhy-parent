package org.lhy.sb.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lhy.sb.SbApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * User: hangyu.li E-mail:islihy@qq.com
 * DateTime: 2018/7/18 下午3:48
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SbApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@EnableAutoConfiguration
public class ShiroTest {
    @Test
    public void testLogin() {
        //1、获取 SecurityManager 工厂，此处使用 Ini 配置文件初始化 SecurityManager
        Factory<SecurityManager> factory =  new IniSecurityManagerFactory("classpath:shiro.ini");
        //2、得到 SecurityManager 实例 并绑定给 SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到 Subject 及创建用户名/密码身份验证 Token(即用户身份/凭证)
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhang","123");
        try{
            subject.login(usernamePasswordToken);
            System.out.println("登录");
        }catch (AuthenticationException a){

        }
        Assert.assertEquals(true,subject.isAuthenticated());
        System.out.println("登录成功");
        subject.logout();
    }
}
