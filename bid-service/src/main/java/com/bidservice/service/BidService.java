package com.bidservice.service;

import static java.util.stream.Collectors.toUnmodifiableList;

import com.bidservice.dto.BidMapper;
import com.bidservice.dto.BidRequest;
import com.bidservice.dto.BidResponse;
import com.bidservice.dto.TenderResponse;
import com.bidservice.dto.TenderResponse.Status;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class BidService {

  private static final String BASE_URL = "http://localhost:8081/api/v1";

  private final BidMapper mapper;
  private final RestTemplate restTemplate;
  private final WebClient webClient;

  @Autowired
  public BidService(BidMapper mapper, RestTemplate restTemplate, WebClient webClient) {
    this.mapper = mapper;
    this.restTemplate = restTemplate;
    this.webClient = webClient;
  }

  public BidResponse create(BidRequest request, UUID id) {
    var bid = mapper.map(request);
    bid.setTenderId(getOneTender(id).getId());
    return mapper.map(bid);
  }

  private TenderResponse getOneTender(UUID id) {
    return restTemplate.getForObject(BASE_URL + "/tenders/{id}", TenderResponse.class, id);
  }

  public Mono<List<TenderResponse>> getAllActiveTenders() {
    return webClient.get()
        .uri(BASE_URL + "/tenders/active")
        .retrieve()
        .bodyToFlux(TenderResponse.class)
        .collectList();
  }
}
