package com.example.ui;

import com.example.configs.ApplicationContextHolder;
import com.example.configs.Session;
import com.example.dto.user.UserCreateDto;
import com.example.services.users.UserService;
import com.example.utils.Color;
import com.example.utils.Input;
import com.example.utils.Print;
import org.bson.types.ObjectId;

import static com.example.utils.Input.getStr;

public class AdminUI {

    private static final UserService service = ApplicationContextHolder.getBean(UserService.class);

    public static void mainAdminMenu() {
        Print.println("1. Create user");
        Print.println("2. Update user");
        Print.println("3.Update role");
        Print.println("4. Get user");
        Print.println("5. Get list of users");
        Print.println("6.Exit");
        String choice = Input.getStr("Choose please: ");
        byAdminMenu(choice);
    }

    private static void byAdminMenu(String choice) {
        switch (choice) {
            case "1" -> createUser();
            case "2" -> mainAdminMenu();
            case "3" -> updateRole();
            case "4" -> getUser();
            case "5" -> getUserList();
            case "6" -> {
                Session.sessionUser = null;
                Menu.mainMenu();
            }
            default -> Print.println(Color.RED, "Wrong Choice");
        }
    }

    private static void getUserList() {
        service.getList();
        mainAdminMenu();
    }

    private static void getUser() {
        String id = Input.getStr("Enter the id please: ");
        ObjectId oId = new ObjectId(id);
        service.get(oId);
        mainAdminMenu();
    }

    private static void updateRole() {
        String id = Input.getStr("Enter the id please: ");
        ObjectId oId = new ObjectId(id);
        service.updateRole(oId);
        mainAdminMenu();
    }

    private static void createUser() {
        String username = Input.getStr("Username: ");
        String password = Input.getStr("Password: ");
        String firstName = Input.getStr("First name: ");
        String lastName = Input.getStr("Last name: ");
        String role = Input.getStr("Role: ");
        String language = Input.getStr("Language: ");
        UserCreateDto dto = new UserCreateDto(username, password, firstName, lastName, role, language);
        service.create(dto);
        mainAdminMenu();
    }
}
