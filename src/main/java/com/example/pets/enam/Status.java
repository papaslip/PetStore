package com.example.pets.enam;

public enum Status {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold");
    private final String displayValue;

    private Status(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
