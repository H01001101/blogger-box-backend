package com.dauphine.blogger.services;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.repositories.CategoryRepository;
import com.dauphine.blogger.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repository;
    private final CategoryRepository categoryRepository;

    public PostServiceImpl(PostRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Post> getAllByCategoryId(UUID categoryId) {
        return repository.findByCategory_Id(categoryId);
    }

    @Override
    public List<Post> getAll() {return repository.findAll();}

    @Override
    public Post getById(UUID id) {
        return repository.findById(id)
                .orElse(null);
    }

    @Override
    public Post create(String title, String content, Category category, LocalDateTime createdDate) {
        Post post = new Post(content, title, category);
        post.setCreatedDate(createdDate != null ? createdDate : LocalDateTime.now());
        return repository.save(post);
    }

    @Override
    public Post update(UUID id, String newTitle, String newContent) {
        Post post = getById(id);
        if (post == null) {
            return null;
        }
        post.setTitle(newTitle);
        post.setContent(newContent);
        return repository.save(post);
    }

    @Override
    public boolean deleteById(UUID id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Post> getAllByTitleOrContent(String value) {
        return repository.findAllByTitleOrContent(value);
    }
}
