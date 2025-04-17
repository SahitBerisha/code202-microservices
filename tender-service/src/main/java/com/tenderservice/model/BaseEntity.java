package com.tenderservice.model;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@MappedSuperclass
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

  @Id
  @UuidGenerator(style = Style.TIME)
  @Column(name = "id", nullable = false, updatable = false, length = 36)
  private UUID id;

  @CreatedDate
  @Column(name = "created_at", nullable = false, updatable = false)
  private Instant createdAt;

  @LastModifiedDate
  @Column(name = "updated_at", nullable = false)
  private Instant updatedAt;

  protected BaseEntity(UUID id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (isNull(other) || !(getClass().isInstance(other))) {
      return false;
    }
    var entity = (BaseEntity) other;
    return nonNull(id) && id.equals(entity.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

