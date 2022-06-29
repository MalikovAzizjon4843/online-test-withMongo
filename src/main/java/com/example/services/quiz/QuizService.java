package com.example.services.quiz;

import com.example.mappers.quiz.QuizMapper;
import com.example.services.question.QuestionMarkService;
import org.bson.types.ObjectId;
import com.example.configs.ApplicationContextHolder;
import com.example.dto.GenericDto;
import com.example.dto.quiz.QuizCreateDto;
import com.example.entity.quiz.QuestionMark;
import com.example.entity.quiz.Quiz;
import com.example.response.Data;
import com.example.response.ResponseEntity;
import com.example.respository.quiz.QuizRepository;
import com.example.services.AbstractService;
import com.example.services.GenericCrudService;

import java.util.List;

public class QuizService extends AbstractService<QuizRepository, QuizMapper> implements GenericCrudService<Quiz, QuizCreateDto, GenericDto, ObjectId> {

    private final QuestionMarkService questionMarkService = ApplicationContextHolder.getBean(QuestionMarkService.class);

    public QuizService(QuizRepository repository, QuizMapper mapper) {
        super(repository, mapper);
    }

   /* public List<Quiz> getList() {

    }*/

    @Override
    public ResponseEntity<Data<ObjectId>> create(QuizCreateDto quizDto) {
        List<QuestionMark> questionList = questionMarkService.getList(quizDto);
        Quiz quiz = Quiz.childBuilder().questionsMarks(questionList).
                id(new ObjectId()).language(quizDto.getLanguage()).
                subject(quizDto.getSubject()).level(quizDto.getLevel()).build();
        ObjectId quizId = repository.create(quiz);
        return new ResponseEntity<>(new Data<>(quizId));
    }

    @Override
    public ResponseEntity<Data<Void>> update(GenericDto dto) {
      //  repository.update(dto);
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> delete(ObjectId id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Quiz>> get(ObjectId id) {
        return new ResponseEntity<>(new Data<>(repository.get(id).get()));
    }

    @Override
    public ResponseEntity<Data<List<Quiz>>> getList() {
        return new ResponseEntity<>(new Data<>(repository.list()));
    }

    public Quiz startTest(QuizCreateDto quizDto) {

        return null;
    }

    public void update(Quiz quizN) {
        repository.update(quizN);
    }
}
