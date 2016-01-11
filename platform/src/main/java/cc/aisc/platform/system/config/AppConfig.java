package cc.aisc.platform.system.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by sjf on 15-11-14.
 */
@Configuration
@EnableCaching
@PropertySource("classpath:application.properties")
/*@EnableJpaRepositories(repositoryBaseClass = BaseDaoImpl.class)
@EnableTransactionManagement*/
public class AppConfig {

    @Autowired
    private Environment env;
    /*
     * ehcache 主要的管理器
     */
    @Bean(name = "appEhCacheCacheManager")
    public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean){
        return new EhCacheCacheManager (bean.getObject ());
    }

    /*
     * 据shared与否的设置,Spring分别通过CacheManager.create()或new CacheManager()方式来创建一个ehcache基地.
     */
    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean ();
        cacheManagerFactoryBean.setConfigLocation (new ClassPathResource("ehcache.xml"));
        cacheManagerFactoryBean.setShared (true);
        return cacheManagerFactoryBean;
    }

    /*@Bean
    public DataSource dataSource() {

        *//*DruidDataSource dataSource = new DruidDataSource();
        try{
            dataSource = DruidDataSourceFactory.createDataSource()
            *//**//*dataSource.setDriverClassName(env.getProperty("druid.driverClass"));*//**//*
        } catch (Exception e) {
            e.printStackTrace();
        }*//*

        *//*ComboPooledDataSource dataSource=new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(env.getProperty("c3p0.driverClass"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        dataSource.setJdbcUrl(env.getProperty("c3p0.jdbcUrl"));
        dataSource.setUser(env.getProperty("c3p0.user"));
        dataSource.setPassword(env.getProperty("c3p0.password"));
        dataSource.setInitialPoolSize(Integer.valueOf(env.getProperty("c3p0.initialPoolSize")));
        dataSource.setAcquireIncrement(Integer.valueOf(env.getProperty("c3p0.acquireIncrement")));
        dataSource.setMinPoolSize(Integer.valueOf(env.getProperty("c3p0.minPoolSize")));
        dataSource.setMaxPoolSize(Integer.valueOf(env.getProperty("c3p0.maxPoolSize")));
        dataSource.setMaxIdleTime(Integer.valueOf(env.getProperty("c3p0.maxIdleTime")));
        dataSource.setIdleConnectionTestPeriod(Integer.valueOf(env.getProperty("c3p0.idleConnectionTestPeriod")));
        return dataSource;*//*

        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.HSQL).build();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.acme.domain");
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }*/
}
