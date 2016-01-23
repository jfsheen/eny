package cc.asic.platform.test;

import cc.aisc.platform.WebApplication;
import cc.aisc.platform.system.config.AppConfig;
import cc.aisc.platform.system.config.SecurityConfig;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sjf on 16-1-14.
 */
//指定测试类的运行者
@RunWith(SpringJUnit4ClassRunner.class)
//指定spring配置类
@ContextConfiguration(classes = {WebApplication.class, AppConfig.class, SecurityConfig.class})
//@SpringApplicationConfiguration(classes = {WebApplication.class, AppConfig.class, SecurityConfig.class})
//@WebAppConfiguration is a class-level annotation that is used to declare
//that the ApplicationContext loaded for an integration test should be a WebApplicationContext.
@WebAppConfiguration
@Transactional
public class TestConfig {
    protected static Logger log = null;

    public TestConfig() {
        log = LoggerFactory.getLogger(getClass().getName());
    }


}

