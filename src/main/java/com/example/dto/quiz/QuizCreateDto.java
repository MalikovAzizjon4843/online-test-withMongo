package com.example.dto.quiz;

import com.example.enums.Language.Language;
import lombok.*;
import com.example.dto.GenericBaseDto;
import com.example.enums.Level;
import com.example.enums.Subject;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizCreateDto implements GenericBaseDto {
    private Subject subject;
    private Level level;
    private Language language;
    private int  count;
    private boolean completed;

}
