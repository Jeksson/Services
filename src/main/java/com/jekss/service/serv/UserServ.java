package com.jekss.service.serv;

import com.jekss.entityes.User;
import com.jekss.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jekss on 11.10.15.
 */
@Service
public class UserServ {
    @Autowired
    private UserRepository userRepository;


    public User addUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    public void delete(int id) {
        userRepository.delete(id);
    }

    public User getByName(String name) {
        return userRepository.findByName(name);
    }
    public User getById(int id){
        return userRepository.findOne(id);
    }
    public User getByLogin(String login){return userRepository.findByLogin(login);}
    public User getByEmail(String email){return userRepository.findByEmail(email);}
    public User editUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }


}
