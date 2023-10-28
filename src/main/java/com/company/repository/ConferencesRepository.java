package com.company.repository;

import com.company.entity.Conferences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferencesRepository extends JpaRepository<Conferences,Long> {
}
