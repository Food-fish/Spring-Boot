package com.mybatis.many.datasources;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.mybatis.many.util.SqlPrintInterceptor;

/**
 * @author JinTao
 * @Date 2018年8月15日 下午3:38:11
 * @version 1.0
 * 类说明
 */
@Configuration
@MapperScan(basePackages = {"com.mybatis.many.mapper"},sqlSessionFactoryRef = "SqlSessionFactory")
public class DruidDataSourceConfig {
	
	private Logger logger = LoggerFactory.getLogger(DruidDataSourceConfig.class);
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.type}")
    private String dbType;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;
    @Value("${spring.datasource.initialSize}")
    private int initialSize;
    @Value("${spring.datasource.minIdle}")
    private int minIdle;
    @Value("${spring.datasource.maxActive}")
    private int maxActive;
    @Value("${spring.datasource.maxWait}")
    private int maxWait;
    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;
    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;
    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;
    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;
    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;
    @Value("${spring.datasource.filters}")
    private String filters;
    @Value("${spring.datasource.connectionProperties}")
    private String connectionProperties;
    @Value("${spring.datasource.MapperLocations}")
    private String userMapperLocations;
    @Value("${spring.datasource.userGlobalDataSourceStat}")
    private boolean useGlobalDataSourceStat;
    @Value("${spring.datasource.druidLoginName}")
    private String druidLoginName;
    @Value("${spring.datasource.druidPassword}")
    private String druidPassword;
    @Value("${spring.datasource.TypeAliasesPackage}")
    private String typeAliasesPackage;
    @Value("${spring.datasource.configLocation}")
    private String configLocation;
    
	@Bean(name = "DataSource")
	@Order(0)
	@Primary
    public DataSource dataSource() {
		DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(this.dbUrl);
        //datasource.setDbType(dbType);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        //configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        datasource.setConnectionProperties(connectionProperties);
        datasource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }
        datasource.setConnectionProperties(connectionProperties);
        return datasource;
    }
	@Bean(name = "SqlSessionFactory")
    @Primary
    public SqlSessionFactory SqlSessionFactory(@Qualifier("DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
        sqlSessionFactoryBean.setConfigLocation(new DefaultResourceLoader().getResource(configLocation));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(userMapperLocations));// 配置mapper文件位置
        return sqlSessionFactoryBean.getObject();
    }
	
	@Bean(name = "SqlSessionTemplate")
	@Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("SqlSessionFactory")SqlSessionFactory SqlSessionFactory) {
        return new SqlSessionTemplate(SqlSessionFactory);
    }
	
	/**
     * 配置事物管理器
     *
     * @return
     */
    @Bean(name = "TransactionManager")
    @Primary
    public DataSourceTransactionManager TransactionManager(@Qualifier("DataSource") DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
    
    //将要执行的sql进行日志打印(不想拦截，就把这方法注释掉)
    @Bean
    public SqlPrintInterceptor sqlPrintInterceptor(){
        return new SqlPrintInterceptor();
    }
}
