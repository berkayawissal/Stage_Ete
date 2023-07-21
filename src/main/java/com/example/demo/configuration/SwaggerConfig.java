package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.constraints.NotNull;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)

                .groupName("REST API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(
                        new ApiInfoBuilder()
                                .description("GESTION DE Livraison API DOCUMENTATION ")
                                .title("Gestion De Livraison REST API")
                                .version("1.0.0")
                                .license("Apache 2.0")
                                .build()
                );
    }
    @Bean
    public WebMvcConfigurer swaggerUiConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers(@NotNull ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/custom-path/**")
                        .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                        .resourceChain(false);
            }
        };
    }
}
