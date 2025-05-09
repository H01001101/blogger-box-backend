package com.dauphine.blogger.dto;

import com.dauphine.blogger.ElementRequest;

public class UpdateCategoryRequest extends ElementRequest {
    public UpdateCategoryRequest() {
    }

    public UpdateCategoryRequest(String title, String description) {
        this.setTitle(title);
        this.setDescription(description);
    }
}
