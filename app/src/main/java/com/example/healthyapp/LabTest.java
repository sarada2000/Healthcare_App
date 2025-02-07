package com.example.healthyapp;

public class LabTest {
    private final String name;
    private final int imageResId;

    public LabTest(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
}
