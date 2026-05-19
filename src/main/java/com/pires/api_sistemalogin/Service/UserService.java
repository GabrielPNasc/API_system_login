package com.pires.api_sistemalogin.Service;


import com.pires.api_sistemalogin.Repository.UserRepository;
import com.pires.api_sistemalogin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User registerUser(User user){
        return repository.save(user);
    }
}
