package com.jekss.controller;

import com.jekss.entityes.User;
import com.jekss.service.registration.HashPasswordUser;
import com.jekss.service.registration.UserRegistrValidator;
import com.jekss.service.serv.RoleServ;
import com.jekss.service.serv.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jekss on 23.10.15.
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserServ userServ;
    @Autowired
    private RoleServ roleServ;
    private UserRegistrValidator userValidator = new UserRegistrValidator();

    @RequestMapping(method = RequestMethod.GET)
    public String registrPage(Model model){
        return "registrpage";
    }

    @RequestMapping(value = "login" ,method = RequestMethod.POST)
    @ResponseBody
    public Set<String> getLoginValid(@RequestParam(value = "text") String login){
        Set<String> result = new HashSet<>();
        User user = userServ.getByLogin(login);
        if(!userValidator.loginValidation(login)){
            result.add("<span class=\"error msg\" style=\"color: red; font-weight: bold;\">не корректный логин</span>");
        } else if (user != null) {
            if(user.getLogin().equals(login)){
                result.add("<span class=\"error msg\" style=\"color: red; font-weight: bold;\">такой логин уже существует</span>");
            }
        } else if (login.equals("")){
            result.add("<span class=\"error msg\" style=\"color: red; font-weight: bold;\">поле не должно быть пустым</span>");
        } else {
            result.add("<span class=\"ok msg\"></span>");
        }
        return result;
    }

    @RequestMapping(value = "name", method = RequestMethod.POST)
    @ResponseBody
    public Set<String> getNameValid(@RequestParam(value = "name") String name,
                                   @RequestParam(value = "login") String login){
        System.out.println(name);
        Set<String> result = new HashSet<>();

        if(!userValidator.nameValidation(name)){
            result.add("<span class=\"error msg\" style=\"color: red; font-weight: bold;\">не корректное имя</span>");
        } else if(name.equals("")){
            result.add("<span class=\"error msg\" style=\"color: red; font-weight: bold;\">поле не должно быть пустым</span>");
        } else if(name.equals(login)){
            result.add("<span class=\"error msg\" style=\"color: red; font-weight: bold;\">имя не должно совпадать с логином</span>");
        } else {
            result.add("<span class=\"ok msg\"></span>");
        }
        return result;
    }

    @RequestMapping(value = "email", method = RequestMethod.POST)
    @ResponseBody
    public Set<String> getEmailValid(@RequestParam(value = "text") String email){

        Set<String> result = new HashSet<>();
        User user = userServ.getByEmail(email);


        if (!userValidator.emailValidation(email)) {
            result.add("<span class=\"error msg\" style=\"color: red; font-weight: bold;\">не корректный email</span>");
        } else if (user != null) {
            if (user.getEmail().equals(email)) {
                result.add("<span class=\"error msg\" style=\"color: red; font-weight: bold;\">такой email уже существует</span>");
            }
        } else if (email.equals("")) {
            result.add("<span class=\"error msg\" style=\"color: red; font-weight: bold;\">поле не должно быть пустым</span>");
        } else {
            result.add("<span class=\"ok msg\"></span>");
        }

        return result;
    }

    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    @ResponseBody
    public Set<String> newUserAdd(@RequestParam(value = "login") String login,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "email") String email,
                             @RequestParam(value = "password") String password) throws NoSuchAlgorithmException {
        Set<String> result = new HashSet<>();
        HashPasswordUser hpu = new HashPasswordUser();
        User user = new User();
        user.setName(name);
        user.setLogin(login);
        user.setEmail(email);
        user.setPassword(hpu.salt(login, password));
        user.setRole(roleServ.getByIdRole(1));
        System.out.println(user.toString());
        //userServ.addUser(user);
        result.add("/");
        return result;
    }
}
