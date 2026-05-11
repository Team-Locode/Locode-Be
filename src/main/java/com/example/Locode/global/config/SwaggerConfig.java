package com.example.Locode.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI swagger() {
        return new OpenAPI()
                .info(new Info()
                        .title("Locode API")
                        .description("플라워토브 이벤트 웹페이지 API")
                        .version("v1.0.0"));
    }
}
