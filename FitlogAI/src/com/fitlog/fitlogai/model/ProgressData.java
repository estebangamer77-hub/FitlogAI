package com.fitlog.fitlogai.model;

public class ProgressData {

    private double weight;
    private double height;
    private double bodyFat;
    private String month;

    public ProgressData(double weight, double height, double bodyFat, String month) {
        this.weight = weight;
        this.height = height;
        this.bodyFat = bodyFat;
        this.month = month;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double getBodyFat() {
        return bodyFat;
    }

    public String getMonth() {
        return month;
    }
}