package com.mybatis.many.config;

import com.mybatis.many.util.DynamicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: JinTao
 * @Description: Mybatis多数据源切换
 * @Date: 15:22 2018/8/15
 */
@Configuration
public class DataSourceConfig {

    private final static String DATASOURCE_KEY = "DataSource";
    private final static String DATASOURCE_DS1 = "DataSourceDs1";

    @Bean
    public DataSource routingDataSource(
            @Qualifier("DataSource") DataSource DataSource,
            @Qualifier("DataSourceDs1") DataSource DataSourceDs1
    ) {
        DynamicDataSource dataSource = new DynamicDataSource();
        Map<Object, Object> DataSources = new HashMap<>();
        DataSources.put(DATASOURCE_KEY, DataSource);
        DataSources.put(DATASOURCE_DS1, DataSourceDs1);
        dataSource.setTargetDataSources(DataSources);
        dataSource.setDefaultTargetDataSource(DataSourceDs1);
        return dataSource;
    }
}
