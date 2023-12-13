package com.company.repository;

import com.company.entity.ActiveStudents;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActiveStudentsRepository extends JpaRepository<ActiveStudents,Long> {
    @Query(value = "select * from students where status='UQIMOQDA'", nativeQuery = true)
    Page<ActiveStudents> allStudent(Pageable pageable);

    @Query(value = "select * from students where status='BITIRGAN'", nativeQuery = true)
    Page<ActiveStudents> allgraduated(Pageable pageable);

    Page<ActiveStudents> findAllByCategory_Id(Long categoryId,Pageable pageable);

}
