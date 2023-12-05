package com.company.repository;

import com.company.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "select * from category c where c.parent_id is null", nativeQuery = true)
    List<Category> parentCategorys();

    List<Category> findAllByParent_Id(Long parentId);
}
