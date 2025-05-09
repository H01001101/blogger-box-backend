package com.dauphine.blogger.controllers;

import com.dauphine.blogger.ElementRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    @GetMapping
    @Operation(summary = "Get all categories", description = "Returns a list of all categories")
    public String getAllCategories() {
        // TODO LATER, implement persistence layer
        //  SELECT * FROM categories
        return "Get all categories";
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get category by ID", description = "Returns a single category by its ID")
    public String getCategoryById(
            @Parameter(description = "ID of the category to retrieve") @PathVariable UUID id) {
        // TODO LATER, implement persistence layer
        //  SELECT * FROM categories WHERE id = ${id}
        return "Get category with ID '%s'".formatted(id);
    }

    @PostMapping
    @Operation(summary = "Create a new category", description = "Creates a new category")
    public String createCategory(@Parameter(description = "Category to create") @RequestBody ElementRequest request) {
        // TODO LATER, implement persistence layer
        //  INSERT INTO categories (title, description) VALUES (${title}, ${description})
        return "Create category with title '%s' and description '%s'".formatted(request.getTitle(), request.getDescription());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing category", description = "Updates an existing category by its ID")
    public String updateCategory(
            @Parameter(description = "ID of the category to update") @PathVariable UUID id,
            @Parameter(description = "Updated category data") @RequestBody ElementRequest request) {
        // TODO LATER, implement persistence layer
        //  UPDATE categories SET title = ${title}, description = ${description} WHERE id = ${id}
        return "Update category '%s' with title '%s' and description '%s'".formatted(id, request.getTitle(), request.getDescription());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a category", description = "Deletes a category by its ID")
    public String deleteCategory(
            @Parameter(description = "ID of the category to delete") @PathVariable UUID id) {
        // TODO LATER, implement persistence layer
        //  DELETE FROM categories WHERE id = ${id}
        return "Delete category with ID '%s'".formatted(id);
    }
}
