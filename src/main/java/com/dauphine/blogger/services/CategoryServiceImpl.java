package com.dauphine.blogger.services;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> getAll() {return repository.findAll();}

    @Override
    public Category getById(UUID id) {
        return repository.findById(id)
                .orElse(null);
    }

    @Override
    public Category create(String name) {
        Category category = new Category(name);
        return repository.save(category);
    }

    @Override
    public Category updateName(UUID id, String name) {
        Category category = getById(id);
        if (category == null) {
            return null;
        }
        category.setTitle(name);
        return repository.save(category);
    }

    @Override
    public boolean deleteById(UUID id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Category> findAllLikeName(String name) {
        return repository.findAllLikeName(name);
    }

    @Override
    public Category findByName(String name) {
        return repository.findByName(name).orElse(null);
    }
}
