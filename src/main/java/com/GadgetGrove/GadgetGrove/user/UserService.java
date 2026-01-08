package com.GadgetGrove.GadgetGrove.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    private List<User> userList = new ArrayList<>();
    private Long nextId = 1L;

    public List<User> getAllUsers() {

        return userRepository.findAll();
        //return userList;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void addUser( User user) {
        //user.setId(nextId++);
       // userList.add(user);
        userRepository.save(user);
    }

    public boolean updateUser(Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setFirstName(updatedUser.getFirstName());
                    existingUser.setLastName(updatedUser.getLastName());
                    userRepository.save(existingUser);
            return true;
        }).orElse(false);
    }

}
