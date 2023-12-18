package com.company.repository;

import com.company.dto.AnnouncementDtoGet;
import com.company.entity.Announcements;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcements,Long> {
    List<Announcements> findAllByCategory_Id(Long categoryId);

}
