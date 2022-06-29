package com.example.respository;

import com.example.entity.Auditable;

import java.io.Serializable;

public interface GenericCrudRepository<M extends Auditable, K extends Serializable>
        extends GenericRepository<M,K> {
    K create(M model);

    void update(M model);

    void delete(K id);
}
