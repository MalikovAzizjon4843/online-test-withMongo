package com.example.services.auth;

import com.example.mappers.UserMapper.UserMapper;
import com.example.dto.user.UserCreateDto;
import com.example.entity.auth.User;
import com.example.response.Data;
import com.example.response.ResponseEntity;
import com.example.respository.user.AuthRepository;
import com.example.services.AbstractService;
import com.example.utils.validator.UserValidator;

import java.util.ArrayList;
import java.util.Optional;

public class
AuthService extends AbstractService<AuthRepository, UserMapper> {
    private final UserValidator validator;

    public AuthService(AuthRepository repository, UserMapper mapper, UserValidator userValidator) {
        super(repository, mapper);
        this.validator = userValidator;
    }

    public ResponseEntity<Data<String>> login (String name, String password){
        try{
            Optional<User> byName = repository.getByName(name,password);
            if (byName.isEmpty()){
                return new ResponseEntity<>(new Data<>("You are not registered!"));
            }
            repository.login(byName.get());
            return new ResponseEntity<>(new Data<>("SuccessFully logged in"));
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public ResponseEntity<Data<String>> register (UserCreateDto dto){
        try{
            validator.validOnCreate(dto);
            Optional<User> byName = repository.getByName(dto.getUsername(), dto.getPassword());
            if (byName.isPresent()){throw new IllegalArgumentException();}
            User user1 = mapper.fromCreateDto(dto);
            user1.setQuizzes(new ArrayList<>());
            repository.register(user1);
            return new ResponseEntity<>(new Data<>("SuccessFully registered"));
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

}
