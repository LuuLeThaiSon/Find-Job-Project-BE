package com.example.findjobbe.repository;

import com.example.findjobbe.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "select * from category c join category_job cj on c.id = cj.category_id join job j on cj.job_id = j.id where j.id = ?1", nativeQuery = true)
    List<Category> findCategoriesByJobId(Long id);

    @Query(value = "select category.id,category.name from category join category_company cc on category.id = cc.category_id join company c on c.id = cc.company_id where company_id = ?1",nativeQuery = true)
    List<Category>findCategoriesByCompanyId(Long id);

    @Query(value = "select c from Category c ORDER BY c.name ASC")
    List<Category>findAllCategoriesOrderByNameAsc();
}
