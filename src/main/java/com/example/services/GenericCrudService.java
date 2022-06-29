package com.example.services;


import com.example.dto.GenericBaseDto;
import com.example.dto.GenericDto;
import com.example.entity.Auditable;
import com.example.response.Data;
import com.example.response.ResponseEntity;

import java.io.Serializable;

/**
 * @param <M>
 * @param <CD>
 * @param <UD>
 * @param <K>
 */
public interface GenericCrudService<M extends Auditable, CD extends GenericBaseDto, UD extends GenericDto, K extends Serializable> extends GenericService<M, K> {
    ResponseEntity<Data<K>> create(CD dto);

    ResponseEntity<Data<Void>> update(UD dto);

    ResponseEntity<Data<Void>> delete(K id);
}
