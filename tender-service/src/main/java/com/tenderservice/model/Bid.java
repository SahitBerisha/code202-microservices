package com.tenderservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import lombok.Data;

@Data
@Entity
@Table(name = "bids")
public class Bid extends BaseEntity {

  @Column(name = "description")
  private String description;

  @JoinColumn(name = "tender_id")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private Tender tender;

  @NotBlank
  @Column(name = "amount")
  private BigDecimal amount;
}
