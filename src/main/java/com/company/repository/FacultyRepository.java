package com.company.repository;

import com.company.entity.Facultys;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Facultys,Long> {
    List<Facultys> findAllByCategory_Id(Long categoryId);
}
