package com.example.ui;

import com.example.configs.ApplicationContextHolder;
import com.example.dto.user.UserCreateDto;
import com.example.services.auth.AuthService;
import com.example.utils.Input;

public class AuthUI {
    private static final AuthService service = ApplicationContextHolder.getBean(AuthService.class);

    public static void register() {
        String name = Input.getStr("Enter name : ");
        String pass = Input.getStr("Enter password : ");
        String lan = Input.getStr("Enter language : ");
        UserCreateDto user = UserCreateDto.builder().username(name).password(pass).language(lan).role("USER").build();
        service.register(user);
    }

    public static void login() {
        String name = Input.getStr("Enter name : ");
        String pass = Input.getStr("Enter password : ");
        service.login(name,pass);
    }



}
