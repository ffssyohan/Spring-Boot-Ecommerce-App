package com.ecommerce.project.controller;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //GetMapping added to method and stating an endpoint for the API
    //@RequestMapping(value = "/public/categories", method = RequestMethod.GET)
    @GetMapping("public/categories")
    public ResponseEntity<CategoryResponse> getAllCategories() {
        CategoryResponse categoryResponse = categoryService.getAllCategories();
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    //PostMapping used in pair with RequestPost: PostMapping annotate the metho as POST and RequestBody annotate the variable parameter as a request for the usage of the POST method
//    @RequestMapping(value = "/admin/categories", method = RequestMethod.POST)
    @PostMapping("admin/categories")
    // Both annotations should be used together at once as to validate data provided in posting methods
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {

        categoryDTO = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);
    }

    //@RequestMapping(value = "/admin/categories/{categoryId}", method = RequestMethod.DELETE)
    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        String status = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    //    @RequestMapping(value = "/admin/categories/{categoryId}", method = RequestMethod.PUT)
    @PutMapping("/admin/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable Long categoryId) {

        categoryDTO = categoryService.updateCategory(categoryDTO, categoryId);
        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }
}
