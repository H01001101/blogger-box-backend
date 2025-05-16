package com.dauphine.blogger.controllers;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    @Operation(summary = "Get all categories", description = "Returns a list of all categories")
    public ResponseEntity<List<Category>> getAllCategories(@RequestParam(required = false) String name) {
        List<Category> categories = name == null || name.isBlank()
                ? service.getAll()
                : service.findAllLikeName(name);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get category by ID", description = "Returns a single category by its ID")
    public ResponseEntity<Category> getCategoryById(
            @Parameter(description = "ID of the category to retrieve") @PathVariable UUID id) {
        Category category = service.getById(id);
        if (category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(category);
    }

    @PostMapping
    @Operation(summary = "Create a new category", description = "Creates a new category")
    public ResponseEntity<Category> createCategory(@Parameter(description = "Category to create") @RequestBody Category category) {
        Category createdCategory = service.create(category.getTitle());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing category", description = "Updates an existing category by its ID")
    public ResponseEntity<Category> updateCategory(
            @Parameter(description = "ID of the category to update") @PathVariable UUID id,
            @Parameter(description = "Updated category data") @RequestBody Category categoryDetails) {
        Category updatedCategory = service.updateName(id, categoryDetails.getTitle());
        if (updatedCategory == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a category", description = "Deletes a category by its ID")
    public ResponseEntity<Void> deleteCategory(
            @Parameter(description = "ID of the category to delete") @PathVariable UUID id) {
        boolean deleted = service.deleteById(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.noContent().build();
    }
}
