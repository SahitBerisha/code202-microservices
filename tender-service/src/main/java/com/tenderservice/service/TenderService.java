package com.tenderservice.service;

import com.tenderservice.dto.TenderMapper;
import com.tenderservice.dto.TenderRequest;
import com.tenderservice.dto.TenderResponse;
import com.tenderservice.repository.TenderRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TenderService {

  private final TenderRepository repository;
  private final TenderMapper mapper;

  @Transactional
  public void create(TenderRequest request) {
    repository.save(mapper.map(request));
  }

  @Transactional(readOnly = true)
  public List<TenderResponse> getAll() {
    return repository.findAll().stream()
        .map(mapper::map)
        .toList();
  }

  @Transactional(readOnly = true)
  public TenderResponse getOne(UUID id) {
    return repository.findById(id)
        .map(mapper::map)
        .orElseThrow();
  }

  @Transactional(readOnly = true)
  public List<TenderResponse> getActiveTenders() {
    return repository.getActiveTenders().stream()
        .map(mapper::map)
        .toList();
  }
}
