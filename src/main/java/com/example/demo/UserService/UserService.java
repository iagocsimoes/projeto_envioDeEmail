package com.example.demo.UserService;

import com.example.demo.emailMessages.EmailMessages;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private SendEmailService sendEmailService;

    public User user (User user) throws Exception {
        this.validUserData(user);
        var newUser = new User(user.getName(), user.getNickname(), user.getEmail());
        newUser.setPassword(UUID.randomUUID().toString());

        this.sendEmailService.enviar(user.getEmail(), EmailMessages.createTittle(user),
                EmailMessages.messageToNewUser(user, newUser.getPassword()));

        newUser.setPassword("*********");

        return newUser;
    }

    public void validUserData(User user) throws Exception {
        if(user.getName() == null || user.getEmail() == null || user.getNickname() == null){
            throw new Exception("Todas informacoes precisam ser preenchidas");
        }
    }

}
