package com.company.repository;

import com.company.entity.AboutInstituti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AboutInstitutiRepository extends JpaRepository<AboutInstituti,Long> {

    Optional<AboutInstituti> findByCategory_Id(Long categoryid);
}
