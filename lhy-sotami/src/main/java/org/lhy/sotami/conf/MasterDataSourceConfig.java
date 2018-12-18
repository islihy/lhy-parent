package org.lhy.sotami.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/12/18 6:05 PM
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryMaster",//配置连接工厂 entityManagerFactory
        transactionManagerRef = "transactionManagerMaster", //配置 事物管理器  transactionManager
        basePackages = {"org.lhy.sotami"}
)
public class MasterDataSourceConfig {
    @Autowired
    @Qualifier("master")
    private DataSource dataSourceMaster;
    @Autowired
    private JpaProperties jpaProperties;

    @Bean("entityManagerMaster")
    @Primary
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryBean(builder).getObject().createEntityManager();
    }
    @Bean("entityManagerFactoryMaster")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSourceMaster)
                .properties(getVendorProperties())
                .packages("com.ztemap.datasource")
                //持久化单元名称，当存在多个EntityManagerFactory时，需要制定此名称
                .persistenceUnit("masterPersistenceUnit")
                .build();

    }
    private Map getVendorProperties() {
        HibernateSettings hibernateSettings = new HibernateSettings();
        //  hibernateSettings.ddlAuto(ddlAuto);
        return jpaProperties.getHibernateProperties(hibernateSettings);
    }
    @Bean("transactionManagerMaster")
    @Primary
    public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryBean(builder).getObject());
    }
}
