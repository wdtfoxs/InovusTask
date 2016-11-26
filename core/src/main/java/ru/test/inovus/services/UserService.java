package ru.test.inovus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.test.inovus.entity.User;
import ru.test.inovus.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void addUser(User user){
        userRepository.add(user);
    }

    @Transactional
    public boolean existsUserByUsername(String username){
        return userRepository.getUseByUsername(username) == null;
    }

    @Transactional
    public User getUserByUsername(String username){
        return userRepository.getUseByUsername(username);
    }
}
