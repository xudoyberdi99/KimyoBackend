package com.company.repository;

import com.company.entity.OpenData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpenDataRepository extends JpaRepository<OpenData,Long> {
}
