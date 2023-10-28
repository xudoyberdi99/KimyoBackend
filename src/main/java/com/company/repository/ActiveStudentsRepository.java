package com.company.repository;

import com.company.entity.ActiveStudents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiveStudentsRepository extends JpaRepository<ActiveStudents,Long> {
}
