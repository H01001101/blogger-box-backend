package com.dauphine.blogger.services;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public interface PostService {

    List<Post> getAllByCategoryId(UUID categoryId);

    List<Post> getAll();

    Post getById(UUID Id);

    Post create(String title, String content, Category category, LocalDateTime createdDate);

    Post update(UUID Id, String title, String content);

    boolean deleteById(UUID Id);

    List<Post> getAllByTitleOrContent(String value);
}
