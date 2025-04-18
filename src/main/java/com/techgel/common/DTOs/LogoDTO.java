package com.techgel.common.DTOs;

public class LogoDTO {
    private String id;
    private String name;              // Client or partner name
    private String imageUrl;          // URL or path to the logo image
    private String altText;           // Alternative text for accessibility
    private int displayOrder;         // For sorting or arranging logos

    // Constructors

    public LogoDTO(String id, String name, String imageUrl, String altText, int displayOrder) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.altText = altText;
        this.displayOrder = displayOrder;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
}

