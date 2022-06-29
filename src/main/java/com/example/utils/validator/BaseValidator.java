package com.example.utils.validator;

import com.example.dto.GenericBaseDto;
import com.example.dto.GenericDto;
import com.example.utils.BaseUtils;

import java.io.Serializable;

/**
 * @param <CD> -> Create DTO
 * @param <UD> -> Update DTO
 * @param <K>  -> Identity KEY
 */
public abstract class BaseValidator<
        CD extends GenericBaseDto,
        UD extends GenericDto,
        K extends Serializable> extends
        AbstractValidator<K> {

    protected BaseValidator(BaseUtils utils) {
        super(utils);
    }

    protected abstract void validOnCreate(CD dto) throws IllegalArgumentException;

    protected abstract void validOnUpdate(UD dto) throws IllegalArgumentException;

}
