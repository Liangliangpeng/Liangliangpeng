package com.operatormanager;





import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@EnableScheduling
@EnableTransactionManagement
@SpringBootApplication( scanBasePackages = {"com.operatormanager.**" }) 
@MapperScan("com.operatormanager.user.mapper")
public class ManagerApplication {
	
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ManagerApplication.class);

		app.setBannerMode(Banner.Mode.LOG);

		app.run(args);
	}
	
	
}
