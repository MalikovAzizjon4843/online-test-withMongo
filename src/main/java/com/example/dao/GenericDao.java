package com.example.dao;

import com.example.configs.ApplicationContextHolder;
import com.example.criteria.GenericCriteria;
import com.example.entity.Auditable;
import com.example.respository.AbstractRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * THIS IS A BASE ABSTRACT CLASS THAT PROVIDES CONNECTION WITH MONGO DB
 *
 * @param <C> -> Criteria
 * @param <M> -> Collection
 */
public abstract class GenericDao<C extends GenericCriteria, M extends Auditable> extends AbstractRepository {
    protected MongoDatabase db = ApplicationContextHolder.getBean(MongoDatabase.class);
    protected MongoCollection<M> collection;

    public GenericDao(Class<M> clazz) {
        this.collection = db.getCollection(clazz.getSimpleName(), clazz);
    }
}
