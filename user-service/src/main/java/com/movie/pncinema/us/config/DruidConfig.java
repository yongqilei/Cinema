package com.movie.pncinema.us.config;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * Druid配置
 * @author leiyongqi
 *
 */
@Configuration
public class DruidConfig {
	
	private static final Logger LOG = LoggerFactory.getLogger(DruidConfig.class);
	
//	@Value("${spring.datasource.primary.password-callback}")
//	private String passwordCallbackClassName;
	
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.druid.primary")
	@Bean
	public DataSource primaryDataSourcce() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	public ServletRegistrationBean<Servlet> statViewServlet(){
		// 向Spring Boot提供的ServletRegistrationBean注册Druid的StatViewServlet
		ServletRegistrationBean<Servlet> servletRegistrationBean = new ServletRegistrationBean<Servlet>(new StatViewServlet(), "/druid/*");
		
		// 添加初始化参数
		// 添加白名单
		servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
		// IP黑名单(同时存在时，deny优先于allow)
//		servletRegistrationBean.addInitParameter("deny", "192.168.1.73");
		// 登录账号密码
		servletRegistrationBean.addInitParameter("loginUsername", "admin");
		servletRegistrationBean.addInitParameter("loginPassword", "123456");
		// 是否能够重置数据
		servletRegistrationBean.addInitParameter("resetEnable", "false");
		
		return servletRegistrationBean;
		
	}
	
	@Bean
	public FilterRegistrationBean<Filter> filterRegistrationBean() {
		FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<Filter>();
		
		bean.setFilter(new WebStatFilter());
		bean.addUrlPatterns("/*");
		bean.addInitParameter("exclusiongs", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		bean.addInitParameter("profileEnable", "true");
		
		return bean;
		
		
	}
	
	
	
}
