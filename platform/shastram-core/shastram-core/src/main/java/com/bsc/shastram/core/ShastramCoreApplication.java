package com.bsc.shastram.core;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(
		  basePackages = {"com.bsc.shastram.commons.*","com.bsc.shastram.core.*"} 
//		  basePackageClasses = DemoBean.class
		  )
public class ShastramCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShastramCoreApplication.class, args);
	}
	
	
	@Bean
	public ModelMapper modelMapper() {
	 return new ModelMapper();
	}

}
