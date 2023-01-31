package com.example.backend.services;

import com.example.backend.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    User addUser(User user);

    List<User> getListUser();

    void deleteUser(Long id);

    User findById(Long id);

    Optional<User> findByUsername(String username);
}
