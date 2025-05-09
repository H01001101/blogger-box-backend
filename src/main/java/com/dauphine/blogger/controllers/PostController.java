package com.dauphine.blogger.controllers;

import com.dauphine.blogger.ElementRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/posts")
public class PostController {

    @GetMapping
    @Operation(summary = "Get all posts", description = "Returns a list of all posts")
    public String getAllPosts() {
        // TODO LATER, implement persistence layer
        //  SELECT * FROM posts
        return "Get all posts";
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get post by ID", description = "Returns a single post by its ID")
    public String getPostById(
            @Parameter(description = "ID of the post to retrieve") @PathVariable UUID id) {
        // TODO LATER, implement persistence layer
        //  SELECT * FROM posts WHERE id = ${id}
        return "Get post with ID '%s'".formatted(id);
    }

    @PostMapping
    @Operation(summary = "Create a new post", description = "Creates a new post")
    public String createPost(@Parameter(description = "Post to create") @RequestBody ElementRequest request) {
        // TODO LATER, implement persistence layer
        //  INSERT INTO posts (title, description) VALUES (${title}, ${description})
        return "Create post with title '%s' and description '%s'".formatted(request.getTitle(), request.getDescription());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing post", description = "Updates an existing post by its ID")
    public String updatePost(
            @Parameter(description = "ID of the post to update") @PathVariable UUID id,
            @Parameter(description = "Updated post data") @RequestBody ElementRequest request) {
        // TODO LATER, implement persistence layer
        //  UPDATE posts SET title = ${title}, description = ${description} WHERE id = ${id}
        return "Update post '%s' with title '%s' and description '%s'".formatted(id, request.getTitle(), request.getDescription());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a post", description = "Deletes a post by its ID")
    public String deletePost(
            @Parameter(description = "ID of the post to delete") @PathVariable UUID id) {
        // TODO LATER, implement persistence layer
        //  DELETE FROM posts WHERE id = ${id}
        return "Delete post with ID '%s'".formatted(id);
    }
}
