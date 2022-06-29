package com.example.services.question;

import com.example.configs.ApplicationContextHolder;
import com.example.dto.quiz.QuizCreateDto;
import com.example.entity.quiz.Question;
import com.example.entity.quiz.QuestionMark;

import java.util.ArrayList;
import java.util.List;

public class QuestionMarkService {

    private final QuestionService questionService = ApplicationContextHolder.getBean(QuestionService.class);

    public List<QuestionMark> getList(QuizCreateDto quizDto) {
        List<QuestionMark> questionMarks = new ArrayList<>();
        List<Question> list = questionService.getListByCriteria(quizDto);
        for (Question question : list) {
            questionMarks.add(QuestionMark.childBuilder().question(question).build());
        }
        return questionMarks;
    }



}

