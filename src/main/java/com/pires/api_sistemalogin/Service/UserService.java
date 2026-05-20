package com.pires.api_sistemalogin.Service;


import com.pires.api_sistemalogin.Repository.UserRepository;
import com.pires.api_sistemalogin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.util.Optional;


@Service
public class UserService {
    //fazendo injecao do repository e salvando no banco de dados
    @Autowired
    private UserRepository repository;

    public User registerUser(User user){
        return repository.save(user);
    }

    //funcao para verificar conta
    public boolean verify_account(User user){
        //procura o usuario,se o usuario existe ele passa pra variavel
        Optional<User> verify = repository.findByEmail(user.getEmail());
        //verifica se esta presente o email no usuario
        if (verify.isPresent()){
            //se existir armazena em uma variavel pra fazer a comparacao
            User user1 = verify.get();
            //da senha enviada e da senha encontrada no banco de dados
            return user1.getPassword().equals(user.getPassword());


        }
        else {
            return  false;
        }

    }
}
