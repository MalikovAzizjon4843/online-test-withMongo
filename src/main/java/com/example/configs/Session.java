package com.example.configs;

import com.example.entity.auth.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Session {
    public static User sessionUser;
}
