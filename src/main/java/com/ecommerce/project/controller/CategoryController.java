package com.ecommerce.project.controller;

import com.ecommerce.project.config.AppConstants;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Category APIs", description = "APIs for managing categories")
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //GetMapping added to method and stating an endpoint for the API
    //@RequestMapping(value = "/public/categories", method = RequestMethod.GET)
    @Operation(summary = "Get all categories", description = "Endpoint to get all categories")
    @GetMapping("public/categories")
    public ResponseEntity<CategoryResponse> getAllCategories(
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy",  defaultValue = AppConstants.SORT_CATEGORIES_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder",  defaultValue = AppConstants.SORT_DIR, required = false) String sortOrder
    ) {
        CategoryResponse categoryResponse = categoryService.getAllCategories(pageNumber, pageSize, sortBy, sortOrder);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    //PostMapping used in pair with RequestPost: PostMapping annotate the metho as POST and RequestBody annotate the variable parameter as a request for the usage of the POST method
    //@RequestMapping(value = "/admin/categories", method = RequestMethod.POST)
    @Operation(summary = "Create a new category", description = "Endpoint to create a new category")
    @PostMapping("admin/categories")
    // Both annotations should be used together at once as to validate data provided in posting methods
    public ResponseEntity<CategoryDTO> createCategory(
            @Valid @RequestBody CategoryDTO categoryDTO) {

        categoryDTO = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);
    }

    //@RequestMapping(value = "/admin/categories/{categoryId}", method = RequestMethod.DELETE)
    @Operation(summary = "Delete a category", description = "Endpoint to delete a category")
    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> deleteCategory(
            @Parameter(description = "Input the ID from the category that you wish to delete.")
            @PathVariable Long categoryId) {
        CategoryDTO deletedCategory = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(deletedCategory, HttpStatus.OK);
    }

    //@RequestMapping(value = "/admin/categories/{categoryId}", method = RequestMethod.PUT)
    @Operation(summary = "Update a category", description = "Endpoint to update a category")
    @PutMapping("/admin/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(
            @Valid @RequestBody CategoryDTO categoryDTO,
            @Parameter(description = "Input the ID from the category you wish to update")
            @PathVariable Long categoryId) {

        categoryDTO = categoryService.updateCategory(categoryDTO, categoryId);
        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);

    }
}
