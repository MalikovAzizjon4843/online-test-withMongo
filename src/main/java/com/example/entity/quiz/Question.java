package com.example.entity.quiz;

import lombok.*;
import org.bson.types.ObjectId;
import com.example.entity.Auditable;
import com.example.enums.Language.Language;
import com.example.enums.Level;
import com.example.enums.Subject;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Question extends Auditable {
    private String title;
    private Level level;
    private Language language;
    private Subject subject;
    private List<Variant> variants;

    @Builder(builderMethodName = "childBuilder")
    public Question(ObjectId id, Date createdAt, boolean deleted, String title, Level level, Language language, Subject subject, List<Variant> variants) {
        super(id, createdAt, deleted);
        this.title = title;
        this.level = level;
        this.language = language;
        this.subject = subject;
        this.variants = variants;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Question question = (Question) o;
        return title.equals(question.title) && level == question.level && language == question.language && subject == question.subject && variants.equals(question.variants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, level, language, subject, variants);
    }
}
