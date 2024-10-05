package com.example.clubify.user;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class userService {
    @Autowired
    private userRepository userRepository;


    public List<user> findAllUser() { return userRepository.findAll(); }
    public void save(user user) {
        userRepository.save(user);
    }
    public user findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public user addUser(user user) {
        return userRepository.save(user);
    }

    public  user updateUser(user user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }



  public user signIn(user user) {
    user existingUser = userRepository.findByAdresseEmailAndMdp(user.getAdresseEmail(), user.getMdp());
    return existingUser;
  }

}


