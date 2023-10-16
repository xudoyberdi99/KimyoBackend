package com.company.repository;

import com.company.entity.NewsDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsDayRepository extends JpaRepository<NewsDay,Long> {
}
