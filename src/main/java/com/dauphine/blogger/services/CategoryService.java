package com.dauphine.blogger.services;

import com.dauphine.blogger.models.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<Category> getAll();

    List<Category> findAllLikeName(String name);

    Category getById(UUID Id);

    Category create(String name);

    Category updateName(UUID Id, String name);

    boolean deleteById(UUID Id);
}
