package com.company.repository;

import com.company.entity.GeneralPage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeneralPageRepository extends JpaRepository<GeneralPage, Long> {
    List<GeneralPage> findAllByCategory_Id(Long categoryid);
}
