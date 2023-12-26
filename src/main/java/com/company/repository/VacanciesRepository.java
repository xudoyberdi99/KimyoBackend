package com.company.repository;

import com.company.entity.Vacancies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacanciesRepository extends JpaRepository<Vacancies,Long> {
}
