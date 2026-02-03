package com.ecommerce.project.controller;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    //GetMapping added to method and stating an endpoint for the API
//    @RequestMapping(value = "/public/categories", method = RequestMethod.GET)
    @GetMapping("public/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    //PostMapping used in pair with RequestPost: PostMapping annotate the metho as POST and RequestBody annotate the variable parameter as a request for the usage of the POST method
//    @RequestMapping(value = "/admin/categories", method = RequestMethod.POST)
    @PostMapping("admin/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category) {

        categoryService.createCategory(category);
        return new ResponseEntity<>("Category added successfully", HttpStatus.CREATED);
    }

    //@RequestMapping(value = "/admin/categories/{categoryId}", method = RequestMethod.DELETE)
    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        try {
            String status = categoryService.deleteCategory(categoryId);
            // 3 different ways of throwing response code exception:

            // 1 - return new ResponseEntity<>(status, HttpStatus.OK);
            // 2 - return ResponseEntity.ok(status);
            /* 3 - */
            return ResponseEntity.status(HttpStatus.OK).body(status);
            //ResponseStatusException for returning a message to the client with the status code
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());

        }
    }

    //    @RequestMapping(value = "/admin/categories/{categoryId}", method = RequestMethod.PUT)
    @PutMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category, @PathVariable Long categoryId) {
        try {
            Category savedCategory = categoryService.updateCategory(category, categoryId);
            return new ResponseEntity<>("Category name with category id: " + categoryId + " successfully updated to " + savedCategory.getCategoryName(), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }
}
