package com.example.restaurant;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DataBaseConfiguration {
    @Bean
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                System.getenv("JDBC_DATABASE_URL"), System.getenv("JDBC_DATABASE_USERNAME"), System.getenv("JDBC_DATABASE_PASSWORD")
        );
    }
}
