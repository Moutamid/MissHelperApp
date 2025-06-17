package com.moutamid.misshelper.model;

public class Item {
    private String name;
    private int imageResId;
    private String details;

    public Item(String name, int imageResId, String details) {
        this.name = name;
        this.imageResId = imageResId;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getDetails() {
        return details;
    }
}
