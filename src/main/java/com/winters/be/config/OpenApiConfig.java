package com.winters.be.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "WINTERS COME API 명세서",
                description = "API 명세서",
                version = "v1",
                contact = @Contact(
                        name = "beginners",
                        email = "keinetwork@gmail.com"
                )
        )
)
@Configuration
public class OpenApiConfig {
    @Bean
    public GroupedOpenApi userGroupOpenApi() {
        String[] paths = {"/api/**"};
        return GroupedOpenApi.builder().group("1_USER API").pathsToMatch(paths)
            .build();
    }
    @Bean
    public GroupedOpenApi cmsGroupOpenApi() {
        String[] paths = { "/cms/**"};
        return GroupedOpenApi.builder().group("2_CMS API").pathsToMatch(paths)
                .build();
    }
}
