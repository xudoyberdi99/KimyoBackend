package com.company.repository;

import com.company.entity.Conferences;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferencesRepository extends JpaRepository<Conferences,Long> {
    Page<Conferences> findAllByCategory_Id(Long categroyId, Pageable pageable);
}
