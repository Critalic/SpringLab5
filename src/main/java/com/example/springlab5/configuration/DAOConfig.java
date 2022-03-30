package com.example.springlab5.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DAOConfig {

    @Bean
    public DataSource getMySQLDataSource() {

    }
}
