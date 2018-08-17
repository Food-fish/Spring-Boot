package com.mybatis.many.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @ClassName:：DruidMonitorConfig 
 * @Description： TODO
 * @author ：JinTao
 * @date ：2018年8月17日 上午10:39:15 
 *
 */
@Configuration
public class DruidMonitorConfig{

    @Value("${spring.datasource.druidLoginName}")
    private String druidLoginName;
    @Value("${spring.datasource.druidPassword}")
    private String druidPassword;

    @Bean
    public ServletRegistrationBean<StatViewServlet> druidServlet() {
        ServletRegistrationBean<StatViewServlet> reg = new ServletRegistrationBean<StatViewServlet>();
        reg.getUrlMappings().clear();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");  //url 匹配
        reg.addInitParameter("allow", "192.168.16.110,127.0.0.1"); // IP白名单 (没有配置或者为空，则允许所有访问)
        reg.addInitParameter("deny", "192.168.16.111"); //IP黑名单 (存在共同时，deny优先于allow)
        reg.addInitParameter("loginUsername", this.druidLoginName);//登录名
        reg.addInitParameter("loginPassword", this.druidPassword);//登录密码
        reg.addInitParameter("resetEnable", "false"); // 禁用HTML页面上的“Reset All”功能
        //reg.setName("druid");
        return reg;
    }

    @Bean(name="druidWebStatFilter")
    public FilterRegistrationBean<WebStatFilter> filterRegistrationBean() {
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<WebStatFilter>();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/**");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*"); //忽略资源
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        filterRegistrationBean.addInitParameter("principalCookieName", "USER_COOKIE");
        filterRegistrationBean.addInitParameter("principalSessionName", "USER_SESSION");
        return filterRegistrationBean;
    }
}
