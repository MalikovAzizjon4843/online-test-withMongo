package com.example.configs;

import com.example.entity.auth.User;
import com.example.entity.quiz.Question;
import com.example.entity.quiz.Quiz;
import com.example.mappers.UserMapper.UserMapper;
import com.example.mappers.question.QuestionMapper;
import com.example.mappers.quiz.QuizMapper;
import com.example.services.auth.AuthService;
import com.example.services.question.QuestionMarkService;
import com.example.services.quiz.QuizService;
import com.example.services.users.UserService;
import com.example.utils.validator.QuestionValidator;
import com.example.utils.validator.UserValidator;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import com.example.respository.question.QuestionRepository;
import com.example.respository.quiz.QuizRepository;
import com.example.respository.user.AuthRepository;
import com.example.respository.user.UserRepository;
import com.example.services.question.QuestionService;
import com.example.ui.AuthUI;
import com.example.utils.BaseUtils;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class ApplicationContextHolder {
    private static MongoDatabase db;
    private final static UserRepository userRepository;
    private final static UserService userService;
    private final static UserMapper userMapper;
    private final static UserValidator userValidator;
    private final static Session SESSION;
    private final static QuestionRepository questionRepository;
    private final static QuestionMapper questionMapper;
    private final static QuestionValidator questionValidator;
    private final static QuestionService questionService;
    private final static BaseUtils utils;
    private final static QuizRepository quizRepository;
    private final static QuizMapper quizMapper;
    private final static QuizService quizService;
    private final static AuthRepository authRepository;
    private final static AuthService authService;
    private final static QuestionMarkService questionMarkService;
    private final static AuthUI authUI;

    static {
        connect();
        utils = new BaseUtils();
        SESSION = new Session();
        userValidator = new UserValidator(utils);
        questionValidator = new QuestionValidator(utils);
        authUI = new AuthUI();

        userMapper = new UserMapper();
        questionMapper = new QuestionMapper();
        quizMapper = new QuizMapper();

        authRepository = new AuthRepository(User.class);
        userRepository = new UserRepository(User.class);
        questionRepository = new QuestionRepository(Question.class);
        quizRepository = new QuizRepository(Quiz.class);

        userService = new UserService(userRepository, userMapper, userValidator);
        authService = new AuthService(authRepository, userMapper, userValidator);
        questionService = new QuestionService(questionRepository, questionMapper, questionValidator);
        questionMarkService = new QuestionMarkService();
        quizService = new QuizService(quizRepository, quizMapper);
    }

    public static <T> T getBean(Class<T> clazz) {
        return getBean(clazz.getSimpleName());
    }

    private static <T> T getBean(String beanName) {
        return switch (beanName) {
            case "MongoDatabase" -> (T) db;
            case "UserRepository" -> (T) userRepository;
            case "Session" -> (T) SESSION;
            case "UserService" -> (T) userService;
            case "UserMapper" -> (T) userMapper;
            case "UserValidator" -> (T) userValidator;
            case "QuestionRepository" -> (T) questionRepository;
            case "QuestionMapper" -> (T) questionMapper;
            case "QuestionValidator" -> (T) questionValidator;
            case "QuestionService" -> (T) questionService;
            case "QuizRepository" -> (T) quizRepository;
            case "QuizMapper" -> (T) quizMapper;
            case "QuizService" -> (T) quizService;
            case "AuthRepository" -> (T) authRepository;
            case "AuthService" -> (T) authService;
            case "QuestionMarkService" -> (T) questionMarkService;
            case "AuthUI" -> (T) authUI;
            default -> throw new RuntimeException("Bean Not Found");
        };
    }

    private static void connect() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).codecRegistry(codecRegistry).build();

        Logger rootLogger = Logger.getLogger("org.mongodb.driver");
        rootLogger.setLevel(Level.OFF);
        try {
            MongoClient mongoClient = MongoClients.create(clientSettings);
            db = mongoClient.getDatabase("quiz");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
