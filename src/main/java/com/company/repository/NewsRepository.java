package com.company.repository;

import com.company.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News,Long> {

    List<News> findAllByCategory_Id(Long categoryId);

}
