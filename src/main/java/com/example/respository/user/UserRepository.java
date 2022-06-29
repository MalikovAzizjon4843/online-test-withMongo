package com.example.respository.user;

import com.example.criteria.GenericCriteria;
import com.example.dao.GenericDao;
import com.example.entity.auth.User;
import com.example.enums.Role.Role;
import com.example.respository.GenericCrudRepository;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository extends GenericDao<GenericCriteria, User> implements
        GenericCrudRepository<User, ObjectId> {

    public UserRepository(Class<User> clazz) {
        super(clazz);
    }

    @Override
    public ObjectId create(User model) {
        collection.insertOne(model);
        return model.getId();
    }

    @Override
    public void update(User model) {
        collection.updateOne(Filters.eq("_id", model.getId()), Updates.combine());
    }

    @Override
    public void delete(ObjectId id) {
        collection.updateOne(Filters.eq("_id",id),Updates.set("deleted",true));
    }

    @Override
    public List<User> list() {
        List<User> users = new ArrayList<>();
        collection.find().iterator().forEachRemaining(users::add);
        return users;
    }

    @Override
    public Optional<User> get(ObjectId id) {
        User user = collection.find(Filters.eq("_id", id)).first();
        return Optional.of(user);
    }

    public void updateRole(ObjectId id) {
        collection.updateOne(Filters.eq("_id",id),Updates.set("role", Role.TEACHER));
    }
}
