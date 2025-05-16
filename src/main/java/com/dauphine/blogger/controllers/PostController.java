package com.dauphine.blogger.controllers;

import com.dauphine.blogger.dto.CreationPostRequest;
import com.dauphine.blogger.dto.UpdatePostRequest;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.CategoryService;
import com.dauphine.blogger.services.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/posts")
public class PostController {

    private final PostService service;
    private final CategoryService categoryService;

    public PostController(PostService service, CategoryService categoryService) {
        this.service = service;
        this.categoryService = categoryService;
    }

    @GetMapping
    @Operation(summary = "Get all posts", description = "Returns a list of all posts")
    public ResponseEntity<List<Post>> getAllPosts(@RequestParam(required = false) String value) {
        List<Post> posts = value == null || value.isBlank()
                ? service.getAll()
                : service.getAllByTitleOrContent(value);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get post by ID", description = "Returns a single post by its ID")
    public ResponseEntity<Post> getPostById(
            @Parameter(description = "ID of the post to retrieve") @PathVariable UUID id) {
        Post post = service.getById(id);
        if (post == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(post);
    }

    @PostMapping
    @Operation(summary = "Create a new post", description = "Creates a new post")
    public ResponseEntity<Post> createPost(@RequestBody CreationPostRequest request) {
        Category category = categoryService.findByName(request.getCategoryTitle());
        if (category == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Post createdPost = service.create(
                request.getTitle(),
                request.getContent(),
                category,
                request.getCreatedDate()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing post", description = "Updates an existing post by its ID")
    public ResponseEntity<Post> updatePost(
            @Parameter(description = "ID of the post to update") @PathVariable UUID id,
            @Parameter(description = "Updated post data") @RequestBody UpdatePostRequest request) {
        Post updatedPost = service.update(id, request.getTitle(), request.getContent());
        if (updatedPost == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedPost);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a post", description = "Deletes a post by its ID")
    public ResponseEntity<Void> deletePost(
            @Parameter(description = "ID of the post to delete") @PathVariable UUID id) {
        boolean deleted = service.deleteById(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.noContent().build();
    }
}
