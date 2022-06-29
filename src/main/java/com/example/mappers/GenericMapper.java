package com.example.mappers;

public interface GenericMapper<M, D, CD, UD> extends GenericBaseMapper{
    M fromDto(D dto);

    M fromCreateDto(CD dto);

    M fromUpdateDto(UD dto);

    D toDto(M model);
}
