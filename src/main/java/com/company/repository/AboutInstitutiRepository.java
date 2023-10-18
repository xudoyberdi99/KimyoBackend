package com.company.repository;

import com.company.entity.AboutInstituti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutInstitutiRepository extends JpaRepository<AboutInstituti,Long> {
}
