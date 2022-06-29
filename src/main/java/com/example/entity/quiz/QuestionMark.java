package com.example.entity.quiz;

import lombok.*;
import org.bson.types.ObjectId;
import com.example.entity.Auditable;

import java.util.Date;
import java.util.Objects;


@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class QuestionMark extends Auditable {
    private Question question;
    private boolean right;
    private Variant variant = new Variant();
    private ObjectId chosenAnswerId;

    @Builder(builderMethodName = "childBuilder")
    public QuestionMark(ObjectId id, Date createdAt, boolean deleted, Question question, boolean right, Variant variant, ObjectId chosenAnswerId) {
        super(id, createdAt, deleted);
        this.question = question;
        this.right = right;
        this.variant = variant;
        this.chosenAnswerId = chosenAnswerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        QuestionMark that = (QuestionMark) o;
        return variant == that.variant && right == that.right && question.equals(that.question) && chosenAnswerId.equals(that.chosenAnswerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), question, right, variant, chosenAnswerId);
    }
}
