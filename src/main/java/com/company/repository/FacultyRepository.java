package com.company.repository;

import com.company.entity.Facultys;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Facultys,Long> {
}
