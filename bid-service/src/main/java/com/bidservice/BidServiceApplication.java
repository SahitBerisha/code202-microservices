package com.bidservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "Bids API",
        version = "1.0",
        description = "Endpoints for Tender & Bids microservices"))
public class BidServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(BidServiceApplication.class, args);
  }

}
