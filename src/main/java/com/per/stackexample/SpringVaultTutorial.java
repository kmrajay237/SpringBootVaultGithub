package com.per.stackexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.Paths;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringVaultTutorial {

    public static void main(String[] args) {
        SpringApplication.run(SpringVaultTutorial.class, args);
    }

    //SWAGGER DOCUMENTATION BEANS
    // default group contains all endpoints
    @Bean
    public Docket defaultApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())//all
                .build().apiInfo(apiInfo());
    }

    // Management group contains Spring Actuator endpoints
    @Bean
    public Docket swaggerAdminEndpoints() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(Paths.ROOT)
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.regex("/v1/.*"))
                .build()
                .forCodeGeneration(true);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Vault Demo Application")
                .description("Demo Application using vault")
                .version("1.0")
                .build();
    }

}