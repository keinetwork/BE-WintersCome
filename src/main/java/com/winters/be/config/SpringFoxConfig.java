package com.winters.be.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;


@Configuration
@ComponentScan(basePackages = {"com.winters.be.api.controller", "com.winters.be.cms.controller"})
public class SpringFoxConfig {
    private ApiInfo swaggerInfo(){
        return new ApiInfoBuilder()
                .title("Winters Come")
                .version("1.0")
                .description("중고상품 거래 플랫폼")
                .license("라이센승ㅇ")
                .build();
    }
    @Bean
    public Docket cmsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .consumes(getConsumeContentTypes())
                .produces(getProduceContentTypes())
                .apiInfo(swaggerInfo())
                .groupName("관리자페이지 API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.winters.be.cms.controller"))
                .paths(PathSelectors.any())
                .build()
//                .useDefaultResponseMessages(false)
                ;
    }

    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .consumes(getConsumeContentTypes())
                .produces(getProduceContentTypes())
                .apiInfo(swaggerInfo())
                .groupName("유저페이지 API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.winters.be.api.controller"))
                .paths(PathSelectors.any())
                .build()
//                .useDefaultResponseMessages(false)
                ;
    }

    private Set<String> getConsumeContentTypes() {
        Set<String> consumes = new HashSet<>();
        consumes.add("application/json;charset=UTF-8");
        consumes.add("application/x-www-form-urlencoded");
        consumes.add("mulipart/form-data");
        return consumes;
    }

    private Set<String> getProduceContentTypes() {
        Set<String> consumes = new HashSet<>();
        consumes.add("application/json;charset=UTF-8");
        return consumes;
    }
}
