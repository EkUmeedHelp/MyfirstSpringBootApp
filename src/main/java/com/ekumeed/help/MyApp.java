package com.ekumeed.help;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.ekumeed.help.ctrl.DataBase;

//https://github.com/EkUmeedHelp/MyfirstSpringBootApp

@SpringBootApplication
@Configuration
@PropertySource({"classpath:database.properties","classpath:Email.properties"})
public class MyApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(MyApp.class, args);
		DataBase db = (DataBase)ctx.getBean(DataBase.class);
		System.out.println("Name : "+db.getName());
		System.out.println("Password : "+db.getPassword());
	}
	
	@Autowired
	Environment env;
	
	@Value("${ekumeedhelp.name}")
	public String name;
	
	@Value("${ekumeedhelp.password}")
	public String password;
	
	@Bean
	public DataBase getDeatils(){
		DataBase db = new DataBase();
		db.setName(env.getProperty("ENV.NAME"));
		db.setPassword(password);
		return db;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer property(){
		return new PropertySourcesPlaceholderConfigurer();
	}

}
