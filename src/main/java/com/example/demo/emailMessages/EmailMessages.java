package com.example.demo.emailMessages;

import com.example.demo.model.User;

public class EmailMessages {

    public static String createTittle (User user){
        return "Recuperacao de senha.";
    }

    public static String messageToNewUser(User user, String password){
        return "Ola, " +user.getNickname() + " sua nova senha e: " + password;
    }

}
