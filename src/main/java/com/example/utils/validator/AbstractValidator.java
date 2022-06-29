package com.example.utils.validator;

import com.example.utils.BaseUtils;

import java.io.Serializable;

public abstract class AbstractValidator<K extends Serializable> {
    protected final BaseUtils utils;

    protected AbstractValidator(BaseUtils utils) {
        this.utils = utils;
    }

    protected abstract void validKey(K key) throws IllegalArgumentException;

}
