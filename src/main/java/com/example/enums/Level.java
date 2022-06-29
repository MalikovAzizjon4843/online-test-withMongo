package com.example.enums;

import lombok.Getter;

@Getter
public enum Level {
    EASY, MEDIUM, HARD;



    public static Level getLevel(String val){
        for (Level value : values()) {
            if (value.name().equalsIgnoreCase(val)) return value;
        }
        return EASY;
    }
}
