package com.tenderservice.dto;

import com.tenderservice.model.Tender;
import java.time.Instant;
import org.springframework.stereotype.Component;

@Component
public class TenderMapper {

  public Tender map(TenderRequest request) {
    var tender = new Tender();
    tender.setTitle(request.title());
    tender.setDescription(request.description());
    tender.setStatus(request.status());
    tender.setBudget(request.budget());
    tender.setDeadline(request.deadline());
    return tender;
  }

  public TenderResponse map(Tender tender) {
    return TenderResponse.builder()
        .id(tender.getId())
        .createdAt(tender.getCreatedAt())
        .updatedAt(tender.getUpdatedAt())
        .title(tender.getTitle())
        .description(tender.getDescription())
        .status(tender.getStatus())
        .deadline(tender.getDeadline())
        .budget(tender.getBudget())
        .build();
  }
}
