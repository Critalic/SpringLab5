package com.example.springlab5.mvc;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
@EnableEncryptableProperties
public class SpringLab5Application {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(SpringLab5Application.class, args);
        System.out.println(context.getBean("mysqlDataSource", DataSource.class).getConnection().getCatalog());
    }
}
