package com.techgel.common.DTOs;

public class SignatureProjectDTO {
    private final String title;
    private final String imageUrl;
    private final String client;
    private final String location;
    private final String scope;
    private final String detailUrl;

    // Constructor
    public SignatureProjectDTO(String title, String imageUrl, String client, String location, String scope, String detailUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.client = client;
        this.location = location;
        this.scope = scope;
        this.detailUrl = detailUrl;
    }

    // Getters
    public String getTitle() { return title; }
    public String getImageUrl() { return imageUrl; }
    public String getClient() { return client; }
    public String getLocation() { return location; }
    public String getScope() { return scope; }
    public String getDetailUrl() { return detailUrl; }
}

