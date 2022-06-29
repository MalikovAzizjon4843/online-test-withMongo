package com.example.mappers.UserMapper;

import com.example.dto.GenericDto;
import com.example.dto.user.UserCreateDto;
import com.example.dto.user.UserUpdateDto;
import com.example.entity.auth.User;
import com.example.enums.Language.Language;
import com.example.enums.Role.Role;
import com.example.enums.Status.Status;
import com.example.mappers.GenericMapper;

public class UserMapper implements GenericMapper<User, GenericDto, UserCreateDto, UserUpdateDto> {
    @Override
    public User fromDto(GenericDto dto) {
        return null;
    }

    @Override
    public User fromCreateDto(UserCreateDto dto) {
        return User.childBuilder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .role(Role.getByName(dto.getRole()))
                .status(Status.NO_ACTIVE)
                .language(Language.getByCode(dto.getLanguage()))
                .build();
    }

    @Override
    public User fromUpdateDto(UserUpdateDto dto) {
        return null;
    }

    @Override
    public GenericDto toDto(User model) {
        return null;
    }
}
