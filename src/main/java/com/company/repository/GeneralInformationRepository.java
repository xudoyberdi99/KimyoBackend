package com.company.repository;

import com.company.entity.GeneralInformation;
import com.company.entity.GeneralPage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeneralInformationRepository extends JpaRepository<GeneralInformation,Long> {
}
