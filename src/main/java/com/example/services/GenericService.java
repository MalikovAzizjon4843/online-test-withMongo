package com.example.services;

import com.example.entity.Auditable;
import com.example.response.Data;
import com.example.response.ResponseEntity;

import java.io.Serializable;
import java.util.List;

public interface GenericService<M extends Auditable, K extends Serializable> {
    ResponseEntity<Data<M>> get(K id);

    ResponseEntity<Data<List<M>>> getList();
}
