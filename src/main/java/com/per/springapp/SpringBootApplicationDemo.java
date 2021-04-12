package com.per.springapp;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.per.config.VaultConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableConfigurationProperties(VaultConfiguration.class)
public class SpringBootApplicationDemo implements CommandLineRunner{
	public static VaultConfiguration configuration;

    public SpringBootApplicationDemo(VaultConfiguration configuration) {
    	SpringBootApplicationDemo.configuration = configuration;
    }
    
    public static List<String> getVaultSecrets() {
    	List<String> vaultSecrets=new ArrayList<>();
		vaultSecrets.add(configuration.getBucketName());//index-0
		vaultSecrets.add(configuration.getAwsAccessKeyID());//index-1
		vaultSecrets.add(configuration.getAwsSecretAccessKey());//index-2
		vaultSecrets.add(configuration.getClientID());//index-3
		vaultSecrets.add(configuration.getClientSecret());//index-4
		vaultSecrets.add(configuration.getPdpUser());//index-5
		vaultSecrets.add(configuration.getPdpPassword());//index-6
		return vaultSecrets;
    }
    
    public void run(String... args) {

        Logger logger = LoggerFactory.getLogger(SpringBootApplicationDemo.class);
//Below Statements could be deleted/commented to avoid printing in console.
        logger.info("----------------------------------------");
        logger.info("***Configuration properties***");
        logger.info("   example.getBucketName is {}", configuration.getBucketName());
        logger.info("   example.getAwsAccessKeyID is {}", configuration.getAwsAccessKeyID());
        logger.info("   example.getAwsSecretAccessKey is {}", configuration.getAwsSecretAccessKey());
        logger.info("   example.getClientID is {}", configuration.getClientID());
        logger.info("   example.getClientSecret is {}", configuration.getClientSecret());
        logger.info("   example.getPdpUser is {}", configuration.getPdpUser());
        logger.info("   example.getPdpPassword is {}", configuration.getPdpPassword());
        logger.info("----------------------------------------");
    }
}
