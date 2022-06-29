package com.example.ui;

import com.example.configs.ApplicationContextHolder;
import com.example.configs.Session;
import com.example.dto.question.QuestionCreateDto;
import com.example.entity.quiz.Variant;
import com.example.enums.Language.Language;
import com.example.enums.Level;
import com.example.enums.Subject;
import com.example.utils.Color;
import com.example.utils.Input;
import com.example.utils.Print;
import com.example.services.question.QuestionService;

import java.util.ArrayList;
import java.util.List;

import static com.example.utils.Input.getStr;

public class QuestionUI {

    private static final QuestionService service = ApplicationContextHolder.getBean(QuestionService.class);

    public static void menu(){
        Print.println("1. Create Test");
        Print.println("2.Exit");
        String choice = Input.getStr("Choose please: ");
        byChoice(choice);
    }

    private static void byChoice(String choice) {
        switch (choice) {
            case "1" -> createQuestion();
            case "2" ->{
                Session.sessionUser = null;
                Menu.mainMenu();
            }
            default -> Print.println(Color.RED,"Wrong Choice");
        }
    }

    public static void createQuestion() {
        QuestionCreateDto build = QuestionCreateDto.builder().title(Input.getStr("Question title : "))
                .level(Level.getLevel(Input.getStr("Question Level : ")))
                .language(Language.getByCode(Input.getStr("Language : ")))
                .subject(Subject.getValue(Input.getStr("Subject : "))).build();
        List<Variant> variants = createVariant(new ArrayList<>());
        build.setVariants(variants);
        service.create(build);
    }

    public static List<Variant> createVariant( List<Variant> list) {

        String choose = Input.getStr("Add variant ? (quit) ");
        if (choose.startsWith("q")) return list;
        list.add(Variant.childBuilder().answer(Input.getStr("Answer : "))
                .correct(Input.getStr("Is true answer : (y/n) ").startsWith("y")).build());
        return createVariant(list);
    }
}
