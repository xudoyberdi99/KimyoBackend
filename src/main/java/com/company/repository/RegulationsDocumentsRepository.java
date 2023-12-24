package com.company.repository;

import com.company.entity.RegulatoryDocuments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegulationsDocumentsRepository extends JpaRepository<RegulatoryDocuments,Long> {
}
