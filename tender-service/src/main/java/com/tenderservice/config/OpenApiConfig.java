package com.tenderservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Tender & Bids API")
            .description("Microservices for Tenders")
            .version("1.0")
            .contact(new Contact()
                .name("Sahit Berisha")
                .email("sahitberisha11@gmail.com")));
  }
}
