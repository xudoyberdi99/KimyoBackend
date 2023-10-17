package com.company.repository;

import com.company.entity.InteraktivService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteractiveServiceRepository extends JpaRepository<InteraktivService, Long> {
}
