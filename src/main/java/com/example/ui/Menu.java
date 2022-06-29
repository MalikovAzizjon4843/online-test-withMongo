package com.example.ui;

import com.example.configs.Session;
import com.example.enums.Role.Role;
import com.example.utils.Input;
import com.example.utils.Print;

public class Menu {
    public static void mainMenu() {
        if (Session.sessionUser == null) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Log out");
            String choose = Input.getStr("? : ");
            switch (choose) {
                case "1" -> AuthUI.login();
                case "2" -> AuthUI.register();
                case "3" -> {
                    Print.println("Good bye");
                    return;
                }
            }
        }else if(Session.sessionUser.getRole().equals(Role.ADMIN)){
            AdminUI.mainAdminMenu();
        }else if(Session.sessionUser.getRole().equals(Role.TEACHER)){
            QuestionUI.menu();
        }else if(Session.sessionUser.getRole().equals(Role.STUDENT)){
            QuizUI.menu();
        }
        mainMenu();
    }
}
