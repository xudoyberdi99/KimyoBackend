package com.company.repository;

import com.company.entity.InteraktivService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InteractiveServiceRepository extends JpaRepository<InteraktivService, Long> {

    List<InteraktivService> findAllByCategory_Id(Long categoryId);
}
