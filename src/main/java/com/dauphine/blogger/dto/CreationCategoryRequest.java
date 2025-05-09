package com.dauphine.blogger.dto;

import com.dauphine.blogger.ElementRequest;

public class CreationCategoryRequest extends ElementRequest {
    public CreationCategoryRequest() {
    }

    public CreationCategoryRequest(String title, String description) {
        this.setTitle(title);
        this.setDescription(description);
    }
}
