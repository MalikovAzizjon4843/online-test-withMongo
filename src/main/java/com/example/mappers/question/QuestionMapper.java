package com.example.mappers.question;

import com.example.dto.GenericDto;
import com.example.dto.question.QuestionCreateDto;
import com.example.dto.question.QuestionUpdateDto;
import com.example.entity.quiz.Question;
import com.example.mappers.GenericMapper;

public class QuestionMapper implements GenericMapper<Question, GenericDto, QuestionCreateDto, QuestionUpdateDto> {
    @Override
    public Question fromDto(GenericDto dto) {
        return null;
    }

    @Override
    public Question fromCreateDto(QuestionCreateDto dto) {
        return Question.childBuilder()
                .subject(dto.getSubject())
                .language(dto.getLanguage())
                .title(dto.getTitle())
                .level(dto.getLevel())
                .variants(dto.getVariants()).build();
    }

    @Override
    public Question fromUpdateDto(QuestionUpdateDto dto) {
        return null;
    }

    @Override
    public GenericDto toDto(Question model) {
        return null;
    }
}