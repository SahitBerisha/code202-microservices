package com.tenderservice.controller;

import com.tenderservice.dto.TenderRequest;
import com.tenderservice.dto.TenderResponse;
import com.tenderservice.service.TenderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "Tenders")
@RequestMapping("/api/v1/tenders")
public class TenderController {

  private final TenderService service;

  @PostMapping
  @Operation(summary = "Creates a Tender", tags = "Tenders")
  public ResponseEntity<Void> create(@RequestBody TenderRequest request) {
    log.debug("REST request to save a Tender : {}", request);
    service.create(request);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping
  @Operation(summary = "Retrieves all Tenders", tags = "Tenders")
  public ResponseEntity<List<TenderResponse>> getAll() {
    log.debug("REST request to get all Tenders");
    return ResponseEntity.ok(service.getAll());
  }

  @GetMapping("/{id}")
  @Operation(summary = "Retrieves a Tender by ID", tags = "Tenders")
  public ResponseEntity<TenderResponse> getOne(@PathVariable UUID id) {
    log.debug("REST request to get a Tender by id : {}", id);
    return ResponseEntity.ok(service.getOne(id));
  }

  @GetMapping("/active")
  @Operation(summary = "Retrieves all active Tenders", tags = "Tenders")
  public ResponseEntity<List<TenderResponse>> getActiveTenders() {
    log.debug("REST request to get active Tenders");
    return ResponseEntity.ok(service.getActiveTenders());
  }
}
