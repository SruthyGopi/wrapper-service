package com.example.wrapper.service.wrapperservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean public Docket productApi() { return new
          Docket(DocumentationType.SWAGGER_2) .select()
          .apis(RequestHandlerSelectors.basePackage(
                  "com.example.wrapper.service.wrapperservice.controller")) .paths(regex("/wrapperservice.*")) .build()
          .apiInfo(metaData()); }


  private ApiInfo metaData() {

    @SuppressWarnings("deprecation")
    ApiInfo apiInfo = new ApiInfo(
            "Spring Boot REST API",
            "Spring Boot REST API for developers  ",
            "1.0",
            "Terms of service",
            "Apache License Version 2.0",
            "https://www.apache.org/licenses/LICENSE-2.0",null);
    return apiInfo; }

}
