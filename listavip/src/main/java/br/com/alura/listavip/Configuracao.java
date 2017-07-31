package br.com.alura.listavip;

import java.util.Properties;
import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class Configuracao {

    public static void main(String[] args) {
        SpringApplication.run(Configuracao.class, args);
    }

    @Bean
    public DataSource dataSource() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.hbm2ddl.auto", "update");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setConnectionProperties(properties);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/listavip");
        dataSource.setUsername("root");
        dataSource.setPassword("pa33Lx$k");
        return dataSource;
    }

}
