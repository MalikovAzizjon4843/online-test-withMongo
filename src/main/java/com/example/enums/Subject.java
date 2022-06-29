package com.example.enums;

import lombok.Getter;

@Getter
public enum Subject {
    MATH("Math"), ENGLISH("English"), UNDERFINED("Shunchaki");
    private final String des;

    Subject(String des) {
        this.des = des;
    }
    public static Subject getValue(String name){
        for (Subject value : values()) {
            if (value.name().equalsIgnoreCase(name) || value.des.equalsIgnoreCase(name)) return value;
        }
        return UNDERFINED;
    }
}
