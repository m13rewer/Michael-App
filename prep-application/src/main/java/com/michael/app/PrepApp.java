package com.michael.app;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import oracle.jdbc.pool.OracleDataSource;

@SpringBootApplication
//@EnableDiscoveryClient
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@EnableAutoConfiguration
public class PrepApp {
	public static void main(String[] args) {
		SpringApplication.run(PrepApp.class, args);
	}
	
}

