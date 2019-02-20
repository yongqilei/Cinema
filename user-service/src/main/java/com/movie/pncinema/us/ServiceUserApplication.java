package com.movie.pncinema.us;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 启动类
 * @author leiyongqi
 *
 */
@SpringBootApplication
@MapperScan(basePackages = { "com.movie.pncinema.us.dao" })
public class ServiceUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceUserApplication.class, args);
	}
	
}
