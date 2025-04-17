package com.tenderservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.Instant;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tenders")
public class Tender extends BaseEntity {

  @NotBlank
  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "description")
  private String description;

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private Status status;

  @Future
  @Column(name = "deadline")
  private Instant deadline;

  @Column(name = "budget")
  private BigDecimal budget;

  public enum Status {
    OPEN, CLOSED, CANCELLED, AWARDED
  }
}
