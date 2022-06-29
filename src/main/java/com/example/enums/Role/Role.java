package com.example.enums.Role;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN, TEACHER, STUDENT;

    public static Role getByName(String role) {
        for (Role value : values()) {
            if (value.name().equalsIgnoreCase(role)) return value;
        }
        return Role.STUDENT;
    }
}
