package com.company.repository;

import com.company.entity.Announcements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcements,Long> {
}
