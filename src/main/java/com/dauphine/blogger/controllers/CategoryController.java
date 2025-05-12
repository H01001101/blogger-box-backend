package com.dauphine.blogger.controllers;

import com.dauphine.blogger.ElementRequest;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Category> retrieveAllCategories() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Category retrieveCategoryById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public Category createCategory(@RequestBody String name) {
        return service.create(name);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable UUID id, @RequestBody String name) {
        return service.updateName(id, name);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCategory(@PathVariable UUID id) {
        return service.deleteById(id);
    }
}
