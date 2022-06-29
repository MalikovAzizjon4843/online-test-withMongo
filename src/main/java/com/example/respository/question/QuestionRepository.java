package com.example.respository.question;

import com.example.criteria.GenericCriteria;
import com.example.dao.GenericDao;
import com.example.entity.quiz.Question;
import com.example.respository.GenericCrudRepository;
import com.mongodb.client.model.Filters;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class QuestionRepository  extends GenericDao<GenericCriteria, Question> implements
        GenericCrudRepository<Question, ObjectId> {
    public QuestionRepository(Class<Question> clazz) {
        super(clazz);
    }


    @Override
    public ObjectId create(Question model) {
        collection.insertOne(model);
        return model.getId();
    }

    @Override
    public void update(Question model) {

    }

    @Override
    public void delete(ObjectId id) {

    }

    @Override
    public List<Question> list() {
        List<Question> quizzes = new ArrayList<>();
        collection.find().iterator().forEachRemaining(quizzes::add);
        return quizzes;
    }

    @Override
    public Optional<Question> get(ObjectId id) {
        Question question = collection.find(Filters.eq("_id", id)).first();
        return Objects.isNull(question) ? Optional.empty() : Optional.of(question);
    }
}