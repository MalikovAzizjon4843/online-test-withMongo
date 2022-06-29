package com.example.dto.question;

import com.example.entity.quiz.Variant;
import lombok.*;
import com.example.dto.GenericBaseDto;
import com.example.enums.Language.Language;
import com.example.enums.Level;
import com.example.enums.Subject;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionCreateDto implements GenericBaseDto {
    private String title;
    private Level level;
    private Language language;
    private Subject subject;
    private List<Variant> variants;
}