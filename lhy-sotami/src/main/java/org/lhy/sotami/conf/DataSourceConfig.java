package org.lhy.sotami.conf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/12/18 4:27 PM
 */
@Configuration
public class DataSourceConfig {

    @Bean("master")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean("slave")
    @ConfigurationProperties(prefix = "spring.slave.datasource")
    public DataSource dataSourceSlave(){
        return DataSourceBuilder.create().build();
    }
}
