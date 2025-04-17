package com.tenderservice.repository;

import com.tenderservice.model.Tender;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface TenderRepository extends JpaRepository<Tender, UUID> {

  @Query("""
      SELECT t
      FROM Tender t
      WHERE t.status = 'OPEN'""")
  List<Tender> getActiveTenders();
}
