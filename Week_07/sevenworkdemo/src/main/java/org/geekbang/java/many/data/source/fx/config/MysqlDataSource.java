package org.geekbang.java.many.data.source.fx.config;

import com.zaxxer.hikari.HikariDataSource;
import org.geekbang.java.many.data.source.fx.constant.DataSourceConstant;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@Configuration
public class MysqlDataSource {

    @Bean("masterDatasource")
    @ConfigurationProperties("spring.datasource.master")
    public HikariDataSource masterDatasource() {
        return new HikariDataSource();
    }

    @Bean("masterJdbcTemplate")
    public JdbcTemplate masterJdbcTemplate() {
        return new JdbcTemplate(masterDatasource());
    }


    @Bean("slaveOneDatasource")
    @ConfigurationProperties("spring.datasource.slave1")
    public HikariDataSource slaveOneDatasource() {
        return new HikariDataSource();
    }

    @Bean("slaveOneJdbcTemplate")
    public JdbcTemplate slave1JdbcTemplate() {
        return new JdbcTemplate(slaveOneDatasource());
    }


    @Bean("slaveTowDatasource")
    @ConfigurationProperties("spring.datasource.slave2")
    public HikariDataSource slaveTowDatasource() {
        return new HikariDataSource();
    }

    @Bean("slaveTowJdbcTemplate")
    public JdbcTemplate slaveTowJdbcTemplate() {
        return new JdbcTemplate(slaveTowDatasource());
    }

    @Bean
    public DynamicDataSourceConfig getDynamicDataSourceConfig(){
        Map<Object, Object> targetDataSources = new HashMap<>(7);
        targetDataSources.put(DataSourceConstant.MASTER, masterDatasource());
        targetDataSources.put(DataSourceConstant.SLAVE_ONE, slaveOneDatasource());
        targetDataSources.put(DataSourceConstant.SLAVE_TOW, slaveTowDatasource());
        return new DynamicDataSourceConfig(slaveOneDatasource(), targetDataSources);
    }


}
