package com.example.backend.Controllers;

import com.example.backend.entities.User;
import com.example.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService ;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(method= RequestMethod.GET)
    public List<User> getList() {
        return userService.getListUser();
    }

    @RequestMapping(value="/add",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addUtilisateur(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.addUser(user);
    }
    @RequestMapping(value="/user/{id}",method=RequestMethod.GET)
    public User findbyId(@PathVariable Long id) {
        System.out.println("find by id d5al lel fonction c bon ");
        return userService.findById(id);
    }
    @RequestMapping(value="/username/{username}",method=RequestMethod.GET)
    public Optional<User> findbyEmail(@PathVariable String username) {
        return userService.findByUsername(username);
    }
}
