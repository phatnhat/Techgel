package com.techgel.common.DTOs;

import java.time.LocalDateTime;

import com.techgel.common.entity.enums.NewsType;

public class NewsDTO {
    private String id;
    private String title;
    private NewsType type;
    private String summary;
    private String imageUrl;
    private LocalDateTime publishedAt;

    public NewsDTO() {
    }

    public NewsDTO(String id, String title, NewsType type, String summary, String imageUrl, LocalDateTime publishedAt) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.summary = summary;
        this.imageUrl = imageUrl;
        this.publishedAt = publishedAt;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public NewsType getType() {
        return type;
    }

    public void setType(NewsType type) {
        this.type = type;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }
}