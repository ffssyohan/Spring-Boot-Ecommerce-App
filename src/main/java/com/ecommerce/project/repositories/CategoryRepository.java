package com.ecommerce.project.repositories;

import com.ecommerce.project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

// no implementation class necessary as Spring JPA will implement this interfaction in execution
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
