package com.dauphine.blogger.dto;

import java.util.Date;

public class UpdatePostRequest {
    private String title;
    private String content;
    private Date createdDate;
    private String categoryTitle;

    public UpdatePostRequest() {
    }

    public UpdatePostRequest(String title, String content, Date createdDate, String categoryTitle) {
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.categoryTitle = categoryTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }
}
