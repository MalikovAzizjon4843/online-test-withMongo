package com.example.utils.validator;

import org.bson.types.ObjectId;
import com.example.dto.user.UserCreateDto;
import com.example.dto.user.UserUpdateDto;
import com.example.utils.BaseUtils;

public class UserValidator extends BaseValidator<UserCreateDto, UserUpdateDto, ObjectId> {

    public UserValidator(BaseUtils utils) {
        super(utils);
    }

    @Override
    public void validKey(ObjectId key) throws IllegalArgumentException {

    }

    @Override
    public void validOnCreate(UserCreateDto dto) throws IllegalArgumentException {

    }

    @Override
    public void validOnUpdate(UserUpdateDto dto) throws IllegalArgumentException {

    }
}
