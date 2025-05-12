package com.dauphine.blogger.controllers;

import com.dauphine.blogger.ElementRequest;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/posts")
public class PostController {


    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<Post> getAllByCategoryId(UUID categoryId) {
        return service.getAllByCategoryId(categoryId);
    }

    @GetMapping
    public List<Post> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public Post create(@RequestBody String title, @RequestBody String content, @RequestBody Category category) {
        return service.create(title, content, category);
    }

    @PutMapping("/{id}")
    public Post update(@PathVariable UUID id, @RequestBody String title, @RequestBody String content) {
        return service.update(id, title, content);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable UUID id) {
        return service.deleteById(id);
    }
}
