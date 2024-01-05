package com.company.repository;

import com.company.entity.Leadership;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LeadershipRepository extends JpaRepository<Leadership,Long> {

    Boolean existsByEmail(String email);
    Boolean existsByEmailAndIdNot(String email, Long id);
    @Query(value = "select * from leadership where leadership_status='RAHBARIYAT'", nativeQuery = true)
    List<Leadership> allLeadershipRahbariyat();
    @Query(value = "select * from leadership where leadership_status='DEKANAT'", nativeQuery = true)
    List<Leadership> findAllByLeadershipStatus_Dekanat();
    @Query(value = "select * from leadership where leadership_status='KAFEDRA'", nativeQuery = true)
    List<Leadership> findAllByLeadershipStatus_Kafedra();

}
