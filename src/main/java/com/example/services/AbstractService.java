package com.example.services;

import com.example.respository.AbstractRepository;
import com.example.mappers.GenericBaseMapper;

public class AbstractService<R extends AbstractRepository, MAP extends GenericBaseMapper> {

    protected final R repository;
    protected final MAP mapper;

    public AbstractService(R repository, MAP mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
