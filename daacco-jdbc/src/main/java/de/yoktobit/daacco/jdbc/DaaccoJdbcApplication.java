package de.yoktobit.daacco.jdbc;

import javax.sql.DataSource;

import com.querydsl.sql.PostgreSQLTemplates;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.SQLTemplates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

@SpringBootApplication
public class DaaccoJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaaccoJdbcApplication.class, args);
	}

	@Bean
    com.querydsl.sql.Configuration querydslConfiguration() {
        SQLTemplates templates = PostgreSQLTemplates.builder().build();
        com.querydsl.sql.Configuration configuration = new com.querydsl.sql.Configuration(templates);
        return configuration;
    }

    @Bean
    SQLQueryFactory sqlQueryFactory(DataSource dataSource) {
        return new SQLQueryFactory(querydslConfiguration(), new TransactionAwareDataSourceProxy(dataSource));
    }
}
