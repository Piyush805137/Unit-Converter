package com.example.unitconverter.models;

public class HistoryItem {
    private int id;
    private String category;
    private String fromUnit;
    private String toUnit;
    private String inputValue;
    private String outputValue;
    private String timestamp;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getFromUnit() { return fromUnit; }
    public void setFromUnit(String fromUnit) { this.fromUnit = fromUnit; }

    public String getToUnit() { return toUnit; }
    public void setToUnit(String toUnit) { this.toUnit = toUnit; }

    public String getInputValue() { return inputValue; }
    public void setInputValue(String inputValue) { this.inputValue = inputValue; }

    public String getOutputValue() { return outputValue; }
    public void setOutputValue(String outputValue) { this.outputValue = outputValue; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}