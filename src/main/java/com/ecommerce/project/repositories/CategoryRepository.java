package com.ecommerce.project.repositories;

import com.ecommerce.project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

// no implementation class necessary as Spring JPA will implement this interfaction in execution
// unless creating customized queries, like findByCategoryName. JPA analyzes the name of the category and implements it in runtime
// for that, method names should follow a convention: using findBy tells JPA to use WHERE keyword to build a query that filters the result by something that has to have the exact same name of the field we are using as a filter
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByCategoryName(String categoryName);
}
