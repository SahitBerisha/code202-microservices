package com.bidservice.controller;

import static org.springframework.http.HttpStatus.CREATED;

import com.bidservice.dto.BidRequest;
import com.bidservice.dto.BidResponse;
import com.bidservice.dto.TenderResponse;
import com.bidservice.service.BidService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Tag(name = "Bids")
@RequestMapping("/api/v1/bids")
public class BidController {

  private static final Logger log = LoggerFactory.getLogger(BidController.class);
  private final BidService service;

  public BidController(BidService service) {
    this.service = service;
  }

  @PostMapping("/{id}")
  @Operation(summary = "Creates a Bid with Tender ID")
  public ResponseEntity<BidResponse> create(@RequestBody BidRequest request, @PathVariable UUID id) {
    var response = service.create(request, id);
    log.debug("REST request to create a Bid : {}", request);
    return ResponseEntity.status(CREATED).body(response);
  }

  @GetMapping
  @Operation(summary = "Retrieves all active Tenders")
  public ResponseEntity<Mono<List<TenderResponse>>> getAllActive() {
    log.debug("REST request to get all active Tenders");
    return ResponseEntity.ok(service.getAllActiveTenders());
  }
}
