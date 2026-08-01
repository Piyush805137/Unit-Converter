package com.example.unitconverter.models;

public class Category {
    private String name;
    private int iconRes;
    private int startColor;
    private int endColor;
    private int unitCount;

    public Category(String name, int iconRes, int startColor, int endColor, int unitCount) {
        this.name = name;
        this.iconRes = iconRes;
        this.startColor = startColor;
        this.endColor = endColor;
        this.unitCount = unitCount;
    }

    public String getName() { return name; }
    public int getIconRes() { return iconRes; }
    public int getStartColor() { return startColor; }
    public int getEndColor() { return endColor; }
    public int getUnitCount() { return unitCount; }
}