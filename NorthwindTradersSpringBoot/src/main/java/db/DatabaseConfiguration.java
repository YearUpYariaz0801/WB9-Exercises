package com.pluralsight.NorthwindTradersSpringBoot.db;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
@Configuration
public class DatabaseConfiguration {
    private BasicDataSource basicDataSource;

    @Bean
    public DataSource dataSource(){
        return this.basicDataSource;
    }
    public DatabaseConfiguration(@Value("${datasource.url}") String url,
                                 @Value("${datasource.username}") String username,
                                 @Value("${datasource.password}") String password){
        this.basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        System.out.println("Datasource configured to " + url + " as user " + username);

    }
}