package com.per.main;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.per.config.VaultConfiguration;
import com.per.springapp.SpringBootApplicationDemo;

public class SpringBootMainClass extends SpringBootApplicationDemo{

	public SpringBootMainClass(VaultConfiguration configuration) {
		super(configuration);
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(SpringBootApplicationDemo.class, args);
		context.getBean(VaultConfiguration.class);
		
//		SpringBootApplicationDemo.getVaultSecrets();
		
		for (String string : SpringBootApplicationDemo.getVaultSecrets()) {
			System.out.println(string);
		}
		
		context.close(); //Closing Springboot Application
	}

}
